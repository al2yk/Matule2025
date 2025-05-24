package com.example.matule2025.Presentation.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.matule2025.Presentation.navigation.NavigationRoutes
import com.example.matule2025.Presentation.viewModel.SplashViewModel
import com.example.matule2025.R
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White
import com.example.uikit.UI.localTypography
import org.koin.androidx.compose.koinViewModel
import org.koin.dsl.koinApplication

@Composable
fun SplashView(controller: NavHostController,viewModel: SplashViewModel = koinViewModel()) {

    LaunchedEffect(Unit) {
        viewModel.launch(controller)
    }


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF74C8E4),  // Синий (верхний левый угол)
                        Color(0xFF2254F5),  // Голубой (центр)
                        Color(0xFF74C8E4)   // Светло-голубой (нижний правый угол)
                    ),
                    start = Offset(0f, Float.POSITIVE_INFINITY),
                    end = Offset(Float.POSITIVE_INFINITY, 0f)
                )
            ), contentAlignment = Alignment.Center
    )
    {
        Text(
            stringResource(com.example.uikit.R.string.app),
            style = Typography().Caption2_Reg,
            fontSize = 40.sp,
            color = White
        )
    }
}