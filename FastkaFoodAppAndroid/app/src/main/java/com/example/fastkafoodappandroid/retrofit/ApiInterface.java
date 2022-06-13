package com.example.fastkafoodappandroid.retrofit;

import com.example.fastkafoodappandroid.Model.Recommended;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface
{
    @GET("recommended.php")
    Call<List<Recommended>> getdata();



    @FormUrlEncoded
    @POST("add_cart.php")
    Call<Recommended> insertFood(
            @Field("key") String key,
            @Field("title") String name,
            @Field("price") String species,
            @Field("amount") String amount,
            @Field("picture") String picture);

}
