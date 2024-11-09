package com.daniyal.flashtalk.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daniyal.flashtalk.data.model.Chat
import com.daniyal.flashtalk.data.model.Story
import com.daniyal.flashtalk.data.model.User
import com.daniyal.flashtalk.data.repository.FirebaseRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val firebaseRepository: FirebaseRepository = FirebaseRepository()

    val loggedUser: StateFlow<User?>
        get() = firebaseRepository.loggedUser

    val stories: StateFlow<List<Story>>
        get() = firebaseRepository.stories

    val chats: StateFlow<List<Chat>>
        get() = firebaseRepository.chats

    val storyLoading: StateFlow<Boolean>
        get() = firebaseRepository.storyLoading

    val chatLoading: StateFlow<Boolean>
        get() = firebaseRepository.chatLoading


    init {
        firebaseRepository.getCurrentUser()

        viewModelScope.launch {
            firebaseRepository.getChats()
        }
        viewModelScope.launch {
            firebaseRepository.getStories()
        }
    }
}