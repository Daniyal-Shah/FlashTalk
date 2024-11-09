package com.daniyal.flashtalk.data.repository

import android.util.Log

import com.daniyal.flashtalk.data.model.Chat
import com.daniyal.flashtalk.data.model.Message
import com.daniyal.flashtalk.data.model.Story
import com.daniyal.flashtalk.data.model.User
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.tasks.await


class FirebaseRepository {
    val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    val firebaseFirestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    // LoggedIn User
    private val _loggedUser =
        MutableStateFlow<User?>(null)
    val loggedUser: StateFlow<User?> get() = _loggedUser

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
    private val _loading = MutableStateFlow<Boolean>(false)
    val loading: StateFlow<Boolean> get() = _loading

    private val _storyLoading = MutableStateFlow<Boolean>(false)
    val storyLoading: StateFlow<Boolean> get() = _storyLoading

    private val _chatLoading = MutableStateFlow<Boolean>(false)
    val chatLoading: StateFlow<Boolean> get() = _chatLoading

    private val _messageLoading = MutableStateFlow<Boolean>(false)
    val messageLoading: StateFlow<Boolean> get() = _messageLoading

    private val _contactLoading = MutableStateFlow<Boolean>(false)
    val contactLoading: StateFlow<Boolean> get() = _contactLoading

    //    Auth
    suspend fun login(
        email: String,
        password: String,
        onSuccess: (addedUser: User) -> Unit,
        onError: (e: Exception) -> Unit
    ) {
        _loading.emit(true)
        try {
            val authResult: AuthResult =
                firebaseAuth.signInWithEmailAndPassword(email, password).await()
            val id = authResult.user!!.uid

            if (authResult.user != null) {
                firebaseFirestore.collection("users")
                    .document(id)
                    .get()
                    .addOnSuccessListener { doc ->
                        onSuccess(
                            User(
                                id,
                                doc.get("email").toString(),
                                doc.get("password").toString(),
                                doc.get("fullName").toString(),
                                doc.get("image").toString(),
                                doc.get("bio").toString(),
                                doc.get("phoneNumber").toString()
                            )
                        )
                    }
                    .addOnFailureListener(onError)
            }
        } catch (e: Exception) {
            onError(e)
        }
        _loading.emit(false)
    }

    suspend fun signup(
        name: String,
        email: String,
        password: String,
        phoneNumber: String,
        bio: String,
        image: String,
        onSuccess: () -> Unit,
        onError: (e: Exception) -> Unit
    ) {
        _loading.emit(true)
        try {
            val authResult: AuthResult =
                firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            if (authResult.user != null) {
                val uid = authResult.user!!.uid

                firebaseFirestore.collection("users").document(uid).set(
                    User(uid, email, password, name, image, bio, phoneNumber)
                ).addOnSuccessListener {
                    onSuccess()
                }
                    .addOnFailureListener {
                        onError(it)
                    }
            }
        } catch (e: Exception) {
            onError(e)
        }
        _loading.emit(false)
    }


    fun getCurrentUser() {
        val currentUser = firebaseAuth.currentUser
        if (currentUser != null) {
            firebaseFirestore.collection("users")
                .document(currentUser.uid)
                .get()
                .addOnSuccessListener { doc ->
                    _loggedUser.value = User(
                        currentUser.uid,
                        doc.get("email").toString(),
                        doc.get("password").toString(),
                        doc.get("fullName").toString(),
                        doc.get("image").toString(),
                        doc.get("bio").toString(),
                        doc.get("phoneNumber").toString()
                    )
                }
        }
    }

    suspend fun getStories() {
        _storyLoading.emit(true)
        delay(200)
//        _stories.value = storyLists
        _storyLoading.emit(false)
    }

    suspend fun getChats() {
        _chatLoading.emit(true)
        delay(1000)

        _chatLoading.emit(false)
    }

    suspend fun getMessages() {
        _messageLoading.emit(true)
        delay(1000)
//        _messages.value = allMessages
        _messageLoading.emit(false)
    }

    suspend fun getContacts() {
        _contactLoading.emit(true)
        delay(1000)
//        _contacts.value = allUsers
        _contactLoading.emit(false)
    }
}