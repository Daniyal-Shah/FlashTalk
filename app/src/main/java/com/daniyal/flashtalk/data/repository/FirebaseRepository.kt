package com.daniyal.flashtalk.data.repository

import android.util.Log
import com.daniyal.flashtalk.data.model.Channel

import com.daniyal.flashtalk.data.model.Chat
import com.daniyal.flashtalk.data.model.Message
import com.daniyal.flashtalk.data.model.Story
import com.daniyal.flashtalk.data.model.User
import com.google.firebase.Firebase
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.database
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.tasks.await
import kotlinx.serialization.json.Json


class FirebaseRepository {
    private val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private val firebaseFirestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val firebaseDatabase = Firebase.database

    // LoggedIn User
    private val _loggedUser =
        MutableStateFlow<User?>(null)
    val loggedUser: StateFlow<User?> get() = _loggedUser

    //    Data
    private val _channels = MutableStateFlow<List<Channel>>(emptyList())
    val channels: StateFlow<List<Channel>> get() = _channels

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
    }

    fun signOut() {
        firebaseAuth.signOut()
    }

    suspend fun setLoading(value: Boolean) {
        _loading.emit(value)
    }

    suspend fun getChannels(onSuccess: () -> Unit, onError: (e: Exception) -> Unit) {
        try {
            val reference = firebaseDatabase.getReference("channel").get().await()

            val list = mutableListOf<Channel>()
            reference.children.forEach {
                list.add(Channel(it.key!!, it.value.toString()))
            }
            _channels.emit(list)
            onSuccess()
        } catch (e: Exception) {
            onError(e)
        }
    }

    suspend fun getContacts() {
        _contactLoading.emit(true)
        try {
            getCurrentUser()
            val list = ArrayList<User>()
            val contacts = firebaseFirestore.collection("users").get().await()
            contacts.documents.forEach { doc ->
                list.add(
                    User(
                        doc.get("id").toString(),
                        doc.get("email").toString(),
                        doc.get("password").toString(),
                        doc.get("fullName").toString(),
                        doc.get("image").toString(),
                        doc.get("bio").toString(),
                        doc.get("phoneNumber").toString()
                    )
                )
            }
            _contacts.emit(list)
            _contactLoading.emit(false)
        } catch (e: Exception) {
            _contactLoading.emit(false)
        }
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

    suspend fun createChat(
        receiver: User,
    ) {
        try {
            loggedUser.value?.let {
                Chat(
                    id = getMergedId(it.id, receiver.id),
                    senderId = it.id,
                    receiverId = receiver.id,
                    lastMsg = Message(
                        id = "",
                        senderId = "",
                        receiverId = "",
                        message = "",
                        isMessageReceived = false
                    ),

                    )
            }
                ?.let {
                    firebaseFirestore.collection("chats").document(
                        getMergedId(loggedUser.value!!.id, receiver.id)
                    ).set(
                        it
                    )
                        .addOnSuccessListener { }
                        .addOnFailureListener { }
                }
        } catch (e: Exception) {
            Log.d("DDDD", e.toString())
        }
    }

    private fun getMergedId(id1: String, id2: String): String {
        return id1.slice(0..5) + id2.slice(0..5)
    }

    suspend fun getChats() {
        _chatLoading.emit(true)
        try {
            val list = ArrayList<Chat>()
            val reference = firebaseFirestore.collection("chats").get().await()
            reference.documents.forEach { doc ->
                list.add(
                    Chat(
                        id = doc.get("id").toString(),
                        senderId = doc.get("senderId").toString(),
                        receiverId = doc.get("receiverId").toString(),
                        lastMsg = Message(
                            id = "",
                            senderId = "",
                            receiverId = "",
                            message = doc.get("lastMsg").toString(), isMessageReceived = false
                        )

                    )
                )
            }
            _chats.emit(list)
        } catch (e: Exception) {
            Log.d("DDDDD-Error", e.toString())
        }
        _chatLoading.emit(false)
    }

    suspend fun getStories() {
        _storyLoading.emit(true)
        delay(200)
//        _stories.value = storyLists
        _storyLoading.emit(false)
    }

    suspend fun getMessages() {
        _messageLoading.emit(true)
        delay(1000)
//        _messages.value = allMessages
        _messageLoading.emit(false)
    }


}