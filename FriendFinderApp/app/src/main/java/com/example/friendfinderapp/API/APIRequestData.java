package com.example.friendfinderapp.API;

import com.example.friendfinderapp.Model.ResponseModel;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface APIRequestData {

    @FormUrlEncoded
    @POST("API/getUserByEmail")
    Call<ResponseModel> ardGetDataUserByEmail(
            @Field("email") String email
    );


    @FormUrlEncoded
    @POST("API/register")
    Call<ResponseModel> ardAddData(
            @Field("fullname") String fullname,
            @Field("phone") String phone,
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("API/login")
    Call<ResponseModel> resLogin(
            @Field("email") String email,
            @Field("password") String password
    );


}