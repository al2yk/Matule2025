package com.example.networklib.data.models

import kotlinx.serialization.Serializable

@Serializable
data class RegistrationRequest(
    var email:String,
    var password:String,
    var passwordConfirm:String,
    var name:String,
    var surname:String,
    var gender:String,
    var telegram:String,
    var dateBirthday:String,
    var lastname:String,
)