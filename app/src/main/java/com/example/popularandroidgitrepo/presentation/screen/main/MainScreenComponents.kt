package com.example.popularandroidgitrepo.presentation.screen.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.popularandroidgitrepo.R
import com.example.popularandroidgitrepo.presentation.global_component.CustomImage
import com.example.popularandroidgitrepo.presentation.global_component.CustomText

// Custom top bar for the app
@Preview(showBackground = false)
@Composable
fun TopBar(
    showTitle: Boolean = true,
    onBackPressed: () -> Unit = {}
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(horizontal = 16.dp)
                    .height(60.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (showTitle) {
                    CustomText(
                        text = "Git Repo",
                        color = Color.Black,
                        fontSize = 18.sp,
                    )
                } else {
                    CustomImage(
                        imageId = R.drawable.ic_back,
                        contentDescription = "Back",
                        modifier = Modifier
                            .size(18.dp)
                            .clickable { onBackPressed.invoke() },
                        contentScale = ContentScale.Crop
                    )
                    CustomText(
                        text = "Details",
                        color = Color.Black,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(4.dp)
                .align(Alignment.BottomCenter)
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            colorResource(R.color.purple_500),
                            colorResource(R.color.teal_200)
                        )
                    )
                )
        )
    }
}