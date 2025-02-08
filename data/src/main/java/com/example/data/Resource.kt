package com.example.data

sealed class Resource<out T> {
    data object Loading: Resource<Nothing>()
    data class Error(var errorMessage: String? = null): Resource<Nothing>()
    data class Success<T>(val data: T): Resource<T>()
}