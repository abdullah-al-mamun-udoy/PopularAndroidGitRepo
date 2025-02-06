package com.example.popularandroidgitrepo.presentation.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.Resource
import com.example.data.repository.AppRepository
import com.example.network.model.GitAndroidRepositoryResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

//@HiltViewModel
//class HomeScreenViewModel @Inject constructor(
//    private val appRepo: AppRepository
//) : ViewModel() {
//
//    init {
//        getGitRepo(
//            query = "Android",
//            sort = "stars",
//            order = "desc",
//            perPage = 20
//        )
//    }
//
//    private val _fetchRepo =
//        MutableStateFlow<Resource<GitAndroidRepositoryResponse>>(Resource.Loading)
//    val fetchRepo = _fetchRepo.asStateFlow()
//
//    fun getGitRepo(
//        query: String,
//        sort: String,
//        order: String,
//        perPage: Int
//    ) {
//        viewModelScope.launch {
//            try {
//                val response =
//                    appRepo.fetchRepo(query = query, sort = sort, order = order, perPage = perPage)
//                _fetchRepo.value = Resource.Success(response)
//            } catch (e: Exception) {
//                _fetchRepo.value = Resource.Error(e.message ?: "Failed to fetch data")
//            }
//        }
//    }
//}

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val appRepo: AppRepository
) : ViewModel() {

    private val _fetchRepo =
        MutableStateFlow<Resource<GitAndroidRepositoryResponse>>(Resource.Loading)
    val fetchRepo = _fetchRepo.asStateFlow()

    private val _isLoading = MutableStateFlow(true) // Track loading state
    val isLoading = _isLoading.asStateFlow()

    init {
        getGitRepo(
            query = "Android",
            sort = "stars",
            order = "desc",
            perPage = 20
        )
    }

    fun getGitRepo(
        query: String,
        sort: String,
        order: String,
        perPage: Int
    ) {
        viewModelScope.launch {
            try {
                _isLoading.value = true // Set loading to true before the API call
                val response = appRepo.fetchRepo(query = query, sort = sort, order = order, perPage = perPage)
                _fetchRepo.value = Resource.Success(response)
                _isLoading.value = false // Set loading to false when data is fetched
            } catch (e: Exception) {
                _fetchRepo.value = Resource.Error(e.message ?: "Failed to fetch data")
                _isLoading.value = false // Set loading to false in case of an error
            }
        }
    }
}
