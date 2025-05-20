package com.example.matule2025.Presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.matule2025.Presentation.screens.CreateProfile.CreateProfile
import com.example.matule2025.Presentation.screens.signInUp.SignInUpView
import com.example.matule2025.Presentation.screens.splash.SplashView


@Composable
fun Navigation() {

    var controller = rememberNavController()
    NavHost(navController = controller, startDestination = NavigationRoutes.SPLASH) {
        composable(NavigationRoutes.SPLASH) {
            SplashView(controller)
        }
        composable(NavigationRoutes.SIGNINUP) {
            SignInUpView()
        }
        composable(NavigationRoutes.CREATEPASSWORD) {

        }
        composable(NavigationRoutes.CREATEPROFILE) {
            CreateProfile(controller)
        }
    }

}