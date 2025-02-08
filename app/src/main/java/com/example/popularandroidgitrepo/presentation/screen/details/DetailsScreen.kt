package com.example.popularandroidgitrepo.presentation.screen.details

import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.network.model.GitAndroidRepositoryResponse
import com.example.popularandroidgitrepo.R
import com.example.popularandroidgitrepo.presentation.global_component.ChipGroup
import com.example.popularandroidgitrepo.presentation.global_component.CustomImage
import com.example.popularandroidgitrepo.presentation.global_component.CustomImageAsync
import com.example.popularandroidgitrepo.presentation.global_component.CustomText

@Preview(showBackground = true)
@Composable
fun DetailsScreen(
    navController: NavHostController,
    repo: GitAndroidRepositoryResponse.Item? = null
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color.White)
            .padding(0.dp)
    ) {
        UiBox(repo = repo)
        Spacer(modifier = Modifier.padding(top = 8.dp))
        CustomText(
            text = "Topics List",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
        )
        repo?.topics?.let { ChipGroup(it) }
        Spacer(modifier = Modifier.padding(top = 8.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.Top
        ) {
            CustomText(
                text = "Description:",
                modifier = Modifier.weight(0.3f),
                fontWeight = FontWeight.Bold
            )
            CustomText(
                text = repo?.description ?: "No description available",
                modifier = Modifier.weight(0.7f)
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.Top
        ) {
            CustomText(
                text = "Language:",
                modifier = Modifier.weight(0.3f),
                fontWeight = FontWeight.Bold
            )
            CustomText(
                text = repo?.language ?: "Unknown",
                modifier = Modifier.weight(0.7f)
            )
        }

    }
}


@Preview(showBackground = true)
@Composable
fun UiBox(repo: GitAndroidRepositoryResponse.Item? = null) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.Magenta, Color.Cyan)
                )
            )
    ) {
        // Bottom Start Image and Text
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 60.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {

            repo?.owner?.avatarUrl?.let {
                CustomImageAsync(
                    imageUrl = it,
                    modifier = Modifier.clip(shape = CircleShape),
                    size = 512
                )
            }
            CustomText("Profile Avatar", textAlign = TextAlign.Center, color = Color.White, fontWeight = FontWeight.Bold)

        }
        CustomText(
            text = "Name: ${repo?.name ?: "Unknown"}",
            modifier = Modifier
                .align(Alignment.BottomStart)
                .basicMarquee(velocity = 30.dp)
                .padding(start = 16.dp, bottom = 40.dp),

        )
        Row(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 16.dp, bottom = 16.dp),
        ) {
            CustomImage(imageId = R.drawable.ic_logo, Modifier.size(20.dp))

            CustomText(text = repo?.stargazersCount.toString(), textAlign = TextAlign.Center)
            // Bottom End Image and Text
            Row(
                modifier = Modifier.padding(start = 8.dp),
            ) {
                CustomImage(imageId = R.drawable.ic_watch, Modifier.size(20.dp))
                Spacer(modifier = Modifier.width(4.dp))
                CustomText(text = repo?.watchersCount.toString(), textAlign = TextAlign.Center)
            }
        }
        Row(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(end = 16.dp, top = 16.dp),
        ) {
            CustomImage(imageId = R.drawable.ic_star, Modifier.size(20.dp))
            CustomText(text = repo?.stargazersCount.toString(), textAlign = TextAlign.Center)
        }
    }
}
