package com.example.matule2025.Presentation.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.matule2025.Presentation.state.CreatePasswordState
import com.example.matule2025.Domain.UseCase.UseCase

class CreatePasswordViewModel(private val UseCase: UseCase):ViewModel() {

    private val _state = mutableStateOf(CreatePasswordState())
    val state:CreatePasswordState get() = _state.value

    fun updateState(newState: CreatePasswordState){_state.value = newState}

}