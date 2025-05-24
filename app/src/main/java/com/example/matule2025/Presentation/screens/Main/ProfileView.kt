package com.example.matule2025.Presentation.screens.Main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.matule2025.Domain.Repository.UserRepository
import com.example.matule2025.Presentation.navigation.NavigationRoutes
import com.example.matule2025.Presentation.viewModel.MainViewModel
import com.example.uikit.R
import com.example.uikit.Components.SpacerHeight
import com.example.uikit.Components.ToggleSwitch
import com.example.uikit.TabBar.BottomNavigationBar
import com.example.uikit.UI.Error
import com.example.uikit.UI.PlaceHolder
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White

@Composable
fun ProfileView(controller: NavHostController, viewModel: MainViewModel) {


    val state = viewModel.state

    LaunchedEffect(Unit) {
        viewModel.getUser()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White)

    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 76.dp)
        ) {
            Text(state.name, style = Typography().Caption2_Bold, fontSize = 24.sp)
            SpacerHeight(8)
            Text(state.numberPhone, style = Typography().Headline_Reg, color = PlaceHolder)
            SpacerHeight(40)
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    modifier = Modifier.size(32.dp),
                    painter = painterResource(R.drawable.icon),
                    contentDescription = ""
                )
                Text(
                    stringResource(com.example.matule2025.R.string.order),
                    style = Typography().Title3_Semi,
                    modifier = Modifier
                        .padding(start = 52.dp)
                        .align(Alignment.CenterStart)
                )
            }
            SpacerHeight(32)
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    modifier = Modifier.size(32.dp),
                    painter = painterResource(R.drawable.settings),
                    contentDescription = ""
                )
                Text(
                    stringResource(com.example.matule2025.R.string.yvedom),
                    style = Typography().Title3_Semi,
                    modifier = Modifier
                        .padding(start = 52.dp)
                        .align(Alignment.CenterStart)
                )
                Box(modifier = Modifier.align(Alignment.CenterEnd)) {
                    ToggleSwitch(
                        isChecked = state.notification,
                        onCheckedChange = { viewModel.updateState(state.copy(notification = it)) })

                }

            }

            SpacerHeight(192)
            Column (modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
                Text("Политика конфиденциальности", style = Typography().Text_Med, color = PlaceHolder)
                SpacerHeight(24)
                Text("Пользовательское соглашение", style = Typography().Text_Med, color = PlaceHolder)
                SpacerHeight(24)

                Text("Выход", style = Typography().Text_Med, color = Error, modifier = Modifier.clickable {
                    UserRepository.UserID = ""
                    UserRepository.act = 0
                    controller.navigate(NavigationRoutes.SIGNINUP){
                        popUpTo(NavigationRoutes.PROFILE){
                            inclusive=true
                        }
                    }
                })
            }


        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            BottomNavigationBar(
                onClick1 = { controller.navigate(NavigationRoutes.MAIN) },
                onClick2 = { controller.navigate(NavigationRoutes.CATEGORIES) },
                onClick3 = {controller.navigate(NavigationRoutes.PROJECTS)},
                onClick4 = { controller.navigate(NavigationRoutes.PROFILE) },
                selectedd = state.TabSelected,
                onTabSelected = {
                    viewModel.updateState(state.copy(TabSelected = it))
                }
            )
        }
    }
}