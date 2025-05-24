package com.example.matule2025.Presentation.screens.Main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.matule2025.Presentation.navigation.NavigationRoutes
import com.example.matule2025.Presentation.viewModel.MainViewModel
import com.example.uikit.Button.Primary
import com.example.uikit.Components.ChipsLazyRow
import com.example.uikit.Components.SpacerHeight
import com.example.uikit.Search.MediumSearch
import com.example.uikit.TabBar.BottomNavigationBar
import com.example.uikit.UI.White

@Composable
fun CategoriesView(controller: NavHostController, viewModel: MainViewModel) {

    val state = viewModel.state

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White)

    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 70.dp)
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                MediumSearch {}
                Icon(
                    painter = painterResource(com.example.uikit.R.drawable.uicon),
                    contentDescription = "", modifier = Modifier.align(Alignment.CenterEnd)
                )
            }
            SpacerHeight(32)
            val listCategory = state.listCategory.map { it.title }
            ChipsLazyRow(listCategory, state.selected?.title) {t->
                viewModel.updateState(state.copy(selected = state.listCategory.firstOrNull{it.title==t}))
            }
            SpacerHeight(20)
            LazyColumn {
                item {
                    state.listProduct.filter { it.category==state.selected?.id }.forEach { product->
                        Primary(product.title,state.selected?.title ?:"",product.cost,false,true) { }
                    }
                }
            }
            SpacerHeight(30)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            BottomNavigationBar(
                onClick1 = { controller.navigate(NavigationRoutes.MAIN) },
                onClick2 = { controller.navigate(NavigationRoutes.CATEGORIES) },
                onClick3 = {},
                onClick4 = {controller.navigate(NavigationRoutes.PROFILE)},
                selectedd = state.TabSelected,
                onTabSelected = {
                    viewModel.updateState(state.copy(TabSelected = it))
                }
            )
        }
    }
}