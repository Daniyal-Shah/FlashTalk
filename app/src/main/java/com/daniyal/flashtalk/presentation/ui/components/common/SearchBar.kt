package com.daniyal.flashtalk.presentation.ui.components.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daniyal.flashtalk.presentation.theme.CarosFontFamily

@Composable
@Preview
fun SearchBar() {
    val search = remember { mutableStateOf("Search") }
    Row(
        modifier = Modifier
            .clip(
                RoundedCornerShape(18.dp)
            )
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .padding(horizontal = 15.dp, vertical = 22.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            Icons.Outlined.Search,
            contentDescription = "",
            tint = MaterialTheme.colorScheme.tertiary,
            modifier = Modifier.size(27.dp)
        )
        BasicTextField(
            search.value,
            {
                search.value = it
            },
            modifier = Modifier
                .fillMaxWidth(
                    0.85F
                ),
            textStyle = TextStyle(
                color = MaterialTheme.colorScheme.tertiary,
                fontFamily = CarosFontFamily,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium
            ),
        )
        Icon(
            Icons.Outlined.Cancel,
            contentDescription = "",
            tint = if (search.value.isNotEmpty()) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.secondaryContainer,
            modifier = Modifier
                .size(23.dp)
                .clickable {
                    if (search.value.isNotEmpty()) search.value = ""
                }

        )
    }
}
