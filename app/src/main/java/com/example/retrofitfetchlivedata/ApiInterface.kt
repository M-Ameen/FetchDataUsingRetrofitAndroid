package com.example.retrofitfetchlivedata

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("products/1")
    fun getData(): Call<ResponseDataclass>
}