package com.example.hiltandroidapp.core.di

import com.example.hiltandroidapp.campussheba.data.remote.ShebaServiceApi
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val BASE_URL = "https://campus-sheba-d1da85ca92cb.herokuapp.com/"
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(
            GsonBuilder().create()
        ))
            .baseUrl(BASE_URL).build()
    }
    @Provides
    @Singleton
    fun provideShebaServiceApi(retrofit: Retrofit): ShebaServiceApi {
        return retrofit.create(ShebaServiceApi::class.java)
    }

}
