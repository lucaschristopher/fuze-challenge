package com.example.fuzechallenge.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.fuzechallenge.presentation.navigation.NavGraph
import com.example.fuzechallenge.presentation.theme.FuzeChallengeTheme

class MainActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FuzeChallengeTheme {
                navHostController = rememberNavController()
                NavGraph(navController = navHostController)
            }
        }
    }
}
