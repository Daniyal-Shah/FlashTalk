package com.daniyal.flashtalk.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.daniyal.flashtalk.R
import com.daniyal.flashtalk.presentation.theme.CarosFontFamily

data class BottomNavigationItem(
    val title: String,
    val icon: Int,
    val hasNews: Boolean,
    val badgeCount: Int? = null,
)

@Composable
fun BottomNavigation(
    items: List<BottomNavigationItem>,
    selectedItemIndex: Int,
    setSelectedIndex: (index: Int) -> Unit
) {
    NavigationBar(
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                label = {
                    Text(
                        item.title,
                        fontFamily = CarosFontFamily, fontSize = 15.sp,
                        fontWeight = FontWeight.Medium,
                        color = if (selectedItemIndex == index) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            MaterialTheme.colorScheme.inversePrimary
                        }
                    )
                },
                selected = selectedItemIndex == index,
                onClick = {
                    setSelectedIndex(index)
                },
                icon = {
                    Icon(
                        painter = painterResource(item.icon),
                        contentDescription = "",
                        tint = if (selectedItemIndex == index) {
                            MaterialTheme.colorScheme.primary
                        } else {
                            MaterialTheme.colorScheme.inversePrimary
                        }
                    )
                }
            )
        }
    }
}