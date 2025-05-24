package com.example.uikit.TabBar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Input_Icon
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White
import com.example.uikit.UI.localTypography

@Composable
fun BottomNavigationBar(
    selectedd: Int,
    onClick1: () -> Unit,
    onClick2: () -> Unit,
    onClick3: () -> Unit,
    onClick4: () -> Unit,
    onTabSelected: (Int) -> Unit
) {


    Divider(modifier = Modifier.fillMaxWidth(), color = Input_Icon)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Bottom // Align items to the bottom of the row
    ) {
        BottomNavigationItem(
            icon = R.drawable.home,
            text = "Главная",
            selected = selectedd == 0
        ) {
            onTabSelected(0)
            onClick1()
        }
        BottomNavigationItem(
            icon = R.drawable.catalog,
            text = "Каталог",
            selected = selectedd == 1
        ) {
            onTabSelected(1)
            onClick2()
        }
        BottomNavigationItem(
            icon = R.drawable.support,
            text = "Проекты",
            selected = selectedd == 2,
            isSmallerIcon = true
        ) {
            onTabSelected(2)
            onClick3()
        }
        BottomNavigationItem(
            icon = R.drawable.profile,
            text = "Профиль",
            selected = selectedd == 3
        ) {
            onTabSelected(3)
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
            style = Typography().Caption2_Reg,
            color = if (selected) Accent else Input_Icon
        )
    }
}