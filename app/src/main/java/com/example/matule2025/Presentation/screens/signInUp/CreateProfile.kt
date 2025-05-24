package com.example.matule2025.Presentation.screens.signInUp

import NameInputField_WithoutChangeBorder
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.matule2025.Presentation.viewModel.AuthViewModel
import com.example.uikit.Button.BigButton
import com.example.uikit.Components.Dialog
import com.example.uikit.Components.SpacerHeight
import com.example.uikit.Select.Date
import com.example.uikit.Select.GenderDropdownMenu
import com.example.uikit.UI.PlaceHolder
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White
import com.example.uikit.UI.localTypography
import org.koin.androidx.compose.koinViewModel

@Composable
fun CreateProfile(controller: NavHostController,viewModel:AuthViewModel) {
    val state = viewModel.state
    LaunchedEffect(Unit) {
        Log.d("44",state.dateBirthday)
    }
    Dialog(state.error) {
        viewModel.updateState(state.copy(error = null, isLoading = false))
    }

    var isNotNull = if(state.name!= "" && state.surname!= ""&& state.lastname!= ""&& state.gender!= ""&& state.telegram!= ""&& state.dateBirthday!= "") true else false
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

            Text(
                "Создание Профиля",
                style = Typography().Caption2_Bold,
                fontSize = 24.sp
            )
            SpacerHeight(44)
            Text(
                "Без профиля вы не сможете создавать проекты",
                style = Typography().Caption_Reg, color = PlaceHolder
            )
            SpacerHeight(8)

            Text(
                "В профиле будут храниться результаты проектов и ваши описания.",
                style = Typography().Caption_Reg, color =  PlaceHolder
            )
            SpacerHeight(32)

            NameInputField_WithoutChangeBorder(state.name,"Имя"){viewModel.updateState(state.copy(name = it))
                Log.i("StateAUTH",state.toString())
            }
            SpacerHeight(24)
            NameInputField_WithoutChangeBorder(state.lastname,"Отчество"){viewModel.updateState(state.copy(lastname = it))}
            SpacerHeight(24)
            NameInputField_WithoutChangeBorder(state.surname,"Фамилия"){viewModel.updateState(state.copy(surname = it))}
            SpacerHeight(24)
            Date(state.dateBirthday){ viewModel.updateState(state.copy(dateBirthday = it)) }
            SpacerHeight(24)
            GenderDropdownMenu(state.gender){viewModel.updateState(state.copy(gender = it))}
            SpacerHeight(24)
            NameInputField_WithoutChangeBorder(state.telegram,"Telegram"){viewModel.updateState(state.copy(telegram = it))}
            SpacerHeight(68)
            BigButton("Создать",click=false, enabled = isNotNull){viewModel.Registration(controller)}
        }
    }
}