package com.example.matule2025.Presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.matule2025.Domain.Repository.UserRepository
import com.example.matule2025.Presentation.navigation.NavigationRoutes
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel() :ViewModel() {

    fun launch(controller: NavHostController){
        viewModelScope.launch {
            delay(2000)
            Log.e("UserRepository.act Splash", UserRepository.act.toString())
            //Не авторизован
            if (UserRepository.act==0){
                controller.navigate(NavigationRoutes.SIGNINUP){
                    popUpTo(NavigationRoutes.SPLASH){
                        inclusive=true
                    }
                }
            }

            //авторизован
            if (UserRepository.act==1){
                controller.navigate(NavigationRoutes.MAIN){
                    popUpTo(NavigationRoutes.SIGNINUP){
                        inclusive=true
                    }
                }
            }
        }

    }
}