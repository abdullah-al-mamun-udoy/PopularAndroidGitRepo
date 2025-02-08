package com.example.popularandroidgitrepo.navigation

import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.network.model.GitAndroidRepositoryResponse
import com.example.popularandroidgitrepo.presentation.screen.details.DetailsScreen
import com.example.popularandroidgitrepo.presentation.screen.home.HomeScreen
import com.google.gson.Gson


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
//        composable(Screen.DetailsScreen.route) {
//            DetailsScreen(navController)
//        }
//        composable(
//            route = "details_screen/{repoJson}",
//            arguments = listOf(navArgument("repoJson") { type = NavType.StringType })
//        ) { backStackEntry ->
//            val repoJson = backStackEntry.arguments?.getString("repoJson")
//            val repo = remember { Gson().fromJson(repoJson, GitAndroidRepositoryResponse.Item::class.java) }
//            DetailsScreen(navController, repo)
//        }
        //passing as json object arguemnt
        composable(
            route = "details_screen/{repoJson}",
            arguments = listOf(navArgument("repoJson") { type = NavType.StringType })
        ) { backStackEntry ->

            val repoJson = backStackEntry.arguments?.getString("repoJson")?.let { Uri.decode(it) } // Decode URI
            val repo = Gson().fromJson(repoJson, GitAndroidRepositoryResponse.Item::class.java)

            DetailsScreen(navController, repo)
        }


    }
}