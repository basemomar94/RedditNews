package com.bassem.presentation.screens.post_details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bassem.presentation.models.RedditPost
import com.bassem.presentation.screens.post_details.compose.PostDetailsTopBar

@Composable
fun PostDetailsScreen(post: RedditPost, onBackClick: () -> Unit) {
    Scaffold(
        topBar = {
            PostDetailsTopBar(title = post.title, onBackClick = onBackClick)
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            Text(
                text = post.selfText ?: "No content available.",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            )
        }
    }
}