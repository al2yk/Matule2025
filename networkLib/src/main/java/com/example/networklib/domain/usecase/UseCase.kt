package com.example.networklib.domain.usecase

import com.example.networklib.data.models.AuthRequest
import com.example.networklib.data.models.AuthResponse
import com.example.networklib.data.models.NetworkResult
import com.example.networklib.domain.repository.Repository

class UseCase(private val Repository:Repository) {
    suspend operator fun invoke(email:String,password:String):NetworkResult<AuthResponse>{
        return Repository.login(AuthRequest(email,password))
    }
}