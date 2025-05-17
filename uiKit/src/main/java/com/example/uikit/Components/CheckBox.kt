package com.example.uikit.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Input_Backgroud
import com.example.uikit.UI.Input_Strok
import com.example.uikit.UI.White

@Composable
fun CheckBox(check: Boolean, onCheck: (Boolean) -> Unit) {

    var colorBox = Color.White
    var colorBorder = Color.Transparent
    if (check) {
        colorBox = Accent
    } else {
        colorBox = Input_Backgroud
        colorBorder = Input_Strok
    }

    Box(
        modifier = Modifier
            .size(20.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(colorBox)
            .border(1.dp, colorBorder, RoundedCornerShape(8.dp))
            .clickable {
                onCheck(!check)
            },
        contentAlignment = Alignment.Center
    ) {
        if (check) {
            Icon(painter = painterResource(R.drawable.check), contentDescription = "", tint = White, modifier = Modifier.size(12.dp))
        }
    }
}