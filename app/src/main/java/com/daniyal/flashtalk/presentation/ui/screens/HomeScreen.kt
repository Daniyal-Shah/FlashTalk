package com.daniyal.flashtalk.presentation.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daniyal.flashtalk.R
import com.daniyal.flashtalk.presentation.ui.components.chat.ChatList
import com.daniyal.flashtalk.presentation.ui.components.home.Header
import com.daniyal.flashtalk.presentation.ui.components.stories.StoriesList


@Composable
@Preview
fun HomeScreen() {
    Surface(modifier = Modifier.fillMaxSize(1F), color = MaterialTheme.colorScheme.tertiary) {
        Column(modifier = Modifier.fillMaxSize()) {
//          Stories Container
            Column(
                modifier = Modifier
                    .fillMaxHeight(0.3F)
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 40.dp)
            ) {
                Header(
                    title = "Home",
                    userImage = R.drawable.person4,
                    leftIcon = Icons.Filled.Search,
                    imageContentDescription = null
                )
                Spacer(modifier = Modifier.height(40.dp))
                StoriesList()
            }

//          Chats Container
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(45.dp, 45.dp, 0.dp, 0.dp))
                    .background(MaterialTheme.colorScheme.secondary)

            ) {
//                Handle
                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .height(5.dp)
                            .width(60.dp)
                            .clip(RoundedCornerShape(3.dp))
                            .background(MaterialTheme.colorScheme.outline)
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
//                Chats List
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 10.dp),
                    verticalArrangement = Arrangement.spacedBy(15.dp)
                )
                {
                    ChatList()
                }
            }
        }
    }
}
