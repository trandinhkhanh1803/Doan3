package com.example.fastkafoodappandroid.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fastkafoodappandroid.Model.CartData;
import com.example.fastkafoodappandroid.R;

import java.util.ArrayList;

public class CheckOutActivity extends AppCompatActivity {

    private EditText ed_email;
    private TextView txtPrice,txtDelivery,txtTotal;
    private Button payment;
   private ProgressBar progressBar;

    String[] items =  {"Payment on delivery","Payment by other form"};
    AutoCompleteTextView autoCompleteTxt;
    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        inview();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String total = extras.getString("total");
            txtTotal.setText(total);
            String email = extras.getString("email");
            ed_email.setText(email);
            String total_price = extras.getString("price");
            txtPrice.setText(total_price);
            String delivery = extras.getString("delivery");
            txtDelivery.setText(delivery);
        }



        adapterItems = new ArrayAdapter<String>(this,R.layout.list_item,items);
        autoCompleteTxt.setAdapter(adapterItems);

        autoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"Item: "+item,Toast.LENGTH_SHORT).show();
            }
        });

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payment.setVisibility(View.GONE);
                progressBar.setVisibility(View.VISIBLE);
               CartActivity.clearCard();
                 startActivity(new Intent(CheckOutActivity.this,OrderComplete.class));

            }
        });



    }

    private void inview() {
        autoCompleteTxt = findViewById(R.id.auto_complete_txt);
        ed_email = findViewById(R.id.ed_email);
        txtPrice = findViewById(R.id.txt_total_price);
        txtDelivery = findViewById(R.id.txt_fee_delivery);
        txtTotal = findViewById(R.id.txt_total);
        payment = findViewById(R.id.payment);
        progressBar = findViewById(R.id.progressBar2);
    }
}