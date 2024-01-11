package com.example.fuzechallenge.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.fuzechallenge.presentation.navigation.NavigationGraph
import com.example.fuzechallenge.presentation.ui.theme.FuzeChallengeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FuzeChallengeTheme {
                navHostController = rememberNavController()
                NavigationGraph(navController = navHostController)
            }
        }
    }
}
