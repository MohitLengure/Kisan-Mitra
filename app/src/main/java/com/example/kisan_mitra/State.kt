package com.example.kisan_mitra

sealed class State<out T> {
    object Loading : State<Nothing>() // Represents loading Result
    data class Success<out T>(val data: T) : State<T>() // Represents success with data
    data class Error(val message: String) : State<Nothing>() // Represents error Result
}
