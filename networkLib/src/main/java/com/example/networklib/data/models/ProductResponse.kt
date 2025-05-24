package com.example.networklib.data.models

import com.example.matule2025.Domain.models.Product
import kotlinx.serialization.Serializable

@Serializable
data class ProductResponse (
    val items: List<Product>? = null

)
