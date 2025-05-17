package com.example.uikit.Button

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import com.example.uikit.UI.Description
import com.example.uikit.UI.Green
import com.example.uikit.UI.PlaceHolder
import com.example.uikit.UI.Success
import com.example.uikit.UI.localTypography

@Composable
fun MenuButton(count:String){


    Box(modifier = Modifier.fillMaxWidth().height(64.dp), contentAlignment = Alignment.CenterStart){
        Icon(
            painter = painterResource(R.drawable.menubutton),
            contentDescription = "",
            tint = Green,
            modifier = Modifier.size(32.dp)
        )

        Column(modifier = Modifier.padding(start = 52.dp)) {
            Text("Результаты расчета", style = localTypography.current.Title3_Semi)
            SpacerHeight(8)
            Text("${count} новый результат", style = localTypography.current.Caption_Reg, color = PlaceHolder)

        }
    }
}