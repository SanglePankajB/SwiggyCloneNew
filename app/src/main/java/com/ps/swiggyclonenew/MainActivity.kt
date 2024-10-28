package com.ps.swiggyclonenew

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.ps.swiggyclonenew.viewmodels.MainViewModel
import com.ps.swiggyclonenew.viewmodels.MainViewmodelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var mainViewmodelFactory: MainViewmodelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            //You remove the theme, app will not be affected by the dark/light mode
//            SwiggyCloneNewTheme {
                MainScreen()
//            }
        }
    }
}
