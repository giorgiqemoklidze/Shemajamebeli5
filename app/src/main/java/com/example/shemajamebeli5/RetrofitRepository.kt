package com.example.shemajamebeli5

import retrofit2.Response
import retrofit2.http.GET

interface RetrofitRepository {

    @GET("/v3/d531f5f5-180d-4364-bae7-791dae87f732")
    suspend fun getList (): Response<List<List<ItemsModel>>>

}