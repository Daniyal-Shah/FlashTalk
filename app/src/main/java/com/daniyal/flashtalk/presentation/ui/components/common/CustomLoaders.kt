package com.daniyal.flashtalk.presentation.ui.components.common

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun IndeterminateCircularSpinner(
    modifier: Modifier = Modifier.size(50.dp),
    color: Color = MaterialTheme.colorScheme.primary,
    stokeWith: Dp = 2.dp
) {
    CircularProgressIndicator(
        modifier = modifier,
        color = color,
        strokeWidth = stokeWith
    )
}

@Composable
fun DeterminateCircularSpinner(progress: Float) {
    CircularProgressIndicator(
        progress = { progress },
        modifier = Modifier.size(64.dp),
        color = MaterialTheme.colorScheme.primary,
        strokeWidth = 4.dp,
    )
}
