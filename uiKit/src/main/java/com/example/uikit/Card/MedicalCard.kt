package com.example.uikit.Card

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uikit.Components.SpacerHeight
import com.example.uikit.R
import com.example.uikit.UI.Input_Strok
import com.example.uikit.UI.PlaceHolder
import com.example.uikit.UI.Typography
import com.example.uikit.UI.localTypography

@Composable
fun MedicalCard(Img: String, name: String, surname: String, email: String, onClick: () -> Unit) {

    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterStart){
        CardBackground(72, Input_Strok)
        Image(
            painter = painterResource(R.drawable.male),
            contentDescription = "",
            modifier = Modifier
                .size(48.dp)
                .padding(start = 16.dp)
        )

        Column(modifier = Modifier.padding(start = 64.dp)) {
            Text("${name} ${surname}", style = Typography().Headline_Med)
            SpacerHeight(4)
            Text(email, style = Typography().Caption_Reg, color = PlaceHolder)
        }
    }

/*
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .border(1.dp, Card_Strok, RoundedCornerShape(15.dp))
            .clip(RoundedCornerShape(25))
            .background(White)
            .clickable {
                onClick()
            },
        contentAlignment = Alignment.CenterStart
    ) {
        Image(
            painter = painterResource(R.drawable.male),
            contentDescription = "",
            modifier = Modifier
                .size(48.dp)
                .padding(start = 16.dp)
        )

        Column(modifier = Modifier.padding(start = 64.dp)) {
            Text("${name} ${surname}", style = localTypography.current.Headline_Med)
            SpacerHeight(4)
            Text(email, style = localTypography.current.Caption_Reg, color = PlaceHolder)
        }

    }*/
}

