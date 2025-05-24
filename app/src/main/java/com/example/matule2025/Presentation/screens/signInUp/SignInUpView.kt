package com.example.matule2025.Presentation.screens.signInUp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.matule2025.Presentation.navigation.NavigationRoutes
import com.example.matule2025.Presentation.viewModel.AuthViewModel
import com.example.matule2025.R
import com.example.uikit.Button.BigButton
import com.example.uikit.Button.LogIn
import com.example.uikit.Components.Dialog
import com.example.uikit.Components.SpacerHeight
import com.example.uikit.Components.SpacerWi
import com.example.uikit.Input.TextFieldAndTitle
import com.example.uikit.UI.Accent
import com.example.uikit.UI.PlaceHolder
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White
import com.example.uikit.UI.localTypography
import org.koin.androidx.compose.koinViewModel
import androidx.compose.ui.res.stringResource

@Composable
fun SignInUpView(controller: NavHostController,viewModel: AuthViewModel) {

    val state = viewModel.state

    var isNotNull = if(state.email!="" && state.password!= "") true else false

    Dialog(state.error) {
        viewModel.updateState(state.copy(error = null, isLoading = false))
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)

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
                    stringResource(R.string.hello),
                    style = Typography().Caption2_Bold,
                    fontSize = 24.sp,
                    letterSpacing = -0.9.sp
                )
            }
            SpacerHeight(25)
            Text(
                "Войдите, чтобы пользоваться функциями приложения",
                style = Typography().Text_Reg, modifier = Modifier.padding(end = 40.dp)
            )
            SpacerHeight(64)
            TextFieldAndTitle("Вход по E-mail","example@mail.com",false,state.email) {viewModel.updateState(state.copy(email = it)) }
            TextFieldAndTitle("Пароль","",true,state.password) {viewModel.updateState(state.copy(password = it))}

            BigButton("Далее",click=false, enabled = isNotNull){viewModel.Auth(state.email,state.password,controller)}
            SpacerHeight(15)
            Text(
                "Забыл пароль?",
                style = Typography().Text_Reg, modifier = Modifier.align(Alignment.CenterHorizontally).clickable {
                    controller.navigate(NavigationRoutes.CREATEPASSWORD)
                }, color = Accent
            )
            SpacerHeight(59)
            Text(
                "Или войдите с помощью",
                style = Typography().Text_Reg, modifier = Modifier.align(Alignment.CenterHorizontally), color = PlaceHolder
            )
            SpacerHeight(16)

            LogIn(YanOnClick = {controller.navigate(NavigationRoutes.TG)}, VKonClick = {})

        }
    }
}