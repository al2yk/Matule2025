package com.example.uikit.Input

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Black
import com.example.uikit.UI.Input_Backgroud
import com.example.uikit.UI.Input_Strok
import com.example.uikit.UI.Typography
import com.example.uikit.UI.localTypography

@Composable
fun OTPBox(
    value: String,
    onValChange: (String) -> Unit
) {
    var isWriting by remember { mutableStateOf(false) }

    TextField(
        value = value,
        onValueChange = {
            // Allow only one character
            if (it.length <= 1) onValChange(it)
        },
        singleLine = true,
        shape = RoundedCornerShape(10.dp),
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
        maxLines = 1,
        modifier = Modifier
            .border(1.dp, Input_Strok, RoundedCornerShape(10.dp))
            .size(50.dp) // Ensure size allows for one character
            .clickable {
                isWriting = true
            },
        textStyle = Typography().Title2_Regular.copy(
            textAlign = TextAlign.Center
        ),
    )
}