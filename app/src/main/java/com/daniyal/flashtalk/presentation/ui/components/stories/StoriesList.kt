package com.daniyal.flashtalk.presentation.ui.components.stories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.daniyal.flashtalk.data.model.Story

@Composable
fun StoriesList(stories: List<Story> ) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(15.dp),
    ) {
        items(stories) { story ->
            StoryItem(story)
        }
    }
}
