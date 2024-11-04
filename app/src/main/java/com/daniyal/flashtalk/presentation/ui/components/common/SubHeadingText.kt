package com.daniyal.flashtalk.presentation.ui.components.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.daniyal.flashtalk.presentation.theme.CarosFontFamily
import com.daniyal.flashtalk.presentation.theme.GrayDarker


@Composable()
fun SubHeadingText(text: String, modifier: Modifier) {
    Text(
        modifier = modifier.fillMaxWidth(0.8F),
        text = text, color = GrayDarker, fontSize = 14.sp,
        fontFamily = CarosFontFamily,
        fontWeight = FontWeight.Light,
        textAlign = TextAlign.Center
    )
}
