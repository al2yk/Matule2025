package com.example.networklib.data.models

import android.telecom.Call.Details

//для понимания что за ошибка
data class ApiError (
    val code:Int,
    val message:String,
    val details: Map<String,String> = emptyMap()
    //ещё можно details
)