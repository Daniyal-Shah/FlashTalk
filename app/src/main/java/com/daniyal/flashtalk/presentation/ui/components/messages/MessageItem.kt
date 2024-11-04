package com.daniyal.flashtalk.presentation.ui.components.messages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.daniyal.flashtalk.R
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daniyal.flashtalk.data.model.Message
import com.daniyal.flashtalk.presentation.theme.CarosFontFamily
import com.daniyal.flashtalk.presentation.ui.components.common.CircularImage


@Composable
fun MessageItem(
    message: Message
) {

    val textColor =
        if (message.isMessageReceived) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.secondary
    val bgColor =
        if (message.isMessageReceived) MaterialTheme.colorScheme.inverseSurface else MaterialTheme.colorScheme.primary

    val cornerSize = 15.dp
    val messageShape =
        if (message.isMessageReceived) RoundedCornerShape(
            0.dp,
            cornerSize,
            cornerSize,
            cornerSize
        ) else RoundedCornerShape(
            cornerSize,
            0.dp,
            cornerSize,
            cornerSize
        )


    Row() {
        if (message.isMessageReceived) {
            CircularImage(modifier = Modifier.size(40.dp), R.drawable.person5)
            Spacer(Modifier.width(10.dp))
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = if (message.isMessageReceived) 0.dp else 65.dp,
                    end = if (message.isMessageReceived) 65.dp else 0.dp
                ),
        ) {
            Text(
                "You did your job well, I want yo meet you, are you available for a call!!, Let me know if you are interested.",
                fontFamily = CarosFontFamily,
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
                color = textColor,
                modifier = Modifier
                    .clip(messageShape)
                    .background(bgColor)
                    .padding(15.dp),
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                "09:45 AM",
                fontFamily = CarosFontFamily,
                fontSize = 11.sp,
                lineHeight = 11.sp,
                fontWeight = FontWeight.Normal,
                color = MaterialTheme.colorScheme.inversePrimary,
                modifier = Modifier.align(Alignment.End)
            )

        }
    }


}