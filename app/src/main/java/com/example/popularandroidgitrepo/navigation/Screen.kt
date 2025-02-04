package com.example.popularandroidgitrepo.navigation

//This sealed class is used to define the screens in the app
sealed class Screen(val route: String) {
    //This companion object is used to define the movieId that will be passed to the details screen

    data object HomeScreen: Screen("home_screen")
    data object SplashScreen: Screen("splash_screen")
    data object DetailsScreen: Screen("details_screen")


}
