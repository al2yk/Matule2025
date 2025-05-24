package com.example.uikit.Card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uikit.Components.SpacerHeight
import com.example.uikit.R
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Black
import com.example.uikit.UI.Input_Backgroud
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White
import com.example.uikit.UI.localTypography

@Composable
fun MedicalCardTwo(
    Img: String,
    name: String,
    surname: String,
    click: Boolean,
    onClick: (Boolean) -> Unit
) {
    var color = Accent
    var textcolor = White
    if (!click) {
        color = Input_Backgroud
        textcolor = Black
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .clip(RoundedCornerShape(25))
            .background(color)
            .clickable {
                onClick(!click)
            },
        contentAlignment = Alignment.CenterStart
    ) {
        Image(
            painter = painterResource(R.drawable.male),
            contentDescription = "",
            modifier = Modifier
                .size(40.dp)
                .padding(start = 12.dp)
        )
        Text(
            "${name} ${surname}",
            style = Typography().Headline_Med,
            modifier = Modifier.padding(start = 50.dp),
            color = textcolor
        )
    }
    SpacerHeight(16)
}