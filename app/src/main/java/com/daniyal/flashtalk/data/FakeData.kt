package com.daniyal.flashtalk.data

import com.daniyal.flashtalk.R
import com.daniyal.flashtalk.data.model.Chat
import com.daniyal.flashtalk.data.model.Message
import com.daniyal.flashtalk.data.model.Story
import com.daniyal.flashtalk.data.model.User

val allMessages = listOf<Message>(
    Message(
        senderId = 1,
        recieverId = 1,
        message = "How are you?",
        createdDate = null,
        isMessageReceived = true
    ),
    Message(
        senderId = 1,
        recieverId = 1,
        message = "I'm Fine! How are you?",
        createdDate = null,
        isMessageReceived = false
    ),
    Message(
        senderId = 1,
        recieverId = 1,
        message = "I'm fine, Thanks.",
        createdDate = null,
        isMessageReceived = true
    ),
    Message(
        senderId = 1,
        recieverId = 1,
        message = "Available for a short meeting?",
        createdDate = null,
        isMessageReceived = true
    ),
    Message(
        senderId = 1,
        recieverId = 1,
        message = "Yeah sure, but can you wait for 15-mints, i'm in middle of something right now",
        createdDate = null,
        isMessageReceived = false
    ),
    Message(
        senderId = 1,
        recieverId = 1,
        message = "Let me know once you are free.",
        createdDate = null,
        isMessageReceived = true
    ),
    Message(
        senderId = 1,
        recieverId = 1,
        message = "Okay sure, thanks.",
        createdDate = null,
        isMessageReceived = false
    ),
)
val singleUser = User(
    1,
    fullName = "Alex Linderson",
    image = R.drawable.person5,
    email = "daniyal.shah.cs@gmail.com",
    password = "123456"
)

val allUsers = listOf(
    User(
        1,
        fullName = "Alex Linderson",
        image = R.drawable.person5,
        email = "daniyal.shah.cs@gmail.com",
        password = "123456"
    ),
    User(
        1,
        fullName = "Angelina Jolie",
        image = R.drawable.person4,
        email = "daniyal.shah.cs@gmail.com",
        password = "123456"
    ),
    User(
        1,
        fullName = "Alexa James",
        image = R.drawable.person3,
        email = "daniyal.shah.cs@gmail.com",
        password = "123456"
    ),
    User(
        1,
        fullName = "Emilia Clark",
        image = R.drawable.person1,
        email = "daniyal.shah.cs@gmail.com",
        password = "123456"
    )
)
val chatsLists = listOf(
    Chat(
        id = 1,
        sender = User(
            1,
            fullName = "Alex Linderson",
            image = R.drawable.person5,
            email = "daniyal.shah.cs@gmail.com",
            password = "123456"
        ),
        reciever = User(
            1, fullName = "", email = "daniyal.shah.cs@gmail.com",
            password = "123456", image = null
        ),
        lastMsg = allMessages[0],
        unreadMessagesCount = 1,
        allMessages = allMessages,
        dateCreated = null
    ),
    Chat(
        id = 2,
        sender = User(
            1,
            fullName = "Angelina Jolie",
            image = R.drawable.person4,
            email = "daniyal.shah.cs@gmail.com",
            password = "123456"
        ),
        reciever = User(
            1, fullName = "", email = "daniyal.shah.cs@gmail.com",
            password = "123456", image = null
        ),
        lastMsg = allMessages[1],
        unreadMessagesCount = 4,
        allMessages = allMessages,
        dateCreated = null
    ),
    Chat(
        id = 3,
        sender = User(
            1,
            fullName = "Alexa James",
            image = R.drawable.person3,
            email = "daniyal.shah.cs@gmail.com",
            password = "123456"
        ),
        reciever = User(
            1, fullName = "", email = "daniyal.shah.cs@gmail.com",
            password = "123456", image = null
        ),
        lastMsg = allMessages[2],
        unreadMessagesCount = 10,
        allMessages = allMessages,
        dateCreated = null
    ),
    Chat(
        id = 4,
        sender = User(
            1,
            fullName = "Emilia Clark",
            image = R.drawable.person1,
            email = "daniyal.shah.cs@gmail.com",
            password = "123456"
        ),
        reciever = User(
            1, fullName = "", email = "daniyal.shah.cs@gmail.com",
            password = "123456", image = null
        ),
        lastMsg = allMessages[3],
        unreadMessagesCount = 0,
        allMessages = allMessages,
        dateCreated = null
    ),
)
val storyLists = listOf(
    Story("Max", R.drawable.person5, null),
    Story("Marina", R.drawable.person4, null),
    Story("Stacy", R.drawable.person3, null),
    Story("Jolie", R.drawable.person1, null),
    Story("Max", R.drawable.person5, null),
    Story("Marina", R.drawable.person4, null),
    Story("Stacy", R.drawable.person3, null),
    Story("Jolie", R.drawable.person1, null)
)




