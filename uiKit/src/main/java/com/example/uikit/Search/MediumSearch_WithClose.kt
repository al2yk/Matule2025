package com.example.uikit.Search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.uikit.Components.SpacerWi
import com.example.uikit.UI.Accent
import com.example.uikit.UI.localTypography

@Composable
fun MediumSearch_WithClose(onSearch: (String) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        MediumSearch(onSearch = onSearch)
        SpacerWi(16)
        Text(
            "Отменить",
            style = localTypography.current.Caption_Reg,
            color = Accent,
            modifier = Modifier
                .weight(0.5f)
                .clickable { }
        )
    }
}