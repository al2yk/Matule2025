package com.example.networklib.data.models

import kotlinx.serialization.Serializable

@Serializable
data class User(
    var id:String,
    var name:String,
    var surname:String,
    var phoneNum:String
)