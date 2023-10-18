package com.example.hiltandroidapp.data.remote.repository

import android.app.Application
import com.example.hiltandroidapp.R
import com.example.hiltandroidapp.data.remote.MyApi
import com.example.hiltandroidapp.domain.repository.MyRepository

class MyRepositoryImpl(
    private val api: MyApi,
    private val appContext: Application
) : MyRepository {

    init {
        val appName = appContext.getString(R.string.app_name)
        println("Hello from the repository, The app name is $appName")
    }
    override suspend fun doNetworkCall() {
        TODO("Not yet implemented")
    }
}