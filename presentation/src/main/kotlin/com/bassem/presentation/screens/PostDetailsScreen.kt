package com.bassem.presentation.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.bassem.presentation.models.RedditPost


@Composable
fun PostDetailsScreen(post: RedditPost?) {
    Text(text = post?.title ?: "")

}