package com.example.matule2025.Presentation.screens.Main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.matule2025.Presentation.navigation.NavigationRoutes
import com.example.matule2025.Presentation.viewModel.MainViewModel
import com.example.matule2025.R
import com.example.uikit.Button.Primary
import com.example.uikit.Components.ChipsLazyRow
import com.example.uikit.Components.SpacerHeight
import com.example.uikit.Components.SpacerWi
import com.example.uikit.Search.BigSearch
import com.example.uikit.TabBar.BottomNavigationBar
import com.example.uikit.UI.PlaceHolder
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White
import com.example.uikit.UI.localTypography
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainView(controller: NavHostController, viewModel: MainViewModel) {

    val state = viewModel.state

    LaunchedEffect(Unit) {
        viewModel.getCategories()
        viewModel.getProduct()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White)

    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 60.dp)
        ) {
            BigSearch { }

            LazyColumn {
                item {
                    SpacerHeight(32)
                    Text(
                        "Акции и новости",
                        style = Typography().Title3_Semi,
                        color = PlaceHolder
                    )
                    SpacerHeight(16)
                    LazyRow {
                        item {
                            /*CardBackground(152, Color.Transparent)*/
                            Image(
                                painter = painterResource(R.drawable.banner),
                                contentDescription = "",
                                contentScale = ContentScale.FillWidth,
                                modifier = Modifier.width(270.dp)
                            )
                            SpacerWi(20)
                            Image(
                                painter = painterResource(R.drawable.banner),
                                contentDescription = "",
                                contentScale = ContentScale.FillWidth,
                                modifier = Modifier.width(270.dp)
                            )
                        }
                    }

                    SpacerHeight(32)
                    Text(
                        "Каталог описаний",
                        style = Typography().Title3_Semi,
                        color = PlaceHolder
                    )
                    SpacerHeight(15)
                    val listCategory = state.listCategory.map { it.title }
                    ChipsLazyRow(listCategory, state.selected?.title) {t->
                        viewModel.updateState(state.copy(selected = state.listCategory.firstOrNull{it.title==t}))
                    }
                    SpacerHeight(25)

                    state.listProduct.filter { it.category==state.selected?.id }.forEach { product->
                        Primary(product.title,state.selected?.title ?:"",product.cost,false,true) { }
                    }
                    SpacerHeight(30)

                }
            }


        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            BottomNavigationBar(
                onClick1 = {controller.navigate(NavigationRoutes.MAIN)},
                onClick2 = {controller.navigate(NavigationRoutes.CATEGORIES)},
                onClick3 = {controller.navigate(NavigationRoutes.CATEGORIES)},
                onClick4 = {controller.navigate(NavigationRoutes.PROFILE)},
                selectedd = state.TabSelected,
                onTabSelected = {
                    viewModel.updateState(state.copy(TabSelected = it))
                }
            )
        }
    }
}