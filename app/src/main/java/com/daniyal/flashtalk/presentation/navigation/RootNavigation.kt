package com.daniyal.flashtalk.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.daniyal.flashtalk.presentation.ui.screens.ContactsScreen
import com.daniyal.flashtalk.presentation.ui.screens.HomeScreen
import com.daniyal.flashtalk.presentation.ui.screens.LoginScreen
import com.daniyal.flashtalk.presentation.ui.screens.MessagesScreen
import com.daniyal.flashtalk.presentation.ui.screens.ProfileScreen
import com.daniyal.flashtalk.presentation.ui.screens.SearchScreen
import com.daniyal.flashtalk.presentation.ui.screens.SignUpScreen
import com.daniyal.flashtalk.presentation.viewmodels.ContactViewModel
import com.daniyal.flashtalk.presentation.viewmodels.HomeViewModel
import com.daniyal.flashtalk.presentation.viewmodels.LogInViewModel
import com.daniyal.flashtalk.presentation.viewmodels.MessageViewModel
import com.daniyal.flashtalk.presentation.viewmodels.ProfileViewModel
import com.daniyal.flashtalk.presentation.viewmodels.SearchViewModel
import kotlinx.serialization.Serializable


@Serializable
object LogInScreen

@Serializable
object SignUpScreen

@Serializable
object HomeScreen

@Serializable
object MessageScreen

@Serializable
object ProfileScreen

@Serializable
object SearchScreen

@Serializable
object ContactScreen

@Composable
fun RootNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = LogInScreen) {

        composable<LogInScreen> {
            LoginScreen(LogInViewModel(), onPressNewAccount = {
                navController.navigate(SignUpScreen)
            }, moveToHomeScreen = {
                navController.navigate(HomeScreen)
            })
        }

        composable<SignUpScreen> {
            SignUpScreen(onPressAlreadyHaveAccount = {
                navController.navigate(LogInScreen)
            })
        }

        composable<HomeScreen> {
            HomeScreen(HomeViewModel(), onPressChatItem = {
                navController.navigate(MessageScreen)
            }, onPressUserImage = {
                navController.navigate(ProfileScreen)
            }, onPressSearchIcon = {
                navController.navigate(SearchScreen)
            })
        }

        composable<MessageScreen> {
            MessagesScreen(MessageViewModel(), onBackClick = {
                navController.popBackStack()
            })
        }

        composable<ProfileScreen> {
            ProfileScreen(ProfileViewModel(), onBackPress = {
                navController.popBackStack()
            }, onPressLogOut = {
                navController.navigate(LogInScreen)
            })
        }

        composable<ContactScreen> {
            ContactsScreen(ContactViewModel())
        }

        composable<SearchScreen> {
            SearchScreen(SearchViewModel(), onBackPress = {
                navController.popBackStack()
            })
        }
    }
}