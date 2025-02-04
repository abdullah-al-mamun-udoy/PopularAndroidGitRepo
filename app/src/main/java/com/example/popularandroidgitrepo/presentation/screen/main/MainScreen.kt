package com.example.popularandroidgitrepo.presentation.screen.main

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.example.popularandroidgitrepo.navigation.HomeNavGraph
import com.example.popularandroidgitrepo.navigation.Screen
import com.example.popularandroidgitrepo.ui.theme.Background_Black
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@RequiresApi(Build.VERSION_CODES.R)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(
    navHostController: NavHostController,
) {
    val context = LocalContext.current
    //Remember the scaffold state
    val scaffoldState = rememberScaffoldState()

    val systemUiController = rememberSystemUiController()
    val currentPageState = remember {
        mutableStateOf(Screen.HomeScreen.toString())
    }

    //Listener to the navHostController to get the current route
    navHostController.addOnDestinationChangedListener { _, destination, _ ->
        currentPageState.value = destination.route.toString()
        Log.d("route_", "onDestinationChanged: route: ${currentPageState.value}")
    }

    //Set the system bars color to black
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Background_Black,
        )
    }

    //Scaffold is a pre-defined layout structure in Jetpack Compose
    Scaffold(
        scaffoldState = scaffoldState,
        backgroundColor = Background_Black
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color.Transparent)
        ) {

            //Called the navigation graph for the MainScreen
            HomeNavGraph(
                navController = navHostController,
            )
        }
    }
}
