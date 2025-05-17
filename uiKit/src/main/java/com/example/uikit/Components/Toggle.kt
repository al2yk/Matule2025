package com.example.uikit.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Input_Strok
import com.example.uikit.UI.White

@Composable
fun ToggleSwitch(isChecked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    val trackColor = if (isChecked) Accent else Input_Strok

    Box(
        modifier = Modifier
            .size(56.dp, 32.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(trackColor)
            .clickable { onCheckedChange(!isChecked) }

    ) {
        Box(
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.CenterStart)
                .offset(x = if (isChecked) 29.dp else 3.dp)
                .clip(CircleShape)
                .background(White)
        )
    }
}

@Composable
fun ToggleSwitchExample() {
    var isChecked by remember { mutableStateOf(false) }

    Column{
        ToggleSwitch(isChecked = isChecked, onCheckedChange = { isChecked = it })
    }
}