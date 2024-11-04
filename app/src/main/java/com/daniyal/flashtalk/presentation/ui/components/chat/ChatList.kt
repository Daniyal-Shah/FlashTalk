package com.daniyal.flashtalk.presentation.ui.components.chat

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daniyal.flashtalk.data.chatsLists

@Composable
@Preview
fun ChatList() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(chatsLists) { chat ->
            ChatItem(chat)
        }
    }
}


