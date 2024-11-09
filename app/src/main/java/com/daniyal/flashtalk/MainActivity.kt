package com.daniyal.flashtalk


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.compose.rememberNavController
import com.daniyal.flashtalk.presentation.navigation.BottomNavigation
import com.daniyal.flashtalk.presentation.navigation.RootNavigation
import com.daniyal.flashtalk.presentation.theme.FlashTalkTheme
import com.daniyal.flashtalk.presentation.ui.components.common.IndeterminateCircularSpinner
import com.daniyal.flashtalk.presentation.ui.screens.ContactsScreen
import com.daniyal.flashtalk.presentation.ui.screens.HomeScreen
import com.daniyal.flashtalk.presentation.ui.screens.MessagesScreen
import com.daniyal.flashtalk.presentation.ui.screens.ProfileScreen
import com.daniyal.flashtalk.presentation.ui.screens.SignUpScreen
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
                RootNavigation(
                    navController = rememberNavController(),
                )
            }
        }
    }
}
