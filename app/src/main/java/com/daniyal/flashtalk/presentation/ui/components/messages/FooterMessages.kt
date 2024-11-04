package com.daniyal.flashtalk.presentation.ui.components.messages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.outlined.Attachment
import androidx.compose.material.icons.outlined.PhotoCamera
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daniyal.flashtalk.presentation.theme.CarosFontFamily


@Composable
fun FooterMessages(modifier: Modifier) {
    val message = remember { mutableStateOf("Enter your message!") }

    Row(
        modifier = modifier
            .padding(
                horizontal = 20.dp,
            )
            .padding(bottom = 30.dp), horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            Icons.Outlined.Attachment,
            contentDescription = "",
            tint = MaterialTheme.colorScheme.tertiary,
            modifier = Modifier.size(28.dp)
        )
        Row(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(12.dp)
                )
                .background(MaterialTheme.colorScheme.inverseSurface)
                .padding(horizontal = 15.dp, vertical = 22.dp)
                .fillMaxWidth(0.8F),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicTextField(
                message.value,
                {
                    message.value = it
                },
                modifier = Modifier.fillMaxWidth(0.88F),
                textStyle = TextStyle(
                    color = MaterialTheme.colorScheme.inversePrimary,
                    fontFamily = CarosFontFamily,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                ),
            )
            Icon(
                Icons.Filled.ContentCopy,
                contentDescription = "",
                tint = MaterialTheme.colorScheme.inversePrimary,
                modifier = Modifier.size(23.dp)
            )
        }
        Icon(
            Icons.Outlined.PhotoCamera,
            contentDescription = "",
            tint = MaterialTheme.colorScheme.tertiary,
            modifier = Modifier
                .size(28.dp)
                .fillMaxWidth()
        )
    }
}
