package com.example.popularandroidgitrepo.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.popularandroidgitrepo.presentation.screen.details.DetailsScreen
import com.example.popularandroidgitrepo.presentation.screen.home.HomeScreen


@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun HomeNavGraph(
    navController: NavHostController
) {
    //This is the navigation graph for the MainScreen
    NavHost(
        navController = navController,
        route = Graph.HomeGraph.route,
        startDestination = Screen.HomeScreen.route,
    ) {
        composable(Screen.HomeScreen.route) {
            HomeScreen(navController)
        }
        composable(Screen.DetailsScreen.route) {
            DetailsScreen(navController)
        }
    }
}