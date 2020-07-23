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
        //TODO this needs to be changed into the url running the api service
        .baseUrl("http://10.0.0.101:5000")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    @Singleton
    @Provides
    fun provideRemoteDataSource (apiService : ApiService) : RemoteDataSource = RemoteDataSource(apiService)
}