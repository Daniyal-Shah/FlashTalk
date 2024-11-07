package com.daniyal.flashtalk.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daniyal.flashtalk.data.model.User
import com.daniyal.flashtalk.data.repository.FirebaseRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {

    private val firebaseRepository: FirebaseRepository = FirebaseRepository()

    val contacts: StateFlow<List<User>>
        get() = firebaseRepository.contacts

    val contactsLoading: StateFlow<Boolean>
        get() = firebaseRepository.contactLoading

    init {
        viewModelScope.launch {
            firebaseRepository.getContacts()
        }
    }
}