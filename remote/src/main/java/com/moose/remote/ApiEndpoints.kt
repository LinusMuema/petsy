package com.moose.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiEndpoints {

    @GET("/facts/{animal}")
    suspend fun getFact(@Path("animal") animal: String): Fact

    @GET("/img/{animal}")
    suspend fun getImage(@Path("animal") animal: String): Image
}