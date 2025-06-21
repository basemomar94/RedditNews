package com.bassem.presentation.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.bassem.presentation.models.RedditPost


@Composable
fun PostsScreen(onPostClick: (RedditPost) -> Unit) {
    Text(text = "Hello Screen")

}