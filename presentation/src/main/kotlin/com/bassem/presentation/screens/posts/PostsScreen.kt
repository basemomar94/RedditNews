package com.bassem.presentation.screens.posts

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.bassem.presentation.PostsState
import com.bassem.presentation.PostsViewModel
import com.bassem.presentation.models.RedditPost
import com.bassem.presentation.screens.common.Loading
import com.bassem.presentation.screens.posts.compose.RedditPostList


@Composable
fun PostsScreen(viewModel: PostsViewModel = hiltViewModel(), onPostClick: (RedditPost) -> Unit) {
    val state = viewModel.postsState.collectAsState().value
    when (state) {
        is PostsState.Loading -> Loading()
        is PostsState.Success -> {
            RedditPostList(posts = state.posts, onPostClick = onPostClick)
        }

        is PostsState.Error -> {}
    }

}