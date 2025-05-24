package com.example.matule2025.Data.models

import kotlinx.serialization.Serializable

@Serializable
data class User(
    var id:String,
    var name:String,
    var surname:String,
    var phoneNum:String
)