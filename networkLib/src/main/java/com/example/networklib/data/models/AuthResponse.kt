package com.example.networklib.data.models

import kotlinx.serialization.Serializable

@Serializable
data class AuthResponse(
    var token:String,
    var record: User
)

