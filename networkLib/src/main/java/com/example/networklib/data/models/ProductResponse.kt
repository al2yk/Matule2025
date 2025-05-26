package com.example.networklib.data.models

import kotlinx.serialization.Serializable

@Serializable
data class ProductResponse (
    val items: List<Product>? = null

)
