package com.daniyal.flashtalk.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.daniyal.flashtalk.data.allMessages
import com.daniyal.flashtalk.data.allUsers
import com.daniyal.flashtalk.data.chatsLists
import com.daniyal.flashtalk.data.model.Chat
import com.daniyal.flashtalk.data.model.Message
import com.daniyal.flashtalk.data.model.Story
import com.daniyal.flashtalk.data.model.User
import com.daniyal.flashtalk.data.singleUser
import com.daniyal.flashtalk.data.storyLists
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FirebaseRepository {

    // LoggedIn User
    private val _loggedUser = MutableStateFlow<User>(singleUser)
    val loggedUser: StateFlow<User> get() = _loggedUser

    //    Data
    private val _stories = MutableStateFlow<List<Story>>(emptyList())
    val stories: StateFlow<List<Story>> get() = _stories

    private val _chats = MutableStateFlow<List<Chat>>(emptyList())
    val chats: StateFlow<List<Chat>> get() = _chats

    private val _messages = MutableStateFlow<List<Message>>(emptyList())
    val messages: StateFlow<List<Message>> get() = _messages

    private val _contacts = MutableStateFlow<List<User>>(emptyList())
    val contacts: StateFlow<List<User>> get() = _contacts

    //    Loaders
    private val _storyLoading = MutableStateFlow<Boolean>(false)
    val storyLoading: StateFlow<Boolean> get() = _storyLoading

    private val _chatLoading = MutableStateFlow<Boolean>(false)
    val chatLoading: StateFlow<Boolean> get() = _chatLoading

    private val _messageLoading = MutableStateFlow<Boolean>(false)
    val messageLoading: StateFlow<Boolean> get() = _messageLoading

    private val _contactLoading = MutableStateFlow<Boolean>(false)
    val contactLoading: StateFlow<Boolean> get() = _contactLoading


    suspend fun setLoggedUser(user: User)
    {
        _loggedUser.emit(user)
    }

    suspend fun getStories() {
        _storyLoading.emit(true)
        delay(1000)
        _stories.value = storyLists
        _storyLoading.emit(false)
    }

    suspend fun getChats() {
        _chatLoading.emit(true)
        delay(1000)
        _chats.value = chatsLists
        _chatLoading.emit(false)
    }

    suspend fun getMessages() {
        _messageLoading.emit(true)
        delay(1000)
        _messages.value = allMessages
        _messageLoading.emit(false)
    }

    suspend fun getContacts() {
        _contactLoading.emit(true)
        delay(1000)
        _contacts.value = allUsers
        _contactLoading.emit(false)
    }
}