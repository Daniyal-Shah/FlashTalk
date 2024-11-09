package com.daniyal.flashtalk.presentation.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.daniyal.flashtalk.presentation.ui.components.common.HeadingText
import com.daniyal.flashtalk.presentation.ui.components.common.InputText
import androidx.compose.ui.unit.dp
import com.daniyal.flashtalk.presentation.theme.MyrtleGreen
import com.daniyal.flashtalk.presentation.ui.components.common.CustomButton
import com.daniyal.flashtalk.presentation.ui.components.common.IndeterminateCircularSpinner
import com.daniyal.flashtalk.presentation.ui.components.common.SubHeadingText
import com.daniyal.flashtalk.presentation.viewmodels.LogInViewModel

@Composable
fun LoginScreen(
    viewModel: LogInViewModel,
    onPressNewAccount: () -> Unit,
    moveToHomeScreen: () -> Unit
) {
    val loading = viewModel.loading.collectAsState()

    Surface() {
        Column(
            modifier = Modifier
                .fillMaxSize()
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
                    text = viewModel.email.value,
                    onTextChange = {
                        viewModel.email.value = it
                        viewModel.emailError.value = null
                    },
                    errorMessage = viewModel.emailError.value
                )
                InputText(
                    modifier = Modifier,
                    label = "Password",
                    text = viewModel.password.value,
                    onTextChange = {
                        viewModel.password.value = it
                        viewModel.passwordError.value = null
                    },
                    isPassword = true,
                    errorMessage = viewModel.passwordError.value
                )
            }
            Spacer(Modifier.height(80.dp))
            CustomButton(
                title = "Log In",
                onClick = {
                    viewModel.submitForm {
                        moveToHomeScreen()
                    }
                }
            )
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
        if (loading.value) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.secondary.copy(alpha = 0.8F)),
                Alignment.Center
            ) {
                IndeterminateCircularSpinner()
            }
        }


    }

}