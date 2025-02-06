package com.example.di

import com.example.network.ApiClient
import com.example.network.api.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    // Provide the interface for the API
    @Singleton
    @Provides
    fun provideInterface(): ApiInterface {
        return ApiClient.getRetrofit().create(ApiInterface::class.java)
    }
}
