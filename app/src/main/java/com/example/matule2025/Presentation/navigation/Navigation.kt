package com.example.matule2025.Presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.matule2025.Presentation.screens.Main.CategoriesView
import com.example.matule2025.Presentation.screens.Main.MainView
import com.example.matule2025.Presentation.screens.Main.ProfileView
import com.example.matule2025.Presentation.screens.noInternet.NoInternet
import com.example.matule2025.Presentation.screens.signInUp.CreatePassword
import com.example.matule2025.Presentation.screens.signInUp.CreatePassword4
import com.example.matule2025.Presentation.screens.signInUp.CreateProfile
import com.example.matule2025.Presentation.screens.signInUp.SignInUpView
import com.example.matule2025.Presentation.screens.signInUp.TgAuth
import com.example.matule2025.Presentation.screens.splash.SplashView
import com.example.matule2025.Presentation.viewModel.AuthViewModel
import com.example.matule2025.Presentation.viewModel.MainViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun Navigation(isOnline: Boolean) {


    var controller = rememberNavController()

    //Спросить будет ли это правильНО? потому что без этого не будет передаваться email и password
    val viewModel: AuthViewModel = koinViewModel()
    val MainViewM: MainViewModel = koinViewModel()
    if (isOnline){
    NavHost(navController = controller, startDestination = NavigationRoutes.SPLASH) {
        composable(NavigationRoutes.SPLASH) {
            SplashView(controller)
        }
        composable(NavigationRoutes.SIGNINUP) {
            SignInUpView(controller,viewModel)
        }
        composable(NavigationRoutes.CREATEPASSWORD) {
            CreatePassword(controller)
        }
        composable(NavigationRoutes.CREATEPROFILE) {
            CreateProfile(controller,viewModel)
        }
        composable(NavigationRoutes.MAIN) {
            MainView(controller,MainViewM)
        }
        composable(NavigationRoutes.CREATEPASSWORD4) {
           CreatePassword4(controller)
        }
        composable(NavigationRoutes.TG) {
          TgAuth(controller)
        }
        composable(NavigationRoutes.CATEGORIES) {
          CategoriesView(controller,MainViewM)
        }
        composable(NavigationRoutes.PROFILE) {
          ProfileView(controller,MainViewM)
        }
    }}
    else{
        NoInternet()
    }

}