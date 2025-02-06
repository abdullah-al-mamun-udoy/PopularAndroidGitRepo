package com.example.network.api

import com.example.network.model.GitAndroidRepositoryResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiInterface {
    //----------------------------------Details

    @GET("search/repositories")
    suspend fun searchRepositories(
        @Query("q") query: String = "Android",
        @Query("sort") sort: String = "stars",
        @Query("order") order: String = "desc",
        @Query("per_page") perPage: Int = 10
    ): GitAndroidRepositoryResponse

}