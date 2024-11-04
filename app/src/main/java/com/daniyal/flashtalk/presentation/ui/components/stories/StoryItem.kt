package com.daniyal.flashtalk.presentation.ui.components.stories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.daniyal.flashtalk.data.model.Story
import com.daniyal.flashtalk.presentation.ui.components.common.CircularImage

@Composable
fun StoryItem(item: Story) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        CircularImage(modifier = Modifier.size(65.dp), item.userImage)
        Text(item.userName, style = MaterialTheme.typography.bodyMedium)
    }
}