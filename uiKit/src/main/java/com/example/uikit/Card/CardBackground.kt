package com.example.uikit.Card

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Card_Strok
import com.example.uikit.UI.White

@Composable
fun CardBackground(sm: Int,colorBorder:Color) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(sm.dp)
            .clip(RoundedCornerShape(12.dp))
            .border(1.dp, colorBorder, RoundedCornerShape(12.dp))
            .background(White)
    )
}


