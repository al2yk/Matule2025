package com.example.matule2025.Presentation.state

import com.example.networklib.data.models.CategoryItem
import com.example.matule2025.Data.models.Product

data class MainState (
    val listCategory: List<CategoryItem> = emptyList(),
    val listProduct: List<Product> = emptyList(),
    val selected: CategoryItem? = null,
    val TabSelected:Int = 0,
    val name: String = "",
    val numberPhone: String = "",
    val notification: Boolean = false,


    var isLoading:Boolean = false,
    var isSuccess:Boolean =false,
    var error: String?=null,
    var isNotInternet:Boolean = false
)