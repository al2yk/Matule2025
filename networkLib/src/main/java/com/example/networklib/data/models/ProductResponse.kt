package com.example.networklib.data.models

import kotlinx.serialization.Serializable

@Serializable
data class ProductResponse (
    val items: List<com.example.matule2025.Data.models.Product>? = null

)
