package com.example.networklib.data.models


//какой ответ от сервера
sealed class NetworkResult<out T>(){
    data class Success<out T>(val data:T):NetworkResult<T>()
    data class Error(val error:ApiError):NetworkResult<Nothing>()
    object Loading:NetworkResult<Nothing>()
    object NoInternet:NetworkResult<Nothing>()
    object UserNotFound:NetworkResult<Nothing>()
}