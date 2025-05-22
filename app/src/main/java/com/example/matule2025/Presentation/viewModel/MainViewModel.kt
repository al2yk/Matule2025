package com.example.matule2025.Presentation.viewModel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.matule2025.Presentation.state.MainState
import com.example.networklib.data.models.NetworkResult
import com.example.networklib.domain.usecase.UseCase
import kotlinx.coroutines.launch

class MainViewModel(private val UseCase: UseCase) : ViewModel() {

    private val _state = mutableStateOf(MainState())
    val state: MainState get() = _state.value

    fun updateState(newstate: MainState) {
        _state.value = newstate
    }

    fun getCategories() {

        viewModelScope.launch {
            try {
                when (val result = UseCase.GetCategories()) {
                    is NetworkResult.Error -> {
                        Log.d("RAW_RESPONSE", result.error.toString())
                        Log.d("Ошибка Получения категорий1", result.error.message)
                    }

                    is NetworkResult.Loading -> {}
                    is NetworkResult.Success -> {
                        Log.d("NetworkResponse", "Success: ${result.data}")
                        /*       val title = result.data.items?.map { it.title }*/
                        updateState(
                            state.copy(
                                listCategory = result.data?.items ?: emptyList(),
                                selected = result.data?.items?.firstOrNull()
                            )
                        )
                    }

                    is NetworkResult.NoInternet -> {
                        Log.d("Ошибка Получения категорий", "Нет интернета")
                    }
                }

            } catch (e: Exception) {
                Log.d("Ошибка Получения категорий2", e.message.toString())
            }
        }
    }


    fun getProduct() {
        viewModelScope.launch {
            try {
                when (val result = UseCase.getProduct()) {
                    is NetworkResult.Error -> {
                        Log.i("Ошибка Продукты", result.error.message.toString())
                    }

                    is NetworkResult.Success -> {
                        Log.d("Продукты", result.data.items.toString())

                        updateState(state.copy(listProduct = result.data?.items ?: emptyList()))
                        Log.e("Продукты state", state.listProduct.toString())
                    }

                    is NetworkResult.Loading -> {}
                    is NetworkResult.NoInternet -> {}
                }
            } catch (e: Exception) {
                Log.i("Ошибка Продукты", e.message.toString())
            }
        }
    }
}

