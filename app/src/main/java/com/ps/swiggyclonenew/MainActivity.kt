package com.ps.swiggyclonenew

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            //You remove the theme, app will not be affected by the dark/light mode
//            SwiggyCloneNewTheme {
                MainScreen(context = this)
//            }
        }
    }
}
