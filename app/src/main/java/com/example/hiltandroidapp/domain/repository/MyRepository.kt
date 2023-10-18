package com.example.hiltandroidapp.domain.repository

interface MyRepository {
    suspend fun doNetworkCall()
}