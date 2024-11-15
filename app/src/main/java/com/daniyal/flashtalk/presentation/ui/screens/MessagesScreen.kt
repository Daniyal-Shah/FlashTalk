package com.daniyal.flashtalk.presentation.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.daniyal.flashtalk.presentation.ui.components.messages.BodyMessages
import com.daniyal.flashtalk.presentation.ui.components.messages.FooterMessages
import com.daniyal.flashtalk.presentation.ui.components.messages.HeaderMessages
import com.daniyal.flashtalk.presentation.viewmodels.MessageViewModel

@Composable
fun MessagesScreen(viewModel: MessageViewModel, userId: String, onBackClick: () -> Unit) {


    val messages = viewModel.messages.collectAsState()
    val messageLoading = viewModel.messageLoading.collectAsState()
    val contacts = viewModel.contacts.collectAsState()
    val chatContact = contacts.value.find { it.id == userId }
    Log.d("DDDD->", userId)
    Log.d("DDDD->", contacts.value.toString())

    Surface(modifier = Modifier.fillMaxSize(1F)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            if (chatContact != null) {
                HeaderMessages(chatContact, onBackClick)
            }
            BodyMessages(
                messages.value,
                messageLoading.value,
                modifier = Modifier
                    .fillMaxHeight(0.82F)
            )
            FooterMessages(
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}
