package com.example.uikit.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Input_Backgroud
import com.example.uikit.UI.localTypography

@Composable
fun Circle(i: Int,modifier: Modifier=Modifier,onClick:()->Unit) {

    var ColorBox = Input_Backgroud
    Box(
        modifier = modifier
            .size(80.dp)
            .clip(CircleShape)
            .background(ColorBox)
            .clickable {
               onClick()
            }, contentAlignment = Alignment.Center
    ) {

        Text(
            i.toString(),
            style = localTypography.current.Title1_SemiBold
        )
    }
}