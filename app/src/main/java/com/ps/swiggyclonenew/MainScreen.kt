package com.ps.swiggyclonenew

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.ps.swiggyclonenew.ui.SwiggyTopBar
import com.ps.swiggyclonenew.ui.navigation.BottomNavGraph
import com.ps.swiggyclonenew.ui.navigation.BottomNavigationBar
import com.ps.swiggyclonenew.ui.reusables.WelcomeOffersBottomSheet

import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun MainScreen(context: Context) {
    // Check if the user is a first-time user
    val isFirstTime = remember { mutableStateOf(isFirstTimeUser(context)) }

    // Define the bottom sheet state
    val bottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()

    // Show the sheet if it's the first-time user
    LaunchedEffect(isFirstTime.value) {
        if (isFirstTime.value) {
            coroutineScope.launch {
                bottomSheetState.show() // Show the bottom sheet
            }
            setNotFirstTimeUser(context) // Update to not first-time user after showing the sheet
        }
    }

    // Define your BottomSheet content in ModalBottomSheetLayout

    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetShape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
        sheetContent = {
            WelcomeOffersBottomSheet(
                onDismiss = {
                    coroutineScope.launch {
                        bottomSheetState.hide() // Hide bottom sheet on button click
                    }
                }
            )
        }
    ) {
        val navController = rememberNavController()

        // Main app content with Scaffold
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = { BottomNavigationBar(navController = navController) },
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                BottomNavGraph(navController = navController)
            }
        }
    }
}


fun isFirstTimeUser(context: Context): Boolean {
    val prefs = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    return prefs.getBoolean("isFirstTimeUser", true)
}

fun setNotFirstTimeUser(context: Context) {
    val prefs = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    prefs.edit().putBoolean("isFirstTimeUser", false).apply()
}
