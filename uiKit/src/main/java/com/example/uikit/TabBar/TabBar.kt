package com.example.uikit.TabBar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Input_Icon
import com.example.uikit.UI.localTypography

@Composable
fun BottomNavigationBar(onClick1: () -> Unit,onClick2: () -> Unit,onClick3: () -> Unit,onClick4: () -> Unit) {

    var isSelected by remember { mutableStateOf(0) }
    Divider(modifier = Modifier.fillMaxWidth(), color = Input_Icon)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom // Align items to the bottom of the row
    ) {
        BottomNavigationItem(
            icon = R.drawable.home,
            text = "Главная",
            selected = isSelected == 0
        ) {
            isSelected = 0
            onClick1()
        }
        BottomNavigationItem(
            icon = R.drawable.catalog,
            text = "Каталог",
            selected = isSelected == 1
        ) {
            isSelected = 1
            onClick2()
        }
        BottomNavigationItem(
            icon = R.drawable.support,
            text = "Проекты",
            selected = isSelected == 2,
            isSmallerIcon = true
        ) {
            isSelected = 2
            onClick3()
        }
        BottomNavigationItem(
            icon = R.drawable.profile,
            text = "Профиль",
            selected = isSelected == 3
        ) {
            isSelected = 3
            onClick4()
        }
    }
}

@Composable
fun BottomNavigationItem(
    icon: Int,
    text: String,
    selected: Boolean,
    isSmallerIcon: Boolean = false,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onClick() }
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
            tint = if (selected) Accent else Input_Icon,
            modifier = Modifier.size(if (isSmallerIcon) 26.dp else 35.dp)
        )
        Text(
            text,
            style = localTypography.current.Caption2_Reg,
            color = if (selected) Accent else Input_Icon
        )
    }
}