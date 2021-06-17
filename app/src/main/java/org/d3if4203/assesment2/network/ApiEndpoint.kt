package org.d3if4203.assesment2.network

import retrofit2.http.GET

interface ApiEndpoint {

    @GET("ass.json")
    fun getphotos()
}