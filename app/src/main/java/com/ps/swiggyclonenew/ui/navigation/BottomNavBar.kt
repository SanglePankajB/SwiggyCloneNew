package com.ps.swiggyclonenew.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

data class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector
)

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem("Home", Screen.Home.route, Icons.Default.Home),
        BottomNavItem("Food", Screen.Food.route, Icons.Default.ShoppingCart),
        BottomNavItem("Instamart", Screen.Instamart.route, Icons.Default.Person),
        BottomNavItem("Dineout", Screen.Dineout.route, Icons.Default.Person),
        BottomNavItem("Reorder", Screen.Reorder.route, Icons.Default.Person),
        BottomNavItem("Genie", Screen.Genie.route, Icons.Default.Person),
    )

    Box(
        modifier = Modifier.padding(bottom = 16.dp) // Lift the BottomNavigation 16dp above the bottom
    ) {
        BottomNavigation(backgroundColor = Color.White, contentColor = Color.Black) {
            val navBackStackEntry = navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry.value?.destination?.route

            items.forEach { item ->
                BottomNavigationItem(
                    icon = { Icon(imageVector = item.icon, contentDescription = item.name) },
                    label = {
                        Text(
                            text = item.name,
                            color = Color.Black,
                            fontSize = 10.sp,
                            maxLines = 1
                        )
                    },
                    selected = currentRoute == item.route,
                    onClick = {
                        if (currentRoute != item.route) {

                            navController.navigate(item.route) {
                                // Only pop back to the start destination if it's one of the bottom navigation items
                                val bottomNavScreens = listOf(Screen.Home.route, Screen.Food.route, Screen.Instamart.route, Screen.Dineout.route, Screen.Reorder.route, Screen.Genie.route)

                                if (currentRoute !in bottomNavScreens) {
                                    // If the current screen is not a bottom nav screen (e.g., profile), clear the back stack
                                    popUpTo(navController.graph.startDestinationId) { inclusive = true }
                                } else {
                                    // Otherwise, preserve the state and avoid multiple copies of the same screen
                                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    }
                )
            }
        }
    }
}
