package com.example.networklib.data.repository

import com.example.networklib.data.models.ApiError
import com.example.networklib.data.models.AuthRequest
import com.example.networklib.data.models.AuthResponse
import com.example.networklib.data.models.NetworkResult
import com.example.networklib.data.network.NetworkMonitor
import com.example.networklib.data.remote.ApiCall
import com.example.networklib.data.remote.ApiService
import com.example.networklib.data.remote.UserIsNotFound
import com.example.networklib.domain.repository.Repository

class RepositoryImpl(
    private val apiService: ApiService,
    private val networkMonitor: NetworkMonitor
) : Repository {

    override suspend fun login(request: AuthRequest): NetworkResult<AuthResponse> {
        return try {
            ApiCall(networkMonitor) {
                apiService.login(request)
            }
        }catch (e:UserIsNotFound){
            NetworkResult.UserNotFound
        }
        catch (e:Exception){
            NetworkResult.Error(ApiError(1,e.message.toString()))
        }
    }
}