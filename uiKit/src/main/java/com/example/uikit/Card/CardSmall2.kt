package com.example.uikit.Card

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.uikit.Components.CheckBox
import com.example.uikit.Components.SpacerHeight
import com.example.uikit.UI.Black
import com.example.uikit.UI.Input_Icon
import com.example.uikit.UI.Input_Strok
import com.example.uikit.UI.localTypography

@Composable
fun CardSmall2(Title: String, enadled: Boolean, Cost: String) {

    var check by remember { mutableStateOf(enadled) }
    var colorB = Black
    if (!check) colorB = Input_Icon
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(41.dp)

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(32.dp)
        ) {

            Box(modifier = Modifier.align(Alignment.CenterStart)) {
                CheckBox(check) { new ->
                    check = !check
                }
            }
            Text(
                Title,
                style = localTypography.current.Caption2_Reg,
                modifier = Modifier.padding(start = 36.dp, end = 100.dp),
                color = colorB
            )
            Text(
                "${Cost} ₽",
                style = localTypography.current.Text_Reg,
                modifier = Modifier.align(Alignment.CenterEnd),
                color = colorB
            )
        }
        Divider(modifier = Modifier.align(Alignment.BottomStart), color = Input_Strok)
    }

    SpacerHeight(16)
}