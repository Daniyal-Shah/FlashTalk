package com.daniyal.flashtalk.presentation.ui.components.stories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daniyal.flashtalk.data.model.Story
import com.daniyal.flashtalk.data.storyLists
import com.daniyal.flashtalk.presentation.ui.components.common.CircularImage

@Composable
@Preview
fun StoriesList() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(15.dp),
    ) {
        items(storyLists) { story ->
            StoryItem(story)
        }
    }
}
