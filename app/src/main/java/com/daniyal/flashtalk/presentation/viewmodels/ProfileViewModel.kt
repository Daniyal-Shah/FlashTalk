package com.daniyal.flashtalk.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.daniyal.flashtalk.data.model.User
import com.daniyal.flashtalk.data.repository.FirebaseRepository
import kotlinx.coroutines.flow.StateFlow

class ProfileViewModel: ViewModel() {
    private val firebaseRepository: FirebaseRepository = FirebaseRepository()

    val loggedUser: StateFlow<User?>
        get() = firebaseRepository.loggedUser

    init {
        firebaseRepository.getCurrentUser()
    }
}