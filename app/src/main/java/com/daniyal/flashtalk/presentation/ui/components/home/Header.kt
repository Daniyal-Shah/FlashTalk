package com.daniyal.flashtalk.presentation.ui.components.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.daniyal.flashtalk.presentation.ui.components.common.CircularImage

@Composable
fun Header(
    userImage: String? = null,
    title: String,
    leftIcon: ImageVector? = null,
    imageContentDescription: String?,
    rightIcon: ImageVector? = null,
    onPressUserImage: () -> Unit,
    onPressLeftIcon: () -> Unit,

) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        if (leftIcon != null) {
            OutlinedIconButton(
                onClick = {
                    onPressLeftIcon()
                },
                shape = IconButtonDefaults.outlinedShape,
            ) {
                Icon(
                    leftIcon,
                    contentDescription = imageContentDescription,
                )
            }
        }
        Text(text = title, style = MaterialTheme.typography.headlineMedium)

        if (rightIcon != null) {
            OutlinedIconButton(
                onClick = {},
                shape = IconButtonDefaults.outlinedShape,
            ) {
                Icon(
                    rightIcon,
                    contentDescription = imageContentDescription,
                )
            }
        }
        CircularImage(modifier = Modifier.size(50.dp).clickable {
            onPressUserImage()
        }, userImage ?: "")
    }
}