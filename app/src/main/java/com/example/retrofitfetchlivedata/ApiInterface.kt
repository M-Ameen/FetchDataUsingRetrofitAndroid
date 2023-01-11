package com.example.retrofitfetchlivedata

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("1")
    fun getData(): Call<ResponseDataclass>
}