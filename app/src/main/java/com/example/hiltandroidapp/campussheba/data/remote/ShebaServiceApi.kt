package com.example.hiltandroidapp.campussheba.data.remote

import com.example.hiltandroidapp.campussheba.data.model.ShebaService
import retrofit2.Response
import retrofit2.http.GET

interface ShebaServiceApi {
    @GET("/api/v1/categories")
    suspend fun getShebaData(): Response<ShebaService>
}
