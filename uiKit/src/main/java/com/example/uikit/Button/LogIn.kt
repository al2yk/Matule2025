package com.example.uikit.Button

import androidx.compose.runtime.Composable
import com.example.uikit.Components.SpacerHeight
import com.example.uikit.R

@Composable
fun LogIn(VKonClick:()->Unit?,YanOnClick:()->Unit?){

    LogInButton("Войти с VK", R.drawable.vk) { VKonClick() }
    SpacerHeight(16)
    LogInButton("Войти с Yandex", R.drawable.yan) { YanOnClick() }
}