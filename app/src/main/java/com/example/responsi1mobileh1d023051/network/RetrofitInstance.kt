package com.example.responsi1mobileh1d023051.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.responsi1mobileh1d023051.utils.Constants

object RetrofitInstance {
    val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}

