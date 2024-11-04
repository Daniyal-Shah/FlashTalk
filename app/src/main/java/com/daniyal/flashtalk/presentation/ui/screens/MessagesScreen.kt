package com.daniyal.flashtalk.presentation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daniyal.flashtalk.data.singleUser
import com.daniyal.flashtalk.presentation.ui.components.messages.BodyMessages
import com.daniyal.flashtalk.presentation.ui.components.messages.FooterMessages
import com.daniyal.flashtalk.presentation.ui.components.messages.HeaderMessages

@Composable
@Preview
fun MessagesScreen() {
    Surface(modifier = Modifier.fillMaxSize(1F)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            HeaderMessages(singleUser)
            BodyMessages(
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
