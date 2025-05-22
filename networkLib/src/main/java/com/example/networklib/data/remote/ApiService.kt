package com.example.networklib.data.remote

import com.example.networklib.data.models.AuthRequest
import com.example.networklib.data.models.AuthResponse
import com.example.networklib.data.models.CategoryResponse
import com.example.networklib.data.models.ProductResponse
import com.example.networklib.data.models.RegistationResponse
import com.example.networklib.data.models.RegistrationRequest

interface ApiService {
    suspend fun login(request: AuthRequest):AuthResponse
    suspend fun registration(request: RegistrationRequest):RegistationResponse
    suspend fun getcategory():CategoryResponse
    suspend fun getProduct():ProductResponse

}