package com.example.uikit.Input

import NameInputField_WithoutChangeBorder
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.uikit.Components.SpacerHeight
import com.example.uikit.UI.Description
import com.example.uikit.UI.PlaceHolder
import com.example.uikit.UI.Typography
import com.example.uikit.UI.localTypography

@Composable
fun TextFieldAndTitle(
    title: String,
    plh:String,
    isPass:Boolean,
    value: String,
    onValChange: (String) -> Unit
) {
    Box(modifier = Modifier.fillMaxWidth().height(76.dp))
    {
        Text(
            title, style = Typography().Caption_Reg, color = Description
        )
        Box(modifier = Modifier.align(Alignment.BottomStart)) {
            NameInputField_WithoutChangeBorder(value,plh,isPass) { onValChange(it) }
        }
    }
    SpacerHeight(14)
}