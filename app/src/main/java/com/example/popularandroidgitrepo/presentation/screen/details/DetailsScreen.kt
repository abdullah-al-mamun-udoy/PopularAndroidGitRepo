package com.example.popularandroidgitrepo.presentation.screen.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.network.model.GitAndroidRepositoryResponse
import com.example.popularandroidgitrepo.presentation.global_component.CustomText
import com.google.gson.Gson

@Composable
fun DetailsScreen(navController: NavHostController, repo: GitAndroidRepositoryResponse.Item) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Repository Name: ${repo.name ?: "Unknown"}")

    }
}
