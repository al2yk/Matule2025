@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)

package com.example.uikit.Select

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Black
import com.example.uikit.UI.Description
import com.example.uikit.UI.Input_Backgroud
import com.example.uikit.UI.Input_Strok
import com.example.uikit.UI.PlaceHolder
import com.example.uikit.UI.Typography
import com.example.uikit.UI.localTypography


@Composable
fun GenderDropdownMenu(value:String,oncheck:(String)->Unit) {
    val genderOptions = listOf("Мужской", "Женский", "Другое")
    var open by remember { mutableStateOf(false) }


    ExposedDropdownMenuBox(
        expanded = open,
        onExpandedChange = {
            open = !open
        }
    ) {
        TextField(
            readOnly = true,
            shape = RoundedCornerShape(10.dp),
            value = value,
            onValueChange = { },
            placeholder = { Text("Пол", style = Typography().Text_Reg, color = PlaceHolder) },
            trailingIcon = {
                Icon(
                    painter = painterResource(R.drawable.down),
                    contentDescription = "",
                    tint = Description
                )
            },
            colors = TextFieldDefaults.colors(
                disabledIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledTextColor = Black,
                cursorColor = Accent,
                focusedTextColor = Black,
                focusedContainerColor = Input_Backgroud,
                unfocusedTextColor = Black,
                unfocusedContainerColor = Input_Backgroud,
                disabledContainerColor = Input_Backgroud,
            ),
            modifier = Modifier
                .border(1.dp, Input_Strok, RoundedCornerShape(10.dp))
                .menuAnchor()
                .fillMaxWidth()
                .height(50.dp),
            textStyle = Typography().Text_Reg
        )


        ExposedDropdownMenu(
            expanded = open,
            onDismissRequest = { open = false }
        ) {
            genderOptions.forEach { gender ->
                DropdownMenuItem(
                    text = { Text(gender) },
                    onClick = {
                        oncheck(gender)
                        open = false
                    }
                )
            }
        }
    }
}