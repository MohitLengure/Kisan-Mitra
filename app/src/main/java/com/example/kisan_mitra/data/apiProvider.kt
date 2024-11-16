package com.example.kisan_mitra.data

import com.example.Base_url
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object apiProvider {

    fun provideApi()= Retrofit.Builder()
        .baseUrl(Base_url)
        .client(OkHttpClient.Builder().build())
        .addConverterFactory(
            GsonConverterFactory.create()
        ).build().create(apiService::class.java)

}