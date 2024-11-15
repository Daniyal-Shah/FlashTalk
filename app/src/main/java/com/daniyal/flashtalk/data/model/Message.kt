package com.daniyal.flashtalk.data.model

import java.util.Date

data class Message(
    var id: String,
    var senderId: String,
    var receiverId: String,
    var message: String,
    var createdDate: Long = System.currentTimeMillis(),
    var isMessageReceived: Boolean = false
)

