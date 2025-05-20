package com.example.networklib.data.remote

import com.example.networklib.data.models.ApiError
import com.example.networklib.data.models.NetworkResult
import com.example.networklib.data.network.NetworkMonitor
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.plugins.ResponseException
import kotlinx.serialization.SerializationException


suspend fun <T> ApiCall(
    networkMonitor: NetworkMonitor,
    apiCall: suspend () -> T
): NetworkResult<T> = try {
    if (!networkMonitor.isConnected()) NetworkResult.NoInternet else NetworkResult.Success(apiCall())
} catch (e: Exception) {
    NetworkResult.Error(when(e){
        is SerializationException -> ApiError(-1,"SerializationException")
        is HttpRequestTimeoutException -> ApiError(408,"Request timeout")
        is ErrorM ->ApiError(400,"Invalid credentials")
        is ResponseException ->ApiError(e.response.status.value,e.response.toString())
        else -> ApiError(-1,e.message ?:"unknown error")
    })
}
