package com.example.matule2025.Presentation.state

import com.example.networklib.data.models.CategoryItem
import com.example.networklib.data.models.Product

data class MainState (
    val listCategory: List<CategoryItem> = emptyList(),
    val listProduct: List<Product> = emptyList(),
    val selected: CategoryItem? = null
   /* val selectedCategory: String? = null,
    val selectedCategoryID: String = ""*/
)