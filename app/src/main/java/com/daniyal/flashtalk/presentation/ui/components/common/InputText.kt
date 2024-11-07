package com.daniyal.flashtalk.presentation.ui.components.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daniyal.flashtalk.presentation.theme.CarosFontFamily
import com.daniyal.flashtalk.presentation.theme.Gray
import com.daniyal.flashtalk.presentation.theme.MyrtleGreen
import com.daniyal.flashtalk.presentation.theme.VampireBlack

@Composable
fun InputText(
    label: String,
    text: String,
    onTextChange: (text: String) -> Unit,
    modifier: Modifier,
    isPassword: Boolean = false,
    errorMessage: String? = null
) {
    Column(
        modifier = modifier
            .background(Color.White)
            .padding(vertical = 3.dp)
    ) {
        Text(
            modifier = Modifier.padding(bottom = 14.dp),
            color = if (errorMessage != null) {
                MaterialTheme.colorScheme.error
            } else {
                MaterialTheme.colorScheme.primary
            },
            fontSize = 14.sp,
            fontFamily = CarosFontFamily,
            fontWeight = FontWeight.Medium,
            text = label
        )
        BasicTextField(
            modifier = Modifier
                .fillMaxWidth(1F)
                .padding(bottom = 7.dp),
            value = text,
            onValueChange = {
                onTextChange(it)
            },
            textStyle = TextStyle(
                color = VampireBlack,
                fontFamily = CarosFontFamily,
                fontSize = 16.sp,
            ),
            visualTransformation = if (isPassword) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
        )
        Box(
            modifier = Modifier
                .fillMaxWidth(1F)
                .height(1.dp)
                .background(Gray)
        )
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            errorMessage?.let {
                Text(
                    color = MaterialTheme.colorScheme.error,
                    fontSize = 12.sp,
                    fontFamily = CarosFontFamily,
                    fontWeight = FontWeight.Normal,
                    text = it
                )
            }
        }

    }
}