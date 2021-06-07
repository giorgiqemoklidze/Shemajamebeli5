package com.example.shemajamebeli5

import com.example.shemajamebeli5.RetrofitService.API_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitRepository {

    @GET(API_ENDPOINT)
    suspend fun getList (): Response<List<List<ItemsModel>>>

}