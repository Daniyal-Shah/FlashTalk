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
import com.daniyal.flashtalk.presentation.viewmodels.SignUpViewModel

@Composable
fun SignUpScreen(viewModel: SignUpViewModel, onPressAlreadyHaveAccount: () -> Unit) {
    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(Modifier.height(20.dp))
            HeadingText("Sign up with Email", modifier = Modifier)
//            SubHeadingText(
//                "Get chatting with friends and family today by signing up for our chat app!",
//                modifier = Modifier.padding(top = 10.dp)
//            )
            Spacer(Modifier.height(30.dp))
            Column(modifier = Modifier, verticalArrangement = Arrangement.spacedBy(10.dp)) {
                // Input fields with state management
                InputText(
                    modifier = Modifier,
                    label = "Your Name",
                    text = viewModel.name.value,
                    onTextChange = {
                        viewModel.name.value = it
                        viewModel.nameError.value = null
                        viewModel.validateInputs()
                    },
                    errorMessage = viewModel.nameError.value
                )
                InputText(
                    modifier = Modifier,
                    label = "Your Email",
                    text = viewModel.email.value,
                    onTextChange = {
                        viewModel.email.value = it
                        viewModel.emailError.value = null
                        viewModel.validateInputs()
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
                        viewModel.validateInputs()
                    },
                    isPassword = true,
                    errorMessage = viewModel.passwordError.value
                )
                InputText(
                    modifier = Modifier,
                    label = "Confirm Password",
                    text = viewModel.confirmPassword.value,
                    onTextChange = {
                        viewModel.confirmPassword.value = it
                        viewModel.confirmPasswordError.value = null
                        viewModel.validateInputs()
                    },
                    isPassword = true,
                    errorMessage = viewModel.confirmPasswordError.value
                )
                InputText(
                    modifier = Modifier,
                    label = "Phone Number",
                    text = viewModel.phoneNumber.value,
                    onTextChange = {
                        viewModel.phoneNumber.value = it
                        viewModel.phoneError.value = null
                        viewModel.validateInputs()
                    },
                    errorMessage = viewModel.phoneError.value
                )
                InputText(
                    modifier = Modifier,
                    label = "Bio",
                    text = viewModel.bio.value,
                    onTextChange = {
                        viewModel.bio.value = it
                        viewModel.bioError.value = null
                        viewModel.validateInputs()
                    },
                    errorMessage = viewModel.bioError.value
                )

                Spacer(Modifier.height(10.dp))
                // Button to create an account
                CustomButton(
                    CustomButtonType.ACTIVE,
                    "Create an account",
                    onClick = {
                        viewModel.submitForm {
                            // Handle successful signup, e.g., navigate to another screen
                        }
                    }
                )
                Text(
                    "Already have an account? Log In",
                    style = MaterialTheme.typography.labelMedium,
                    color = MyrtleGreen,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            onPressAlreadyHaveAccount()
                        }
                )
            }
        }
    }
}