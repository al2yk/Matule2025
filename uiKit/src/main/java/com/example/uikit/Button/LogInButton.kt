package com.example.uikit.Button

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uikit.Components.SpacerWi
import com.example.uikit.UI.Black
import com.example.uikit.UI.Input_Strok
import com.example.uikit.UI.White
import com.example.uikit.UI.localTypography

@Composable
fun LogInButton(Title: String, Img: Int, onClick: () -> Unit) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .border(1.dp, Input_Strok, RoundedCornerShape(15.dp))
            .clip(RoundedCornerShape(25))
            .background(White)
            .clickable {

            },
        contentAlignment = Alignment.Center
    ) {
        Row(horizontalArrangement = Arrangement.Center) {
            //Добавить картинку лого сервиса
            Image(
                painter = painterResource(Img),
                contentDescription = "",
                modifier = Modifier.size(32.dp)
            )
            SpacerWi(10)
            Text(
                Title,
                style = localTypography.current.Title3_Semi,
                color = Black,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }

    }

}