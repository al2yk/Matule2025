package com.example.networklib.domain.repository

import com.example.networklib.data.models.AuthRequest
import com.example.networklib.data.models.AuthResponse
import com.example.networklib.data.models.NetworkResult

interface Repository {
    suspend fun login(request: AuthRequest):NetworkResult<AuthResponse>

}