package com.example.networklib.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoryItem(
    @SerialName("title")
    val title: String,
    val id:String
)