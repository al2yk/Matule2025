package com.example.matule2025.Presentation.state

import java.lang.Error

data class AuthState (
    var email:String = "",
    var password:String = "",
    var isLoading:Boolean = false,
    var isSuccess:Boolean =false,
    var error: String?=null,
    var isNotInternet:Boolean = false
)