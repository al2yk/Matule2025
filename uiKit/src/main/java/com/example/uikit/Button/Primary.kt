package com.example.uikit.Button

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.uikit.Card.CardBackground
import com.example.uikit.Components.SpacerHeight
import com.example.uikit.UI.PlaceHolder
import com.example.uikit.UI.localTypography

@Composable
fun Primary(Title: String, Sub: String, cost: String, click: Boolean, enabled: Boolean, onClick: (Boolean) -> Unit) {

    Box(modifier = Modifier.fillMaxWidth()) {
        CardBackground(136)
        Column(modifier = Modifier.padding(16.dp)) {
            Text(Title, style = localTypography.current.Headline_Med)
            SpacerHeight(16)
            Box(modifier = Modifier.fillMaxWidth()) {
                Column {
                    Text(Sub, style = localTypography.current.Caption_Semi, color = PlaceHolder)
                    SpacerHeight(4)

                    Text(text = "$cost ₽", style = localTypography.current.Headline_Med)
                }


                //кнопка
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                ) {
                    SmallButton(click, enabled) {
                        onClick(!click)
                    }
                }
            }
        }
    }
}