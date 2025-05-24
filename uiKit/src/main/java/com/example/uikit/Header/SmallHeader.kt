package com.example.uikit.Header

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uikit.Bubble.BoxBack
import com.example.uikit.R
import com.example.uikit.UI.Input_Icon
import com.example.uikit.UI.Typography
import com.example.uikit.UI.localTypography

@Composable
fun SmallHeader() {

    Box(modifier = Modifier.fillMaxWidth().padding(end = 6.dp)) {
        BoxBack {}

        Text(
            "Корзина", style = Typography().Title2_SemiBold,
            modifier = Modifier
                .align(Alignment.Center)
        )
        Icon(
            painter = painterResource(R.drawable.delete),
            contentDescription = "",
            tint = Input_Icon,
            modifier = Modifier
                .size(20.dp)
                .align(Alignment.CenterEnd)
        )
    }
}