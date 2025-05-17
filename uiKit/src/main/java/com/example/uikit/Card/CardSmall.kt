package com.example.uikit.Card

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Black
import com.example.uikit.UI.Input_Icon
import com.example.uikit.UI.localTypography

@Composable
fun CardSmall(Title: String, enadled: Boolean, Cost: String) {

    var colorB = Black
    if (!enadled) colorB = Input_Icon
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
    ) {
        CardBackground(60, colorB)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(start = 16.dp, end = 16.dp)
        ) {
            Text(
                Title,
                style = localTypography.current.Caption2_Reg,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(end = 100.dp),
                color = colorB
            )
            Text(
                "${Cost} ₽",
                style = localTypography.current.Text_Reg,
                modifier = Modifier.align(Alignment.CenterEnd),
                color = colorB
            )

        }

    }
}


