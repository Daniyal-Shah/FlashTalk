package com.daniyal.flashtalk.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daniyal.flashtalk.data.model.Message
import com.daniyal.flashtalk.data.model.Story
import com.daniyal.flashtalk.data.model.User
import com.daniyal.flashtalk.data.repository.FirebaseRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MessageViewModel : ViewModel() {
    private val firebaseRepository: FirebaseRepository = FirebaseRepository()

    val messages: StateFlow<List<Message>>
        get() = firebaseRepository.messages

    val messageLoading: StateFlow<Boolean>
        get() = firebaseRepository.messageLoading

    val contacts: StateFlow<List<User>>
        get() = firebaseRepository.contacts


    init {
        viewModelScope.launch {
            firebaseRepository.getMessages()
        }
        viewModelScope.launch {
            firebaseRepository.getContacts()
        }
    }
}