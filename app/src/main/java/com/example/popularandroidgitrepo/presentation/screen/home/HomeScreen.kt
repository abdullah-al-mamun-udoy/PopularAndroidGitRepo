package com.example.popularandroidgitrepo.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.data.Resource
import com.example.network.model.GitAndroidRepositoryResponse
import com.example.popularandroidgitrepo.R
import com.example.popularandroidgitrepo.presentation.global_component.CustomImageAsync
import com.example.popularandroidgitrepo.presentation.global_component.CustomText
//
//@Composable
//fun HomeScreen(navController: NavHostController, viewModel: HomeScreenViewModel = hiltViewModel(),) {
//
//
//
//
//    val gitRepoState by viewModel.fetchRepo.collectAsState()
//
//
//    val repoList = (gitRepoState as? Resource.Success)?.data?.items.orEmpty().filterNotNull()
//
//
//    if (repoList.isEmpty()) {
//        Box(
//            modifier = Modifier.fillMaxSize(),
//            contentAlignment = Alignment.Center
//        ) {
//            CircularProgressIndicator(
//                color = colorResource(R.color.purple_500),
//                strokeWidth = 2.dp
//            )
//        }
//    } else {
//        LazyColumn(
//            modifier = Modifier.fillMaxSize()
//        ) {
//            items(
//                count = repoList.size,
//                key = { index -> repoList[index].id ?: 0 } // Handle potential null IDs
//            ) { index ->
//                CustomText(text = "Repo Name: ${repoList[index].name ?: "Unknown"}")
//                CustomText(text = "Default Branch: ${repoList[index].defaultBranch ?: "N/A"}")
//                CustomText(text = "Watchers: ${repoList[index].watchers ?: 0}")
//                CustomText(text = "Visibility: ${repoList[index].visibility ?: "N/A"}")
//                CustomText(text = "Created At: ${repoList[index].createdAt ?: "N/A"}")
//                CustomText(
//                    text = "Topics: ${repoList[index].topics?.joinToString(", ") ?: "No topics"}",
//                    maxLines = 2,
//                    overFlow = TextOverflow.Ellipsis
//                )
//            }
//        }
//
//    }
//
//
//
//
//
//}
//
//
//@Preview(showBackground = true)
//@Composable
//fun Card() {
//    Card(
//        elevation = CardDefaults.elevatedCardElevation(8.dp),
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(120.dp)
//            .padding(horizontal = 16.dp, vertical = 4.dp)
//            .clickable {
//
//            },
//        colors = CardDefaults.cardColors(colorResource(R.color.white)),
//        shape = RoundedCornerShape(8.dp)
//    ) {
//        Row(modifier = Modifier.weight(1f)) {
//            Column(
//                modifier = Modifier
//                    .weight(.3f)
//                    .fillMaxHeight()
//                    .background(color = colorResource(R.color.teal_200)),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center
//            ) {
//                CustomImageAsync(
//                    imageUrl = "",
//                    modifier = Modifier.clip(shape = CircleShape),
//                    size = 52
//
//                )
//
//            }
//            Column(
//                modifier = Modifier
//                    .weight(.7f)
//                    .fillMaxHeight()
//                    .background(color = colorResource(R.color.purple_500))
//                    .padding(start = 8.dp),
//
//                horizontalAlignment = Alignment.Start,
//                verticalArrangement = Arrangement.Center
//            ) {
//                CustomText(text = "Name: ", fontSize = 16.sp, fontWeight = FontWeight.Bold)
//                CustomText(text = "Default Branch: ")
//                CustomText(text = "Watchers: ")
//                CustomText(text = "Visibility: ")
//                CustomText(text = "Created At: ")
//
//            }
//        }
//
//    }
//
//}
//
//
////default_branch,watchers,visibility,topics,created_at,name

//
//@Composable
//fun HomeScreen(navController: NavHostController, viewModel: HomeScreenViewModel = hiltViewModel()) {
//
//    val gitRepoState by viewModel.fetchRepo.collectAsState()
//    val repoList = (gitRepoState as? Resource.Success)?.data?.items.orEmpty().filterNotNull()
//
//    if (repoList.isEmpty()) {
//        Box(
//            modifier = Modifier.fillMaxSize(),
//            contentAlignment = Alignment.Center
//        ) {
//            CircularProgressIndicator(
//                color = colorResource(R.color.purple_500),
//                strokeWidth = 2.dp
//            )
//        }
//    } else {
//        LazyColumn(
//            modifier = Modifier.fillMaxSize()
//        ) {
//            items(
//                count = repoList.size,
//                key = { index -> repoList[index].id ?: 0 } // Handle potential null IDs
//            ) { index ->
//                RepoCard(repo = repoList[index])
//            }
//        }
//    }
//}
//
//@Composable
//fun RepoCard(repo: GitAndroidRepositoryResponse.Item) {
//    Card(
//        elevation = CardDefaults.elevatedCardElevation(8.dp),
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(120.dp)
//            .padding(horizontal = 16.dp, vertical = 4.dp)
//            .clickable {},
//        colors = CardDefaults.cardColors(colorResource(R.color.white)),
//        shape = RoundedCornerShape(8.dp)
//    ) {
//        Row(modifier = Modifier.weight(1f)) {
//            Column(
//                modifier = Modifier
//                    .weight(.3f)
//                    .fillMaxHeight()
//                    .background(color = colorResource(R.color.teal_200)),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center
//            ) {
//                CustomImageAsync(
//                    imageUrl = "", // You can replace it with repo.imageUrl if available
//                    modifier = Modifier.clip(shape = CircleShape),
//                    size = 52
//                )
//            }
//            Column(
//                modifier = Modifier
//                    .weight(.7f)
//                    .fillMaxHeight()
//                    .background(color = colorResource(R.color.purple_500))
//                    .padding(start = 8.dp),
//                horizontalAlignment = Alignment.Start,
//                verticalArrangement = Arrangement.Center
//            ) {
//                CustomText(text = "Name: ${repo.name ?: "Unknown"}", fontSize = 16.sp, fontWeight = FontWeight.Bold)
//                CustomText(text = "Default Branch: ${repo.defaultBranch ?: "N/A"}")
//                CustomText(text = "Watchers: ${repo.watchers ?: 0}")
//                CustomText(text = "Visibility: ${repo.visibility ?: "N/A"}")
//                CustomText(text = "Created At: ${repo.createdAt ?: "N/A"}")
//            }
//        }
//    }
//}


