package com.daniyal.flashtalk.presentation.ui.components.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.daniyal.flashtalk.presentation.theme.Verdigris

@Composable()
fun HeadingText(text: String, modifier: Modifier) {
    Column(modifier.fillMaxWidth(0.55f)) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = text,
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(Modifier.height(1.dp))
        Box(
            modifier = Modifier
                .height(4.dp)
                .fillMaxWidth(0.9f)
                .background(Verdigris)
                .align(Alignment.CenterHorizontally)
        )
    }
}

