package com.example.data.repository

import com.example.network.api.ApiInterface
import javax.inject.Inject

class AppRepository @Inject constructor(
    private val api: ApiInterface,
) {
    // fetch the data
    suspend fun fetchRepo(query: String, sort: String, order: String, perPage: Int) =
        api.searchRepositories(query = query, sort = sort, order = order, perPage = perPage)
}

