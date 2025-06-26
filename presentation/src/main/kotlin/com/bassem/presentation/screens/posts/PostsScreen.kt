package com.bassem.presentation.screens.posts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.bassem.presentation.PostsIntent
import com.bassem.presentation.PostsState
import com.bassem.presentation.PostsViewModel
import com.bassem.presentation.mapper.getMessage
import com.bassem.presentation.models.RedditPost
import com.bassem.presentation.screens.posts.compose.RedditPostList
import com.bassem.redditnews.common.CustomTopBar
import com.bassem.redditnews.common.ErrorCompose
import com.bassem.redditnews.common.Loading


@Composable
fun PostsScreen(viewModel: PostsViewModel = hiltViewModel(), onPostClick: (RedditPost) -> Unit) {
    val state = viewModel.postsState.collectAsState().value
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        viewModel.setIntent(PostsIntent.FetchPosts)
    }
    Scaffold(
        topBar = {
            CustomTopBar(title = "Reddit News")
        },
    ) { padding ->
        Box(modifier = Modifier.fillMaxSize().padding(padding)) {
            when (state) {
                is PostsState.Loading -> Loading(modifier = Modifier.align(Alignment.Center))
                is PostsState.Success -> {
                    RedditPostList(posts = state.posts, onPostClick = onPostClick)
                }

                is PostsState.Error -> ErrorCompose(
                    modifier = Modifier.align(Alignment.Center),
                    message = state.message.getMessage(context)
                ) {
                    viewModel.setIntent(PostsIntent.FetchPosts)
                }
            }
        }

    }


}