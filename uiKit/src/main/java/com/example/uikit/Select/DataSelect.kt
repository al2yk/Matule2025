package com.example.uikit.Select

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uikit.Components.SpacerHeight
import com.example.uikit.R
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Black
import com.example.uikit.UI.Description
import com.example.uikit.UI.Input_Backgroud
import com.example.uikit.UI.Input_Strok
import com.example.uikit.UI.PlaceHolder
import com.example.uikit.UI.localTypography
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateSelection() {
    var openDialog by remember { mutableStateOf(false) }
    val dateState = rememberDatePickerState()
    val formatter = SimpleDateFormat("dd MMMM yyyy", Locale("ru"))
    val selectedDate = dateState.selectedDateMillis?.let { formatter.format(Date(it)) } ?: "Сегодня, 16 апреля"

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            "Дата", style = localTypography.current.Caption_Reg, color = Description
        )
        SpacerHeight(4)
        TextField(
            readOnly = true,
            shape = RoundedCornerShape(10.dp),
            value = selectedDate,
            onValueChange = { },
            placeholder = { Text("Пол", style = localTypography.current.Text_Reg, color = PlaceHolder) },
            trailingIcon = {
                Icon(
                    painter = painterResource(R.drawable.down),
                    contentDescription = "",
                    tint = Description, modifier = Modifier.clickable { openDialog = true  }
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
                .fillMaxWidth()
                .height(50.dp),
            textStyle = localTypography.current.Text_Reg
        )

        if (openDialog) {
            DatePickerDialog(
                onDismissRequest = { openDialog = false },
                confirmButton = {
                    TextButton(onClick = {
                        openDialog = false
                    }) {
                        Text("Подтвердить")
                    }
                },
                dismissButton = {
                    TextButton(onClick = {
                        openDialog = false
                    }) {
                        Text("Отмена")
                    }
                }
            ) {
                DatePicker(state = dateState)
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Date() {
    var openDialog by remember { mutableStateOf(false) }
    val dateState = rememberDatePickerState()
    val formatter = SimpleDateFormat("dd MMMM yyyy", Locale("ru"))
    val selectedDate = dateState.selectedDateMillis?.let { formatter.format(Date(it)) } ?: ""

        TextField(
            readOnly = true,
            shape = RoundedCornerShape(10.dp),
            value = selectedDate,
            onValueChange = { },
            placeholder = { Text("Дата рождения", style = localTypography.current.Text_Reg, color = PlaceHolder) },
            trailingIcon = {
                Icon(
                    painter = painterResource(R.drawable.down),
                    contentDescription = "",
                    tint = Description, modifier = Modifier.clickable { openDialog = true  }
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
                .fillMaxWidth()
                .height(50.dp),
            textStyle = localTypography.current.Text_Reg
        )

        if (openDialog) {
            DatePickerDialog(
                onDismissRequest = { openDialog = false },
                confirmButton = {
                    TextButton(onClick = {
                        openDialog = false
                    }) {
                        Text("Подтвердить")
                    }
                },
                dismissButton = {
                    TextButton(onClick = {
                        openDialog = false
                    }) {
                        Text("Отмена")
                    }
                }
            ) {
                DatePicker(state = dateState)
            }
        }
}