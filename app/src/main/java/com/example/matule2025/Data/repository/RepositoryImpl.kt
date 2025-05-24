package com.example.matule2025.Data.repository

import com.example.networklib.data.models.CategoryResponse
import com.example.networklib.data.models.ApiError
import com.example.networklib.data.models.AuthRequest
import com.example.networklib.data.models.AuthResponse
import com.example.networklib.data.models.NetworkResult
import com.example.networklib.data.models.ProductResponse
import com.example.networklib.data.models.ProfileRequest
import com.example.networklib.data.models.ProfileResponse
import com.example.networklib.data.models.RegistationResponse
import com.example.networklib.data.models.RegistrationRequest
import com.example.networklib.network.monitor.NetworkMonitor
import com.example.networklib.data.remote.ApiCall
import com.example.networklib.data.remote.ApiService
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
        }
        catch (e:Exception){
            NetworkResult.Error(
                ApiError(
                    1,
                    e.message.toString()
                )
            )
        }
    }

    override suspend fun registration(request: RegistrationRequest): NetworkResult<RegistationResponse> {
        return try {
            ApiCall(networkMonitor){
                apiService.registration(request)
            }
        }catch (e:Exception){
            NetworkResult.Error(
                ApiError(
                    2,
                    e.message.toString()
                )
            )
        }
    }

    override suspend fun getCategory(): NetworkResult<CategoryResponse> {

        return try {
          ApiCall(networkMonitor){
              apiService.getcategory()
          }
        }catch (e:Exception){
            NetworkResult.Error(
                ApiError(
                    3,
                    e.message.toString()
                )
            )
        }
    }

    override suspend fun getProduct(): NetworkResult<ProductResponse> {
        return try {
            ApiCall(networkMonitor){
                apiService.getProduct()
            }
        }catch (e:Exception){
             NetworkResult.Error(
                 ApiError(
                     4,
                     e.message.toString()
                 )
             )
        }
    }

    override suspend fun getProfile(request: ProfileRequest): NetworkResult<ProfileResponse> {
        return try {
            ApiCall(networkMonitor){
                apiService.getProfile(request)
            }
        }catch (e:Exception){
            NetworkResult.Error(
                ApiError(
                    5,
                    e.message.toString()
                )
            )
        }
    }


}