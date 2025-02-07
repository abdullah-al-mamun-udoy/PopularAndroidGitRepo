package com.example.popularandroidgitrepo.presentation.screen.home

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.data.Resource
import com.example.network.model.GitAndroidRepositoryResponse
import com.example.popularandroidgitrepo.R
import com.example.popularandroidgitrepo.presentation.global_component.CustomImageAsync
import com.example.popularandroidgitrepo.presentation.global_component.CustomText
import com.google.gson.Gson


@Preview(showBackground = true)
@Composable
fun HomeScreen(
    navController: NavHostController? = null,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {

    val gitRepoState by viewModel.fetchRepo.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    // Show loading indicator if it's loading, otherwise show repo data
    if (isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                color = colorResource(R.color.purple_500),
                strokeWidth = 2.dp
            )
        }
    } else {
        when (gitRepoState) {
            is Resource.Success -> {
//                val repoList = (gitRepoState as Resource.Success<GitAndroidRepositoryResponse>).data.items.orEmpty().filterNotNull()
                val repoList = (gitRepoState as? Resource.Success<List<GitAndroidRepositoryResponse.Item>>)?.data.orEmpty()

                if (repoList.isEmpty()) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CustomText("No repositories found")
                    }
                } else {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize().background(color = Color.White), contentPadding = PaddingValues(vertical = 16.dp)
                    ) {
                        items(
                            count = repoList.size,
                            key = { index -> repoList[index].id ?: 0 } // Handle potential null IDs
                        ) { index ->

                            val repoJson = Uri.encode(Gson().toJson(repoList[index])) // Convert to JSON and encode
                            RepoCard(repo = repoList[index], onClick = {
                                navController?.navigate("details_screen/$repoJson")
                            })
                        }
                    }
                }
            }

            is Resource.Error -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CustomText(
                        text = "Error: ${(gitRepoState as Resource.Error).errorMessage}",
                    )
                }
            }

            else -> {
                // You can handle the Loading state inside the ViewModel,
                // but here we handle it to avoid empty UI when the state is in a wrong phase.
                CustomText(text = "Something went wrong!")
            }
        }
    }
}

@Composable
fun RepoCard(repo: GitAndroidRepositoryResponse.Item, onClick: () -> Unit = {}) {
    Card(
        elevation = CardDefaults.elevatedCardElevation(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .clickable { onClick.invoke() },
        colors = CardDefaults.cardColors(colorResource(R.color.white)),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(modifier = Modifier.weight(1f)) {
            Column(
                modifier = Modifier
                    .weight(.3f)
                    .fillMaxHeight()
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                repo.owner?.avatarUrl?.let {
                    CustomImageAsync(
                        imageUrl = it, // You can replace it with repo.imageUrl if available
                        modifier = Modifier.clip(shape = CircleShape),
                        size = 512
                    )
                }
            }
            Column(
                modifier = Modifier
                    .weight(.7f)
                    .fillMaxHeight()
                    .padding(start = 8.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Row {
                    CustomText(
                        text = "Name: ",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    CustomText(
                        text = "${repo.name ?: "Unknown"}",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.basicMarquee(velocity = 30.dp)
                    )

                }
                CustomText(text = "Default Branch: ${repo.defaultBranch ?: "N/A"}")
                CustomText(text = "Watchers: ${repo.watchers ?: 0}")
                CustomText(text = "Visibility: ${repo.visibility ?: "N/A"}")
                CustomText(text = "Created At: ${repo.createdAt ?: "N/A"}")
            }
        }
    }
}