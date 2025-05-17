package com.example.uikit.Card

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uikit.Components.SpacerHeight
import com.example.uikit.R
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Black
import com.example.uikit.UI.Description
import com.example.uikit.UI.Input_Strok
import com.example.uikit.UI.PlaceHolder
import com.example.uikit.UI.Success
import com.example.uikit.UI.localTypography

@Composable
fun AnalisysCard(Title: String, date: String, isBuy: Boolean) {

    Box(modifier = Modifier.fillMaxWidth().height(142.dp)) {
        CardBackground(142, Input_Strok)
        Box(modifier = Modifier.padding(16.dp)) {
            Icon(
                painter = painterResource(R.drawable.horizontal),
                contentDescription = "",
                tint = Black,
                modifier = Modifier
                    .size(20.dp)
                    .align(Alignment.TopEnd)
            )

            Icon(
                painter = painterResource(R.drawable.download),
                contentDescription = "",
                tint = Description,
                modifier = Modifier
                    .size(20.dp)
                    .align(Alignment.BottomEnd)
            )

            Column(Modifier.fillMaxSize()) {
                Text(
                    Title,
                    style = localTypography.current.Headline_Med,
                    modifier = Modifier.padding(end = 100.dp)
                )
                SpacerHeight(4)
                Text(date, style = localTypography.current.Caption_Reg, color = PlaceHolder)
            }
            Text(
                text = if (isBuy) "Куплено" else "В продаже",
                style = localTypography.current.Headline_Med,
                color = if (isBuy) Success else Accent,
                modifier = Modifier.align(Alignment.BottomStart)
            )
        }
    }
}