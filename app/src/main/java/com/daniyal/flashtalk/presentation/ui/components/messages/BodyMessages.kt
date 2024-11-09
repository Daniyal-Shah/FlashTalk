package com.daniyal.flashtalk.presentation.ui.components.messages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.daniyal.flashtalk.data.model.Message
import com.daniyal.flashtalk.presentation.ui.components.common.IndeterminateCircularSpinner

@Composable
fun BodyMessages(messages: List<Message>, messageLoading: Boolean ,modifier: Modifier) {
    Surface(
        modifier = modifier
            .padding(horizontal = 15.dp)
    ) {
        if(messageLoading)
        {
            Column (
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                IndeterminateCircularSpinner(
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
        LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            items(messages) { item: Message ->
                MessageItem(message = item)
            }
        }
    }
}