package com.example.uikit.Button

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.uikit.Components.SpacerHeight
import com.example.uikit.R

@Composable
fun LogIn(VKonClick:()->Unit,YanOnClick:()->Unit){

    LogInButton(stringResource(R.string.vk), R.drawable.vk) { VKonClick() }
    SpacerHeight(16)
    LogInButton(stringResource(R.string.yan), R.drawable.yan) { YanOnClick() }
}