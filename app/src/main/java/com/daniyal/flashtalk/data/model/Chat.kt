package com.daniyal.flashtalk.data.model

import java.util.Date

data class Chat(
    var id: Int,
    var sender: User,
    var reciever: User,
    var lastMsg: Message,
    var allMessages: List<Message>,
    var dateCreated: Date?,
    var unreadMessagesCount: Int
)