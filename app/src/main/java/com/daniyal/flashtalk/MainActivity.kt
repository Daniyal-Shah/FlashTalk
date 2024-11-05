package com.daniyal.flashtalk


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.activity.compose.setContent
import com.daniyal.flashtalk.presentation.theme.FlashTalkTheme
import com.daniyal.flashtalk.presentation.ui.screens.ContactsScreen
import com.daniyal.flashtalk.presentation.ui.screens.HomeScreen
import com.daniyal.flashtalk.presentation.ui.screens.MessagesScreen
import com.daniyal.flashtalk.presentation.ui.screens.ProfileScreen
import com.daniyal.flashtalk.presentation.viewmodels.ContactViewModel
import com.daniyal.flashtalk.presentation.viewmodels.HomeViewModel
import com.daniyal.flashtalk.presentation.viewmodels.MessageViewModel
import com.daniyal.flashtalk.presentation.viewmodels.ProfileViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlashTalkTheme {
              ProfileScreen(viewModel = ProfileViewModel())
            }
        }
    }
}
