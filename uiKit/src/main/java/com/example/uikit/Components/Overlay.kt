package com.example.uikit.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import com.example.uikit.UI.Black

@Composable
fun Overlay(){
    Box(modifier = Modifier.fillMaxSize().alpha(0.7f).background(Black))
}