package com.example.uikit.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Input_Backgroud
import com.example.uikit.UI.Input_Icon
import com.example.uikit.UI.Input_Strok
import com.example.uikit.UI.PlaceHolder

@Composable
fun Counter(count: Int, onCountChange: (Int) -> Unit) {

    var colorMinus = Color.Blue
    if (count == 1) {
        colorMinus = Input_Icon
    } else {
        colorMinus = PlaceHolder
    }

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .width(64.dp)
            .height(32.dp)
            .background(Input_Backgroud)
    ) {

        Row(
            modifier = Modifier.align(Alignment.Center),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(R.drawable.minus),
                contentDescription = "",
                modifier = Modifier.clickable {
                    if (count > 1) {
                        onCountChange(count - 1)
                    }
                }, tint = colorMinus
            )
            Spacer(modifier = Modifier.width(5.dp))
            VerticalDivider(color = Input_Strok, modifier = Modifier.height(16.dp))
            Spacer(modifier = Modifier.width(5.dp))
            Icon(painter = painterResource(R.drawable.plus), contentDescription = "",
                modifier = Modifier.clickable {
                        onCountChange(count + 1)
                }, tint = PlaceHolder
            )
        }

    }
}