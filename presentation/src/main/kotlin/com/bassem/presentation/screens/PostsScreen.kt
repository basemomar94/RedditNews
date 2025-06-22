package com.bassem.presentation.screens

import android.widget.Toast
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.bassem.presentation.PostsState
import com.bassem.presentation.PostsViewModel
import com.bassem.presentation.models.RedditPost


@Composable
fun PostsScreen(viewModel: PostsViewModel = hiltViewModel(), onPostClick: (RedditPost) -> Unit) {
    val state = viewModel.postsState.collectAsState().value
    when (state) {
        is PostsState.Loading -> {}
        is PostsState.Success -> {
            Toast.makeText(LocalContext.current, "Success ${state.posts.size}", Toast.LENGTH_SHORT)
                .show()
        }

        is PostsState.Error -> {}
    }
    Text(text = "Hello Screen")

}