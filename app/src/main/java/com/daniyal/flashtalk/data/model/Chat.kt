package com.daniyal.flashtalk.data.model

import java.util.Date

data class Chat(
    var id: String,
    var senderId: String,
    var receiverId: String,
    var lastMsg: Message,
    var allMessages: List<Message> = emptyList(),
    var dateCreated: Long = System.currentTimeMillis(),
    var unreadMessagesCount: Int = 0
)