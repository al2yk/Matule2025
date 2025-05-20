package com.example.matule2025.Presentation.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.matule2025.Presentation.navigation.NavigationRoutes
import com.example.matule2025.Presentation.patterns.isEmailValid
import com.example.matule2025.Presentation.state.AuthState
import com.example.networklib.data.models.NetworkResult
import com.example.networklib.domain.usecase.UseCase
import kotlinx.coroutines.launch

class AuthViewModel(private val UseCase: UseCase):ViewModel() {

    private val _state = mutableStateOf(AuthState())
    val state:AuthState get() = _state.value

    fun updateState(newState: AuthState){_state.value=newState}

    fun Auth(email:String,password:String,controller: NavHostController){
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, error = null)
            if (state.email.isEmailValid()){
                if (state.password.length>=6){
                    when(val res = UseCase(email,password)){
                        is NetworkResult.Success ->{ controller.navigate(NavigationRoutes.CREATEPROFILE) }
                        is NetworkResult.Error ->{_state.value = _state.value.copy(isLoading = false, error = res.error.message)}
                        is NetworkResult.NoInternet ->{_state.value = _state.value.copy(error = "No Internet")}
                        is NetworkResult.Loading ->{_state.value = _state.value.copy(isLoading = true)}
                    }
                }else{
                    _state.value = _state.value.copy(error = "Пароль меньше 6 символов")
                }
            }else{
                _state.value = _state.value.copy(error = "Email не соответствует патерну")
            }


        }
    }
}