package com.example.popularandroidgitrepo.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.popularandroidgitrepo.presentation.screen.main.MainScreen
import com.example.popularandroidgitrepo.presentation.screen.splash.SplashScreen

@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun RootNavGraph(
    navHostController: NavHostController,
) {
    //This is the navigation graph for the SplashScreen and MainScreen
    NavHost(
        navController = navHostController,
        route = Graph.RootGraph.route,
        startDestination = Screen.SplashScreen.route,
    ){
        composable(Screen.SplashScreen.route) {
            SplashScreen(navController = navHostController)
        }
        composable(Graph.HomeGraph.route) {
            MainScreen(navHostController = rememberNavController())
        }
    }
}