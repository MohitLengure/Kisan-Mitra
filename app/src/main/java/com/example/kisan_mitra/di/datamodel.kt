package com.example.kisan_mitra.di

import com.example.BASE_URL
import com.example.Base_url
import com.example.kisan_mitra.data.apiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object datamodel {
    @Provides
    @Singleton
    fun provideApiService(): apiService {
        return Retrofit.Builder()
            .baseUrl(Base_url) // Use your API base URL
            .addConverterFactory(GsonConverterFactory.create()) // or another converter
            .build()
            .create(apiService::class.java)
    }


}