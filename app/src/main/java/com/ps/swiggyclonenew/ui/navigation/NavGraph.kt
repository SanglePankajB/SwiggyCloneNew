package com.ps.swiggyclonenew.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ps.swiggyclonenew.ui.screens.DineoutScreen
import com.ps.swiggyclonenew.ui.screens.FoodScreen
import com.ps.swiggyclonenew.ui.screens.GenieScreen
import com.ps.swiggyclonenew.ui.screens.InstamartScreen
import com.ps.swiggyclonenew.ui.screens.LocationScreen
import com.ps.swiggyclonenew.ui.screens.LoginScreen
import com.ps.swiggyclonenew.ui.screens.ProfileScreen
import com.ps.swiggyclonenew.ui.screens.ReorderScreen
import com.ps.swiggyclonenew.ui.screens.SwiggyMainScreen

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Food : Screen("food")
    object Instamart : Screen("instamart")
    object Dineout : Screen("dineout")
    object Reorder : Screen("reorder")
    object Genie : Screen("genie")
    object Login : Screen("login")
    object Profile : Screen("profile")
    object SetLocation : Screen("setlocation")
}

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            SwiggyMainScreen(navController)
        }
        composable(route = Screen.Food.route) {
            FoodScreen(navController)
        }
        composable(route = Screen.Instamart.route) {
            InstamartScreen()
        }
        composable(route = Screen.Dineout.route) {
            DineoutScreen()
        }
        composable(route = Screen.Reorder.route) {
            ReorderScreen()
        }
        composable(route = Screen.Genie.route) {
            GenieScreen()
        }
        composable(route = Screen.Login.route) {
            LoginScreen()
        }
        composable(route = Screen.Profile.route) {
            ProfileScreen(navController)
        }
        composable(route = Screen.SetLocation.route) {
            LocationScreen(navController)
        }
    }
}


