package com.example.networklib.domain.repository

import com.example.networklib.data.models.AuthRequest
import com.example.networklib.data.models.AuthResponse
import com.example.networklib.data.models.CategoryResponse

import com.example.networklib.data.models.NetworkResult
import com.example.networklib.data.models.ProductResponse
import com.example.networklib.data.models.ProfileRequest
import com.example.networklib.data.models.ProfileResponse
import com.example.networklib.data.models.RegistationResponse
import com.example.networklib.data.models.RegistrationRequest

interface Repository {
    suspend fun login(request: AuthRequest):NetworkResult<AuthResponse>
    suspend fun registration(request: RegistrationRequest):NetworkResult<RegistationResponse>
    suspend fun getCategory():NetworkResult<CategoryResponse>
    suspend fun getProduct():NetworkResult<ProductResponse>
    suspend fun getProfile(request: ProfileRequest):NetworkResult<ProfileResponse>
}