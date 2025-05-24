package com.example.uikit.UI

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable


private val LightColorScheme = lightColorScheme(
    background = White,
    tertiary = Black,

)

private val DarkColorScheme = darkColorScheme(
    background = Black,
    tertiary = White,

)

@Composable
fun Matule2025UiKit(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
){

    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        content = content,
        shapes = Shapes()
    )
}