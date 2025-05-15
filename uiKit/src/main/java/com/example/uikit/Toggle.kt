package com.example.uikit

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun ToggleComponent() {
    var checkedState by remember { mutableStateOf(false) }
    Switch(checked = checkedState, onCheckedChange = { checkedState = it })
}

@Composable
fun CounterComponent() {
    var count by remember { mutableStateOf(0) }
    Row {
        Button(onClick = { count-- }) { Text("-") }
        Text(text = "$count")
        Button(onClick = { count++ }) { Text("+") }
    }
}


