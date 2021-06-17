package org.d3if4203.assesment2.network

import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {

    @GET("catat.json")
    fun getData(): Call<MainModel>
}