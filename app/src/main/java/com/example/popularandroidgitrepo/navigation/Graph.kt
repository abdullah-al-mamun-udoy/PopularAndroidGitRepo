package com.example.popularandroidgitrepo.navigation

//This sealed class is used to define the navigation graphs in the app
sealed class Graph (val route: String ){
    data object RootGraph: Graph("root_graph")
    data object HomeGraph: Graph("home_graph")
}
