package com.example.uikit.Button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Blue
import com.example.uikit.UI.White
import com.example.uikit.UI.localTypography

@Composable
fun Cart(Cost: String, onClick: () -> Unit) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(20))
            .background(Accent)
            .clickable {
                onClick()
            }, contentAlignment = Alignment.Center
    ) {
        Box(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
            Icon(
                painter = painterResource(R.drawable.shopping_cart),
                contentDescription = "",
                tint = White,
                modifier = Modifier.size(20.dp)
            )
            Text(
                "В корзину",
                style = localTypography.current.Title3_Semi,
                color = White,
                modifier = Modifier.padding(start = 36.dp)
            )
            Text(
                "$Cost ₽",
                style = localTypography.current.Title3_Semi,
                color = White,
                modifier = Modifier.align(
                    Alignment.CenterEnd
                )
            )

        }

    }
}