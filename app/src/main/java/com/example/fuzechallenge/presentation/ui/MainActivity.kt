package com.example.fuzechallenge.presentation.ui

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.fuzechallenge.presentation.navigation.NavGraph
import com.example.fuzechallenge.presentation.theme.FuzeChallengeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FuzeChallengeTheme {
                AppScreen()
            }
        }
    }
}


@Composable
fun AppScreen() {
    val navHostController: NavHostController = rememberNavController()
    NavGraph(navHostController = navHostController)
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AppPreview() {
    FuzeChallengeTheme {
        AppScreen()
    }
}