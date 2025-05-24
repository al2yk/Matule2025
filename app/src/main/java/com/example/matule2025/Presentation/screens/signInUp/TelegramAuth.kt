package com.example.matule2025.Presentation.screens.signInUp

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.uikit.Bubble.BoxBack
import com.example.uikit.Components.SpacerHeight
import com.example.uikit.Components.SpacerWi
import com.example.uikit.Input.OTPBox
import com.example.uikit.UI.Accent
import com.example.uikit.UI.PlaceHolder
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White
import com.example.uikit.UI.localTypography
import kotlinx.coroutines.delay

@Composable
fun TgAuth(controller: NavHostController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White)

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 80.dp)
        ) {

            BoxBack { controller.navigateUp() }
            SpacerHeight(132)
            Text(
                "Введите код из Telegram",
                style = Typography().Title3_Semi,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            SpacerHeight(24)
            Row(modifier = Modifier
                .width(250.dp)
                .align(Alignment.CenterHorizontally)) {
                OTPBox("") {}
                SpacerWi(16)
                OTPBox("") {}
                SpacerWi(16)
                OTPBox("") {}
                SpacerWi(16)
                OTPBox("") {}
            }
            SpacerHeight(16)
            SimpleCountdownTimer()

        }
    }
}
@Composable
fun SimpleCountdownTimer(
    initialTime: Int = 60,
    onTimerEnd: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    var currentTime by remember { mutableStateOf(initialTime) }
    var isActive by remember { mutableStateOf(true) }

    // Запускаем таймер
    LaunchedEffect(key1 = currentTime, key2 = isActive) {
        if (isActive && currentTime > 0) {
            delay(1000) // Ждем 1 секунду
            currentTime--
        } else if (currentTime == 0) {
            onTimerEnd()
        }
    }

    // Отображаем только секунды
    Text(
        text = buildAnnotatedString {
            append("Отправить код повторно можно будет через ")
            withStyle(style = SpanStyle(color = PlaceHolder)) {
                append(currentTime.toString())
            }
            append(" секунд")
        },
        style = Typography().Text_Reg,
        textAlign = TextAlign.Center,
        color = PlaceHolder,
        modifier = modifier.padding(horizontal = 60.dp)
    )
}