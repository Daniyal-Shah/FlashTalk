package com.daniyal.flashtalk.presentation.ui.components.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
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
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .background(Color.White)
            .padding(vertical = 3.dp)
    ) {
        Text(
            modifier = Modifier.padding(bottom = 14.dp),
            color = MyrtleGreen,
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
        )
        Box(
            modifier = Modifier
                .fillMaxWidth(1F)
                .height(1.dp)
                .background(Gray)
        )

    }
}