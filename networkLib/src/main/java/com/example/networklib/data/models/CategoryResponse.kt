package com.example.networklib.data.models

import com.example.matule2025.Domain.models.CategoryItem
import kotlinx.serialization.Serializable

@Serializable
data class CategoryResponse(
    val items: List<CategoryItem>? = null
)



