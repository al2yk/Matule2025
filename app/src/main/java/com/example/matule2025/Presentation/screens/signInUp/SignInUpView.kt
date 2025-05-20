package com.example.matule2025.Presentation.screens.signInUp

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.matule2025.Presentation.viewModel.AuthViewModel
import com.example.matule2025.R
import com.example.uikit.Button.BigButton
import com.example.uikit.Button.LogIn
import com.example.uikit.Components.SpacerHeight
import com.example.uikit.Components.SpacerWi
import com.example.uikit.Input.TextFieldAndTitle
import com.example.uikit.UI.Accent
import com.example.uikit.UI.PlaceHolder
import com.example.uikit.UI.White
import com.example.uikit.UI.localTypography
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignInUpView(viewModel: AuthViewModel = koinViewModel()) {

    val state = viewModel.state

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

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.Bottom) {
                Image(
                    painter = painterResource(R.drawable.emojies),
                    modifier = Modifier.size(32.dp),
                    contentDescription = ""
                )
                SpacerWi(16)
                Text(
                    "Добро пожаловать!",
                    style = localTypography.current.Caption2_Bold,
                    fontSize = 24.sp
                )
            }
            SpacerHeight(25)
            Text(
                "Войдите, чтобы пользоваться функциями приложения",
                style = localTypography.current.Text_Reg, modifier = Modifier.padding(end = 40.dp)
            )
            SpacerHeight(64)
            TextFieldAndTitle("Вход по E-mail","example@mail.com",false,state.email) {viewModel.updateState(state.copy(email = it)) }
            TextFieldAndTitle("Пароль","",true,state.password) {viewModel.updateState(state.copy(password = it))}

            BigButton("Далее",click=true, enabled = false){}
            SpacerHeight(15)
            Text(
                "Забыл пароль?",
                style = localTypography.current.Text_Reg, modifier = Modifier.align(Alignment.CenterHorizontally), color = Accent
            )
            SpacerHeight(59)
            Text(
                "Или войдите с помощью",
                style = localTypography.current.Text_Reg, modifier = Modifier.align(Alignment.CenterHorizontally), color = PlaceHolder
            )
            SpacerHeight(16)

            LogIn(YanOnClick = {}, VKonClick = {})

        }
    }
}