package com.example.uikit.Search

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun MediumSearch(onSearch:(String)->Unit){
    var searchText by remember { mutableStateOf("") }
    TextField(
        shape = RoundedCornerShape(10.dp),
        value = searchText,
        onValueChange = {
            searchText = it
            onSearch(it)
        },
        placeholder = {
            Text(
                "Искать описание",
                style = Typography().Headline_Reg,
                color = PlaceHolder
            )
        },
        trailingIcon = {
            Icon(
                painter = painterResource(R.drawable.close),
                contentDescription = "",
                tint = Description, modifier = Modifier.clickable { searchText = "" }
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.search),
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
            .height(50.dp),
        textStyle = Typography().Headline_Reg
    )
}