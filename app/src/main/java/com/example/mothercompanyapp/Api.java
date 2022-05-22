package com.example.mothercompanyapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface Api {

    @GET("allchickens")
    Call<List<ChickenAsset>> getAllChickens();

    @POST("initledger")
    Call<RequestResponse> initLedger(@Body RequestBody body);

    @PUT("addchicken")
    Call<RequestResponse> addchicken(@Body ChickenAsset body);

}