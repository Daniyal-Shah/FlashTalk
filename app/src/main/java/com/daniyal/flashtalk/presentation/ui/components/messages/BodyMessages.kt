package com.daniyal.flashtalk.presentation.ui.components.messages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daniyal.flashtalk.data.allMessages
import com.daniyal.flashtalk.data.model.Message

@Composable
fun BodyMessages(modifier: Modifier) {
    Surface(
        modifier = modifier
//            .fillMaxSize()
            .padding(horizontal = 15.dp)
    ) {
        LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            items(allMessages) { item: Message ->
                MessageItem(message = item)
            }
        }
    }
}