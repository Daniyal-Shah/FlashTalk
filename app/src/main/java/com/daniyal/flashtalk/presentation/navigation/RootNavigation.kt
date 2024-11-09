package com.daniyal.flashtalk.presentation.navigation

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
import com.daniyal.flashtalk.presentation.viewmodels.SignUpViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.serialization.Serializable


@Serializable
object LogInScreen

@Serializable
object SignUpScreen

@Serializable
object HomeScreen

@Serializable
data class MessageScreen(val userId: Int)

@Serializable
object ProfileScreen

@Serializable
object SearchScreen

@Serializable
object ContactScreen

@Composable
fun RootNavigation(
    navController: NavHostController,
) {
    val startDestination =
        if (FirebaseAuth.getInstance().currentUser != null) HomeScreen else LogInScreen

    Scaffold(
        bottomBar = {
        }
    ) { innerPadding ->
        NavHost(
            navController,
            startDestination = startDestination,
        ) {
            // LogIn Screen
            composable<LogInScreen> {
                LoginScreen(LogInViewModel(), onPressNewAccount = {
                    navController.navigate(SignUpScreen)
                }, moveToHomeScreen = {
                    navController.navigate(HomeScreen)

                })
            }
            // SignUp Screen
            composable<SignUpScreen> {
                SignUpScreen(onPressAlreadyHaveAccount = {
                    navController.navigate(LogInScreen)
                }, viewModel = SignUpViewModel())
            }
            // Home Screen
            composable<HomeScreen> {
                HomeScreen(HomeViewModel(),
                    onPressChatItem = {
                        navController.navigate(MessageScreen(it))

                    }, onPressUserImage = {
                        navController.navigate(ProfileScreen)

                    }, onPressSearchIcon = {
                        navController.navigate(SearchScreen)

                    })
            }
            // Message Screen
            composable<MessageScreen> {
                MessagesScreen(MessageViewModel(), onBackClick = {
                    navController.popBackStack()

                })
            }
            // Profile Screen
            composable<ProfileScreen> {
                ProfileScreen(ProfileViewModel(), onBackPress = {
                    navController.popBackStack()

                }, onPressLogOut = {
                    navController.navigate(LogInScreen)

                })
            }
            // Contacts Screen
            composable<ContactScreen> {
                ContactsScreen(ContactViewModel())

            }
            // Search Screen
            composable<SearchScreen> {
                SearchScreen(SearchViewModel(), onBackPress = {
                    navController.popBackStack()

                })
            }
        }
    }
}