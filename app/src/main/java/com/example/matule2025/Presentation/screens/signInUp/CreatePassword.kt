package com.example.matule2025.Presentation.screens.signInUp

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
import androidx.navigation.NavHostController
import com.example.matule2025.Presentation.viewModel.CreatePasswordViewModel
import com.example.matule2025.R
import com.example.uikit.Button.BigButton
import com.example.uikit.Components.SpacerHeight
import com.example.uikit.Components.SpacerWi
import com.example.uikit.Input.TextFieldAndTitle
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White
import com.example.uikit.UI.localTypography
import org.koin.androidx.compose.koinViewModel

@Composable
fun CreatePassword(controller: NavHostController,viewModel: CreatePasswordViewModel = koinViewModel()) {

    val state = viewModel.state

    var isNotNull = if(state.password1!="" && state.password2!= "") true else false
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
                    "Cоздание пароля",
                    style = Typography().Caption2_Bold,
                    fontSize = 24.sp
                )
            }
            SpacerHeight(23)
            Text(
                "Введите новый пароль",
                style = Typography().Text_Reg, modifier = Modifier.padding(end = 40.dp)
            )
            SpacerHeight(90)

            TextFieldAndTitle("Новый Пароль","",true,state.password1) {viewModel.updateState(state.copy(password1 = it)) }
            TextFieldAndTitle("Повторите пароль","",true,state.password2) {viewModel.updateState(state.copy(password2 = it)) }
            BigButton("Далее",click=false, enabled = isNotNull){}

        }
    }
}