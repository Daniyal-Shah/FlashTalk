package com.daniyal.flashtalk.presentation.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daniyal.flashtalk.data.model.User
import com.daniyal.flashtalk.data.repository.FirebaseRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LogInViewModel : ViewModel() {
    private val firebaseRepository: FirebaseRepository = FirebaseRepository()

    val loggedUser: StateFlow<User>
        get() = firebaseRepository.loggedUser

    var email = mutableStateOf("")
    var emailError = mutableStateOf<String?>(null)
    var password = mutableStateOf("")
    var passwordError = mutableStateOf<String?>(null)


    private fun validateInputs(): Boolean {
        return when {
            email.value.isEmpty() -> {
                emailError.value = "Email can't be empty"
                false
            }

            password.value.length < 6 -> {
                passwordError.value = "Password can't be empty"
                false
            }

            else -> {
                true
            }
        }
    }


    fun submitForm(onSuccess: () -> Unit) {
        if (validateInputs()) {
            viewModelScope.launch {
                onSuccess()
            }
        }
    }

    suspend fun setLoggedUser(user: User) {
        firebaseRepository.setLoggedUser(user)
    }

}