package com.example.uikit.Components

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.AlertDialog
import androidx.compose.runtime.Composable

@Composable
fun Dialog(error:String?,onDismiss:()->Unit){

    if (error!=null){

        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text("Error")},
            text = { Text(error)},
            confirmButton = {
                Button(onClick = onDismiss) {
                    Text("Ок")
                }
            }
        )
    }
}