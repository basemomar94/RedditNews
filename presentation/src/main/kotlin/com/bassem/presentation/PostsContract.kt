package com.bassem.presentation

import com.bassem.presentation.models.RedditPost

sealed class PostsState {

    data object Loading : PostsState()
    data class Success(val posts: List<RedditPost>) : PostsState()
    data class Error(val message: String) : PostsState()
}

sealed class PostsIntent {
    data object FetchPosts : PostsIntent()
    data object NavigateToPostDetails : PostsIntent()
}