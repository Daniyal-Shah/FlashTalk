package com.daniyal.flashtalk.presentation.ui.screens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.daniyal.flashtalk.presentation.ui.components.common.HeadingText
import com.daniyal.flashtalk.presentation.ui.components.common.InputText
import androidx.compose.ui.unit.dp
import com.daniyal.flashtalk.data.singleUser
import com.daniyal.flashtalk.presentation.theme.MyrtleGreen
import com.daniyal.flashtalk.presentation.ui.components.common.CustomButton
import com.daniyal.flashtalk.presentation.ui.components.common.CustomButtonType
import com.daniyal.flashtalk.presentation.ui.components.common.SubHeadingText
import com.daniyal.flashtalk.presentation.viewmodels.LogInViewModel
import kotlinx.coroutines.CoroutineScope

@Composable
fun LoginScreen(
    viewModel: LogInViewModel,
    onPressNewAccount: () -> Unit,
    moveToHomeScreen: () -> Unit
) {
    val email = remember { mutableStateOf("test") }
    val password = remember { mutableStateOf("test") }

    fun handleLogin() {
        if (email.value == "test" && password.value == "test") {
            moveToHomeScreen()
        }
    }

    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize(1F)
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(Modifier.height(105.dp))
            HeadingText("Log in to FlashTalk", modifier = Modifier)
            SubHeadingText(
                "Welcome back! Sign in using your social account or email to continue us",
                modifier = Modifier.padding(top = 20.dp, bottom = 90.dp)
            )
            Spacer(Modifier.height(20.dp))
            Column(modifier = Modifier, verticalArrangement = Arrangement.spacedBy(25.dp)) {
                InputText(
                    modifier = Modifier,
                    label = "Your Email",
                    text = email.value,
                    onTextChange = {
                        email.value = it
                    })
                InputText(
                    modifier = Modifier,
                    label = "Password",
                    text = password.value,
                    onTextChange = {
                        password.value = it
                    })
            }
            Spacer(Modifier.height(80.dp))
            CustomButton(
                if (email.value.isNotEmpty() && password.value.isNotEmpty()) CustomButtonType.ACTIVE else CustomButtonType.INACTIVE,
                "Log In",
                onClick = { handleLogin() })
            Spacer(Modifier.height(25.dp))
            Text(
                "Create a new account",
                style = MaterialTheme.typography.labelMedium,
                color = MyrtleGreen,
                modifier = Modifier.clickable {
                    onPressNewAccount()
                }
            )

        }
    }

}