package com.bassem.presentation.screens.posts.compose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.bassem.presentation.models.RedditPost

@Composable
internal fun RedditPostList(posts: List<RedditPost>, onPostClick: (RedditPost) -> Unit) {
    LazyColumn {
        items(items = posts) { post ->
            RedditPostItem(post, onPostClick)
        }
    }
}