package com.example.uikit.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.uikit.Button.Chips

@Composable
fun ChipsLazyRow(
    categories: List<String>,
    selectedCategory:String? = categories[0],
    onCategoryClick: (String) -> Unit
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(categories) { category ->
            Chips(
                sm =126 ,
                Title = category,
                click = category==  selectedCategory,
                onClick = {
                    onCategoryClick(category)
                }
            )
        }
    }
}
