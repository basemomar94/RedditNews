package com.bassem.presentation.screens.post_details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bassem.presentation.models.RedditPost
import com.bassem.presentation.screens.common.ImageCompose
import com.bassem.presentation.screens.common.CustomTopBar

@Composable
fun PostDetailsScreen(post: RedditPost, onBackClick: () -> Unit) {
    val scrollState = rememberScrollState()
    Scaffold(
        topBar = {
            CustomTopBar(title = post.title, onBackClick = onBackClick)
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).verticalScroll(scrollState)) {
            if (post.thumbnail?.isNotEmpty() == true) {
                ImageCompose(
                    imageUrl = post.thumbnail,
                    modifier = Modifier.fillMaxWidth().height(120.dp)
                )
            }
            Text(
                text = post.selfText ?: "No content available.",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            )
        }
    }
}