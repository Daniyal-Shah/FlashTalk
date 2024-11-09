package com.daniyal.flashtalk.presentation.ui.components.chat

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.daniyal.flashtalk.data.model.Chat
import com.daniyal.flashtalk.presentation.ui.components.common.DotType

@Composable
fun ChatList(chats: List<Chat>, onPressChatItem: (id: Int)-> Unit) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(chats) { chat ->
            ChatItem(onPressItem = {
                onPressChatItem(chat.id)
            } , chat = chat, userStatus = DotType.ACTIVE)
        }
    }
}


