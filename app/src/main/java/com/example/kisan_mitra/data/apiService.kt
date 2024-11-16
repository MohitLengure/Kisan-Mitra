package com.example.kisan_mitra.data

import com.example.kisan_mitra.data.response.Signup
import com.example.kisan_mitra.data.response.loginresponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface apiService {

    @FormUrlEncoded
    @POST("signUp")
    suspend fun SignUpUser(
        @Field("name") name: String,
        @Field("password") password: String,
        @Field("email") email: String,
        @Field("phone_number") phone_number: String
    ): Response<Signup>



    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String,
    ):Response<loginresponse>

}