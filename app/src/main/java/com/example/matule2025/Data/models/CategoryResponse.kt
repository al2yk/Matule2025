package com.example.matule2025.Data.models

import com.example.networklib.data.models.CategoryItem
import kotlinx.serialization.Serializable

@Serializable
data class CategoryResponse(
    val items: List<CategoryItem>? = null
)



