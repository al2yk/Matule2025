package com.example.uikit.Button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Input_Backgroud
import com.example.uikit.UI.Typography
import com.example.uikit.UI.localTypography

@Composable
fun ChipsTwo(sm:Int,Title: String, click: Boolean, onClick: (Boolean) -> Unit) {


    Box(
        modifier = Modifier
            .width(sm.dp)
            .height(48.dp)
            .clip(RoundedCornerShape(20))
            .background(Input_Backgroud)
            .clickable {

            },
        contentAlignment = Alignment.Center
    ) {
        Text(Title, style = Typography().Text_Med,)
    }
}