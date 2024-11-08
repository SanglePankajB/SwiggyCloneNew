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
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

data class BottomNavItem(
    val name: String,
    val route: String,
    val iconUnselected: ImageVector,
    val iconSelected: ImageVector
)

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem("Home", Screen.Home.route, Icons.Outlined.Home, Icons.Default.Home),
        BottomNavItem("Food", Screen.Food.route, Icons.Outlined.ShoppingCart, Icons.Filled.ShoppingCart),
        BottomNavItem("Instamart", Screen.Instamart.route, Icons.Outlined.Person, Icons.Filled.Person),
        BottomNavItem("Dineout", Screen.Dineout.route, Icons.Outlined.Person, Icons.Filled.Person),
        BottomNavItem("Reorder", Screen.Reorder.route, Icons.Outlined.Person, Icons.Filled.Person),
        BottomNavItem("Genie", Screen.Genie.route, Icons.Outlined.Person, Icons.Filled.Person),
    )

    Box(
        modifier = Modifier.padding(bottom = 16.dp) // Lift the BottomNavigation 16dp above the bottom
    ) {
        BottomNavigation(backgroundColor = Color.White, contentColor = Color.Red) {
            val navBackStackEntry = navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry.value?.destination?.route

            items.forEach { item ->
                val isSelected = currentRoute == item.route
                BottomNavigationItem(
                    icon = {
                        Icon(
                            imageVector = if (isSelected) item.iconSelected else item.iconUnselected,
                            contentDescription = item.name,
                            tint = if (isSelected) Color(0xFFFF5722) else Color.Gray
                        )
                           },
                    label = {
                        Text(
                            text = item.name,
                            color = if (isSelected) Color(0xFFFF5722) else Color.Gray,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1
                        )
                    },
                    selected = isSelected,
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
