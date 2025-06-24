package com.bassem.presentation.screens.posts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.bassem.presentation.PostsState
import com.bassem.presentation.PostsViewModel
import com.bassem.presentation.models.RedditPost
import com.bassem.presentation.screens.common.CustomTopBar
import com.bassem.presentation.screens.common.Loading
import com.bassem.presentation.screens.posts.compose.RedditPostList


@Composable
fun PostsScreen(viewModel: PostsViewModel = hiltViewModel(), onPostClick: (RedditPost) -> Unit) {
    val state = viewModel.postsState.collectAsState().value
    Scaffold(
        topBar = {
            CustomTopBar(title = "Reddit News")
        },
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            when (state) {
                is PostsState.Loading -> Loading()
                is PostsState.Success -> {
                    RedditPostList(posts = state.posts, onPostClick = onPostClick)
                }

                is PostsState.Error -> {}
            }
        }

    }


}