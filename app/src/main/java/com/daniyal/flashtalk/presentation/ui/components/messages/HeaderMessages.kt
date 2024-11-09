package com.daniyal.flashtalk.presentation.ui.components.messages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daniyal.flashtalk.data.model.User
import com.daniyal.flashtalk.presentation.theme.CarosFontFamily
import com.daniyal.flashtalk.presentation.ui.components.common.CircularImage

@Composable
fun HeaderMessages(
    user: User,
    onBackPress: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp, bottom = 15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
    ) {
        Spacer(modifier = Modifier.width(20.dp))
        Icon(
            Icons.Filled.ArrowBackIosNew,
            contentDescription = "",
            tint = MaterialTheme.colorScheme.tertiary,
            modifier = Modifier.clickable {
                onBackPress()
            }
        )
        Spacer(modifier = Modifier.width(35.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Row {
//                user.image?.let { CircularImage(modifier = Modifier.size(50.dp), it) }
                Spacer(modifier = Modifier.width(15.dp))
                Column(
                    verticalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = user.fullName, fontFamily = CarosFontFamily, fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        lineHeight = 14.sp,
                        color = MaterialTheme.colorScheme.tertiary,
                    )
                    Text(
                        text = "Active Now", fontFamily = CarosFontFamily, fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.inversePrimary,
                        lineHeight = 11.sp,
                    )
                }
            }
            Row {
                Icon(
                    Icons.Outlined.Call,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier.size(30.dp)
                )
                Spacer(modifier = Modifier.width(20.dp))
            }
        }
    }
}