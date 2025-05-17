package com.example.uikit.Button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Description
import com.example.uikit.UI.Input_Backgroud
import com.example.uikit.UI.White
import com.example.uikit.UI.localTypography

@Composable
fun Chips(Title: String, click: Boolean, onClick: (Boolean) -> Unit) {

    var colorBox = Accent
    var textColor = White

    if (!click) {
        colorBox = Input_Backgroud
        textColor = Description
    }

    Box(
        modifier = Modifier
            .width(128.dp)
            .height(48.dp)
            .clip(RoundedCornerShape(20))
            .background(colorBox)
            .clickable {

            },
        contentAlignment = Alignment.Center
    ) {
        Text(Title, style = localTypography.current.Text_Med, color = textColor)
    }
}