package com.ps.swiggyclonenew.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
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
import com.ps.swiggyclonenew.ui.screens.RestaurentFilterScreen
import com.ps.swiggyclonenew.ui.screens.SwiggyMainScreen
import com.ps.swiggyclonenew.viewmodels.MainViewModel

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
    object RestaurentFilterScreen : Screen("filterscreen")
}

@Composable
fun BottomNavGraph(
    navController: NavHostController,
    mainViewModel: MainViewModel = hiltViewModel()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            SwiggyMainScreen(
                navController,
                userIntent = { intent ->
                    mainViewModel.onEvent(intent)
                }
            )
        }
        composable(route = Screen.Food.route) {
            FoodScreen(
                navController = navController,
                viewModel = mainViewModel,
                userIntent = { intent ->
                    mainViewModel.onEvent(intent) // Ensure this is actually passing the intent to onEvent
                }
            )
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
        composable(route = Screen.RestaurentFilterScreen.route) {
            RestaurentFilterScreen(
                navController,
                viewModel = mainViewModel,
                userIntent = { intent ->
                    mainViewModel.onEvent(intent)
                }
            )
        }
    }
}


