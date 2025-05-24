package com.example.networklib.data.models

import kotlinx.serialization.Serializable
/*
@Serializable
data class ProfileResponse (
    val items:ProfileResponse1
)*/
@Serializable
data class ProfileResponse(
    val name:String,
    val surname:String,
    val lastname:String,
    val phoneNum:String,
    val dateBirthday:String,
    val telegram:String,
    val gender:String,
)

