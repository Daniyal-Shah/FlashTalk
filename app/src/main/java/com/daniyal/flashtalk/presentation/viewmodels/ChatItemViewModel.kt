package com.daniyal.flashtalk.presentation.viewmodels

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daniyal.flashtalk.data.model.User
import com.daniyal.flashtalk.data.repository.FirebaseRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class ChatItemViewModel() : ViewModel() {
    private val firebaseRepository: FirebaseRepository = FirebaseRepository()

    val contacts: StateFlow<List<User>>
        get() = firebaseRepository.contacts


    init {
        viewModelScope.launch {
            firebaseRepository.getContacts()
        }
    }
}
