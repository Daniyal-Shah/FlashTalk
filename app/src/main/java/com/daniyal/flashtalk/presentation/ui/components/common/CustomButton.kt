package com.daniyal.flashtalk.presentation.ui.components.common


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


enum class CustomButtonType(val value: String) {
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE")
}

@Composable
fun CustomButton(type: CustomButtonType, title: String, onClick: () -> Unit) {
    val buttonColor =
        if (type === CustomButtonType.ACTIVE) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondaryContainer

    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = {
            onClick()
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = buttonColor,
            contentColor = if (type === CustomButtonType.ACTIVE) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.inversePrimary,
        ),
        shape = RoundedCornerShape(size = 16.dp)
    ) {
        Text(
            modifier = Modifier.padding(vertical = 10.dp),
            text = title, textAlign = TextAlign.Center,
            style = MaterialTheme.typography.labelMedium
        )
    }
}
