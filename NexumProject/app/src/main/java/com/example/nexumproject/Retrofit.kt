package com.example.nexumproject

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

class Retrofit {
    val retrofit = Retrofit.Builder()
        .baseUrl("http://44.212.184.96:8000")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService = retrofit.create(ApiService::class.java)
}