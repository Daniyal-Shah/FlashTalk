package com.daniyal.flashtalk.presentation.ui.components.chat

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daniyal.flashtalk.data.model.Chat
import com.daniyal.flashtalk.presentation.theme.CarosFontFamily
import com.daniyal.flashtalk.presentation.ui.components.common.CircularImage
import com.daniyal.flashtalk.presentation.ui.components.common.DotType
import com.daniyal.flashtalk.presentation.viewmodels.ChatItemViewModel

@Composable
fun ChatItem(
    chat: Chat,
    onPressItem: (id: String) -> Unit,
    userStatus: DotType? = null,
    viewModel: ChatItemViewModel
) {
    val contacts = viewModel.contacts.collectAsState()
    val chatContact = contacts.value.find { it.id == chat.receiverId }

    Log.d("DDDD", chat.toString())

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onPressItem(chat.id)
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        chatContact?.image.let {
            if (it != null) {
                CircularImage(
                    dotType = userStatus,
                    modifier = Modifier.size(70.dp),
                    uri = it
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 15.dp, end = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.75F),
                verticalArrangement = Arrangement.Center
            ) {
                if (chatContact != null) {
                    Text(
                        chatContact.fullName,
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.primary,
                    )
                }
                Text(
                    chat.lastMsg.message,
                    fontFamily = CarosFontFamily,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    maxLines = 2
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(80.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "2 mins ago", fontFamily = CarosFontFamily,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    textAlign = TextAlign.Center,
                    lineHeight = 12.sp
                )
                if (chat.unreadMessagesCount > 0) {
                    Spacer(modifier = Modifier.height(6.dp))
                    Row(
                        modifier = Modifier
                            .size(25.dp)
                            .clip(shape = RoundedCornerShape(50))
                            .background(MaterialTheme.colorScheme.error),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            chat.unreadMessagesCount.toString(), fontFamily = CarosFontFamily,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Medium,
                        )
                    }
                }
            }
        }
    }
}
