package com.example.retromodule

import retrofit2.Call
import retrofit2.http.*
import java.util.ArrayList

interface WebService {
//    @GET("send-request")
//    fun getUsers(
//        @Query("api_token") String token
//    ): Call<ApiResponse<ArrayList<Users?>?>?>?

    @POST("send-request")
    fun getUsers(
        @Body  dtoSendJson: DtoSendJson,
    ): Call<ApiResponse<ArrayList<Users?>?>?>?
}