//@Composable
//fun HomeScreen(navController: NavHostController, viewModel: HomeScreenViewModel = hiltViewModel()) {
//
//    val gitRepoState by viewModel.fetchRepo.collectAsState()
//
//    // Use 'when' to handle different states (Success, Error, Loading)
//    when (gitRepoState) {
//        is Resource.Success -> {
//            val repoList = (gitRepoState as Resource.Success<GitAndroidRepositoryResponse>).data?.items.orEmpty().filterNotNull()
//
//            // If repoList is empty, show a loading indicator
//            if (repoList.isEmpty()) {
//                Box(
//                    modifier = Modifier.fillMaxSize(),
//                    contentAlignment = Alignment.Center
//                ) {
//                    CircularProgressIndicator(
//                        color = colorResource(R.color.purple_500),
//                        strokeWidth = 2.dp
//                    )
//                }
//            } else {
//                LazyColumn(
//                    modifier = Modifier.fillMaxSize()
//                ) {
//                    items(
//                        count = repoList.size,
//                        key = { index -> repoList[index].id ?: 0 } // Handle potential null IDs
//                    ) { index ->
//                        RepoCard(repo = repoList[index])
//                    }
//                }
//            }
//        }
//        is Resource.Error -> {
//            // Display error message if state is error
//            Box(
//                modifier = Modifier.fillMaxSize(),
//                contentAlignment = Alignment.Center
//            ) {
//                CustomText(
//                    text = "Error: ${(gitRepoState as Resource.Error).errorMessage}",
//                )
//            }
//        }
//        is Resource.Loading -> {
//            // Show loading indicator if state is loading
//            Box(
//                modifier = Modifier.fillMaxSize(),
//                contentAlignment = Alignment.Center
//            ) {
//                CircularProgressIndicator(
//                    color = colorResource(R.color.purple_500),
//                    strokeWidth = 2.dp
//                )
//            }
//        }
//    }
//}
//
//@Composable
//fun RepoCard(repo: GitAndroidRepositoryResponse.Item) {
//    Card(
//        elevation = CardDefaults.elevatedCardElevation(8.dp),
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(120.dp)
//            .padding(horizontal = 16.dp, vertical = 4.dp)
//            .clickable { /* Handle card click */ },
//        colors = CardDefaults.cardColors(colorResource(R.color.white)),
//        shape = RoundedCornerShape(8.dp)
//    ) {
//        Row(modifier = Modifier.weight(1f)) {
//            Column(
//                modifier = Modifier
//                    .weight(.3f)
//                    .fillMaxHeight()
//                    .background(color = colorResource(R.color.teal_200)),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center
//            ) {
//                CustomImageAsync(
//                    imageUrl = "", // You can replace it with repo.imageUrl if available
//                    modifier = Modifier.clip(shape = CircleShape),
//                    size = 52
//                )
//            }
//            Column(
//                modifier = Modifier
//                    .weight(.7f)
//                    .fillMaxHeight()
//                    .background(color = colorResource(R.color.purple_500))
//                    .padding(start = 8.dp),
//                horizontalAlignment = Alignment.Start,
//                verticalArrangement = Arrangement.Center
//            ) {
//                CustomText(text = "Name: ${repo.name ?: "Unknown"}", fontSize = 16.sp, fontWeight = FontWeight.Bold)
//                CustomText(text = "Default Branch: ${repo.defaultBranch ?: "N/A"}")
//                CustomText(text = "Watchers: ${repo.watchers ?: 0}")
//                CustomText(text = "Visibility: ${repo.visibility ?: "N/A"}")
//                CustomText(text = "Created At: ${repo.createdAt ?: "N/A"}")
//            }
//        }
//    }
//}


@Composable
fun HomeScreen(navController: NavHostController, viewModel: HomeScreenViewModel = hiltViewModel()) {

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
                val repoList = (gitRepoState as Resource.Success<GitAndroidRepositoryResponse>).data.items.orEmpty().filterNotNull()
                if (repoList.isEmpty()) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CustomText("No repositories found")
                    }
                } else {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        items(
                            count = repoList.size,
                            key = { index -> repoList[index].id ?: 0 } // Handle potential null IDs
                        ) { index ->
                            RepoCard(repo = repoList[index])
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
fun RepoCard(repo: GitAndroidRepositoryResponse.Item) {
    Card(
        elevation = CardDefaults.elevatedCardElevation(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .clickable { /* Handle card click */ },
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
                    CustomText(text = "${repo.name ?: "Unknown"}", fontSize = 16.sp, fontWeight = FontWeight.Bold, modifier = Modifier.basicMarquee(velocity = 30.dp))

                }
                CustomText(text = "Default Branch: ${repo.defaultBranch ?: "N/A"}")
                CustomText(text = "Watchers: ${repo.watchers ?: 0}")
                CustomText(text = "Visibility: ${repo.visibility ?: "N/A"}")
                CustomText(text = "Created At: ${repo.createdAt ?: "N/A"}")
            }
        }
    }
}