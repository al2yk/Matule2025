package com.example.uikit.Components

import android.widget.Space
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SpacerHeight(sm:Int){
    Spacer(modifier = Modifier.height(sm.dp))
}

@Composable
fun SpacerWi(sm:Int){
    Spacer(modifier = Modifier.width(sm.dp))
}