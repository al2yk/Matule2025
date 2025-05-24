package com.example.matule2025.Presentation.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.matule2025.Domain.Repository.UserRepository
import com.example.matule2025.Presentation.navigation.NavigationRoutes
import com.example.matule2025.Domain.patterns.isEmailValid
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
                        is NetworkResult.Success ->{
                            UserRepository.UserID = res.data.record.id
                            UserRepository.act = 1
                            Log.e("ACT", UserRepository.act.toString())
                            Log.e("UserRepository.UserID", UserRepository.UserID)
                            updateState(state.copy(email="",password=""))

                            controller.navigate(NavigationRoutes.MAIN) }
                        is NetworkResult.Error ->{_state.value = _state.value.copy(isLoading = false, error = res.error.message)
                        if(res.error.message=="Нет такого пользователя"){
                            _state.value=_state.value.copy(email=email,password=password)
                            controller.navigate(NavigationRoutes.CREATEPASSWORD4)}}
                        is NetworkResult.NoInternet ->{_state.value = _state.value.copy(error = "No Internet")}
                        is NetworkResult.Loading ->{_state.value = _state.value.copy(isLoading = true)}
                    }
                    Log.d("auth",state.error.toString())

                }else{
                    Log.d("auth","6")
                    _state.value = _state.value.copy(error = "Пароль меньше 6 символов")
                }
            }else{
                Log.d("auth","email")
                _state.value = _state.value.copy(error = "Email не соответствует патерну")
            }


        }
    }


    fun Registration(controller: NavHostController){
        viewModelScope.launch {
            updateState(state.copy(isLoading = true, error = null))
            try{
                when(val response = UseCase.invoke(state.email,state.password,state.password,state.name,state.surname,state.lastname,state.dateBirthday,state.gender,state.telegram)){
                    is NetworkResult.Success ->{
                        UserRepository.UserID = response.data.id
                        controller.navigate(NavigationRoutes.MAIN)}
                    is NetworkResult.Error->{updateState(state.copy(isLoading = false, error = response.error.message))}
                    is NetworkResult.Loading->{updateState(state.copy(isLoading = true))}
                    is NetworkResult.NoInternet->{updateState(state.copy(isNotInternet = true))}
                }
                Log.d("Reg",state.error.toString())



            }catch (e:Exception){
                    Log.e("reg ViewModel",e.message.toString())
            }
        }
    }
}