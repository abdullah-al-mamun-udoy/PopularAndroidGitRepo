package com.example.popularandroidgitrepo.presentation.screen.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.popularandroidgitrepo.presentation.global_component.CustomText

@Composable
fun HomeScreen(navController: NavHostController) {


    CustomText(
        text = "welcome to home screen"
    )
}