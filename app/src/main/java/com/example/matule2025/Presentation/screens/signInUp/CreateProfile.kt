package com.example.matule2025.Presentation.screens.signInUp

import NameInputField_WithoutChangeBorder
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.uikit.Button.BigButton
import com.example.uikit.Components.SpacerHeight
import com.example.uikit.Select.Date
import com.example.uikit.Select.GenderDropdownMenu
import com.example.uikit.UI.PlaceHolder
import com.example.uikit.UI.White
import com.example.uikit.UI.localTypography

@Composable
fun CreateProfile(controller: NavHostController) {
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
                style = localTypography.current.Caption2_Bold,
                fontSize = 24.sp
            )
            SpacerHeight(44)
            Text(
                "Без профиля вы не сможете создавать проекты",
                style = localTypography.current.Caption_Reg, color = PlaceHolder
            )
            SpacerHeight(8)

            Text(
                "В профиле будут храниться результаты проектов и ваши описания.",
                style = localTypography.current.Caption_Reg, color =  PlaceHolder
            )
            SpacerHeight(32)

            NameInputField_WithoutChangeBorder("","Имя"){}
            SpacerHeight(24)
            NameInputField_WithoutChangeBorder("","Отчество"){}
            SpacerHeight(24)
            NameInputField_WithoutChangeBorder("","Фамилия"){}
            SpacerHeight(24)
            Date()
            SpacerHeight(24)
            GenderDropdownMenu()
            SpacerHeight(24)
            NameInputField_WithoutChangeBorder("","Telegram"){}
            SpacerHeight(68)
            BigButton("Создать",click=false, enabled = false){}


        }
    }
}