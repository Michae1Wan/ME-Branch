package com.michae1.codechallenge.di

import com.michae1.codechallenge.data.datasource.RemoteDataSource
import com.michae1.codechallenge.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//TODO this needs to be changed into the url running the api service
const val BASE_URL = "http://10.0.0.101:5000"

/**
 *
 * Created by Michae1 (michae1wan@live.com) on 7/23/2020.
 */
@Module
@InstallIn(ApplicationComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideApiService() : ApiService =  Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    @Singleton
    @Provides
    fun provideRemoteDataSource (apiService : ApiService) : RemoteDataSource = RemoteDataSource(apiService)
}