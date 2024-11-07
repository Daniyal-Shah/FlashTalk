package com.daniyal.flashtalk.presentation.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.daniyal.flashtalk.presentation.ui.components.common.HeadingText
import com.daniyal.flashtalk.presentation.ui.components.common.InputText
import androidx.compose.ui.unit.dp
import com.daniyal.flashtalk.presentation.theme.MyrtleGreen
import com.daniyal.flashtalk.presentation.ui.components.common.CustomButton
import com.daniyal.flashtalk.presentation.ui.components.common.CustomButtonType
import com.daniyal.flashtalk.presentation.ui.components.common.SubHeadingText

@Preview()
@Composable
fun SignUpScreen(onPressAlreadyHaveAccount: ()-> Unit) {
    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize(1F)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(Modifier.height(30.dp))
            HeadingText("Sign up with Email", modifier = Modifier)
//            SubHeadingText(
//                "Get chatting with friends and family today by signing up for our chat app!",
//                modifier = Modifier.padding(top = 20.dp)
//            )
            Spacer(Modifier.height(30.dp))
            Column(modifier = Modifier, verticalArrangement = Arrangement.spacedBy(10.dp)) {
                InputText(
                    modifier = Modifier,
                    label = "Your Name",
                    text = "",
                    onTextChange = {
                    })
                InputText(
                    modifier = Modifier,
                    label = "Your Email",
                    text = "",
                    onTextChange = {
                    })
                InputText(
                    modifier = Modifier,
                    label = "Password",
                    text = "",
                    onTextChange = {
                    })
                InputText(
                    modifier = Modifier,
                    label = "Confirm Password",
                    text = "",
                    onTextChange = {
                    })
                InputText(
                    modifier = Modifier,
                    label = "Phone Number",
                    text = "",
                    onTextChange = {

                    })
                InputText(
                    modifier = Modifier,
                    label = "Bio",
                    text = "",
                    onTextChange = {
                    })
                InputText(
                    modifier = Modifier,
                    label = "Address",
                    text = "",
                    onTextChange = {

                    })
                CustomButton(
                    CustomButtonType.ACTIVE,
                    "Create an account",
                    onClick = { })

                Spacer(Modifier.height(10.dp))
                Text(
                    "Already have account? Log In",
                    style = MaterialTheme.typography.labelMedium,
                    color = MyrtleGreen,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth().clickable {
                        onPressAlreadyHaveAccount()
                    }
                )
            }
        }
    }
}