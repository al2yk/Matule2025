package com.example.matule2025.Data.models

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id:String,
    val title:String,
    val category:String,
    val cost:String
)