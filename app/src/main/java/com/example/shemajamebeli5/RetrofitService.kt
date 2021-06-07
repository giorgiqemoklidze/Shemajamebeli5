package com.example.shemajamebeli5

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    private const val BASE_URL = "https://run.mocky.io/"
    const val API_ENDPOINT = "v3/d531f5f5-180d-4364-bae7-791dae87f732"

    fun RetrofitService() :RetrofitRepository{

        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitRepository::class.java)
    }
}