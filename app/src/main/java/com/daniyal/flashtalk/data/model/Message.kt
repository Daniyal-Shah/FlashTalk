package com.daniyal.flashtalk.data.model

import java.util.Date

data class Message(
    var senderId: Int,
    var recieverId: Int,
    var message: String,
    var createdDate: Date?,
    var isMessageReceived: Boolean
)

