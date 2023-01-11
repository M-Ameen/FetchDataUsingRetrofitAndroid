package com.example.retrofitfetchlivedata

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
    val apiinterface by lazy {
        retrofit.create(ApiInterface::class.java)
    }

}