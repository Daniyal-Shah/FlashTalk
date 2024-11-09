package com.daniyal.flashtalk.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daniyal.flashtalk.data.repository.FirebaseRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LogInViewModel : ViewModel() {
    private val firebaseRepository: FirebaseRepository = FirebaseRepository()

    val loading: StateFlow<Boolean>
        get() = firebaseRepository.loading

    var email = mutableStateOf("daniyal.shah.cs@gmail.com")
    var emailError = mutableStateOf<String?>(null)
    var password = mutableStateOf("123456")
    var passwordError = mutableStateOf<String?>(null)


    private fun validateInputs(): Boolean {
        return when {
            email.value.isEmpty() && password.value.isEmpty() -> {
                emailError.value = "Email can't be empty"
                passwordError.value = "Password can't be empty"
                false
            }

            email.value.isEmpty() -> {
                emailError.value = "Email can't be empty"
                false
            }

            password.value.isEmpty() -> {
                passwordError.value = "Password can't be empty"
                false
            }

            else -> {
                true
            }
        }
    }

    private fun clearValues() {
        email.value = ""
        password.value = ""
    }

    fun submitForm(onSuccess: () -> Unit) {
        if (validateInputs()) {
            viewModelScope.launch {
                firebaseRepository.login(
                    email = email.value,
                    password = password.value,
                    onSuccess = {
                        clearValues()
                        onSuccess()
                    },
                    onError = {})
            }
        }
    }


}