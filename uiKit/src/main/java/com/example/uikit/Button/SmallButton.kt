package com.example.uikit.Button

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Accent_inactive
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White
import com.example.uikit.UI.localTypography

@Composable
fun SmallButton(click: Boolean, enabled: Boolean, onClick: (Boolean) -> Unit) {

    var colorBox = White
    var BorderColor = Accent
    var textColor = Accent
    var textBox = "Убрать"
    if (!click) {
        colorBox = Accent
        BorderColor = Color.Transparent
        textColor = White
        textBox = "Добавить"
    }
    if (!enabled) {
        colorBox = Accent_inactive
        BorderColor = Color.Transparent
        textColor = White
        textBox = "Добавить"
    }

    Box(
        modifier = Modifier
            .width(96.dp)
            .height(40.dp)
            .border(1.dp, BorderColor, RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(20))
            .background(colorBox)
            .clickable {
                onClick(!click)
            },
        contentAlignment = Alignment.Center
    ) {
        Text(textBox, style = Typography().Caption_Semi, color = textColor)
    }
}

