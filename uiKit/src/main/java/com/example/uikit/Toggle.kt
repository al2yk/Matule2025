package com.example.uikit

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Input_Icon
import com.example.uikit.UI.localTypography

@Composable
fun ToggleComponent() {
    var checkedState by remember { mutableStateOf(false) }
    Switch(checked = checkedState, onCheckedChange = { checkedState = it })
}

@Composable
fun CounterComponent() {
    var count by remember { mutableStateOf(0) }
    Row {
        Button(onClick = { count-- }) { Text("-",fontFamily = FontFamily(Font(R.font.heavy)), color = Accent) }
        Text(text = "$count")
        Button(onClick = { count++ }) { Text("привет мир",style = localTypography.current.Text_Reg) }

        Icon(painter = painterResource(R.drawable.left), contentDescription = "", tint = Input_Icon)
    }
}


