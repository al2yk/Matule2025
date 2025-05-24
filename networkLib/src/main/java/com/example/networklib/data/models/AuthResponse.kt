package com.example.networklib.data.models

import com.example.matule2025.Domain.models.User
import kotlinx.serialization.Serializable

@Serializable
data class AuthResponse(
    var token:String,
    var record: User
)

