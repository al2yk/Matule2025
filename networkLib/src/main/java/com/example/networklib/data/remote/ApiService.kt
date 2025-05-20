package com.example.networklib.data.remote

import com.example.networklib.data.models.AuthRequest
import com.example.networklib.data.models.AuthResponse

interface ApiService {
    suspend fun login(request: AuthRequest):AuthResponse

}