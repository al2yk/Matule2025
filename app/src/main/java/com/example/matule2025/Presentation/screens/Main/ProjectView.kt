package com.example.matule2025.Presentation.screens.Main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.matule2025.Presentation.navigation.NavigationRoutes
import com.example.matule2025.Presentation.viewModel.MainViewModel
import com.example.uikit.Components.SpacerHeight
import com.example.uikit.TabBar.BottomNavigationBar
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White

@Composable
fun ProjectView(controller: NavHostController, viewModel: MainViewModel) {

    val state =viewModel.state

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White)

    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 74.dp)
        )
        {
            Box() {
                androidx.compose.material3.Text(
                    "Проекты",
                    style = Typography().Title2_SemiBold,
                    modifier = Modifier.align(Alignment.Center)
                )
                Box(modifier = Modifier.align(Alignment.CenterEnd)) {
                    Icon(
                        painter = painterResource(com.example.uikit.R.drawable.plus),
                        contentDescription = ""
                    )
                }
            }
            SpacerHeight(36)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            BottomNavigationBar(
                onClick1 = {controller.navigate(NavigationRoutes.MAIN)},
                onClick2 = {controller.navigate(NavigationRoutes.CATEGORIES)},
                onClick3 = {controller.navigate(NavigationRoutes.PROJECTS)},
                onClick4 = {controller.navigate(NavigationRoutes.PROFILE)},
                selectedd = state.TabSelected,
                onTabSelected = {
                    viewModel.updateState(state.copy(TabSelected = it))
                }
            )
        }
    }
}