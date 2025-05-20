package com.example.uikit.Search

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uikit.Components.SpacerWi
import com.example.uikit.R
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Black
import com.example.uikit.UI.Description
import com.example.uikit.UI.Input_Backgroud
import com.example.uikit.UI.Input_Strok
import com.example.uikit.UI.PlaceHolder
import com.example.uikit.UI.localTypography

@Composable
fun BigSearch(onSearch:(String)->Unit){

    var searchText by remember { mutableStateOf("") }

    TextField(
        shape = RoundedCornerShape(10.dp),
        value = searchText,
        onValueChange = {
            searchText = it
            onSearch(it)
        },
        placeholder = { Text("Искать описание", style = localTypography.current.Headline_Reg, color = PlaceHolder) },
        trailingIcon = {
            Icon(
                painter = painterResource(R.drawable.close),
                contentDescription = "",
                tint = Description, modifier = Modifier.clickable {
                    searchText=""
                }
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
            .fillMaxWidth()
            .height(50.dp),
        textStyle = localTypography.current.Headline_Reg
    )
}

@Composable
fun MediumSearch_WithClose(onSearch: (String) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        MediumSearch(onSearch = onSearch)
        SpacerWi(16)
        Text(
            "Отменить",
            style = localTypography.current.Caption_Reg,
            color = Accent,
            modifier = Modifier
                .weight(0.5f)
                .clickable {  }
        )
    }
}
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
        placeholder = { Text("Искать описание", style = localTypography.current.Headline_Reg, color = PlaceHolder) },
        trailingIcon = {
            Icon(
                painter = painterResource(R.drawable.close),
                contentDescription = "",
                tint = Description, modifier = Modifier.clickable { searchText="" }
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
        textStyle = localTypography.current.Headline_Reg
    )
}