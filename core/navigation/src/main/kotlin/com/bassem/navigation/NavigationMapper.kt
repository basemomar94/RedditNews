package com.bassem.navigation

import com.bassem.presentation.models.RedditPost

fun Screen.PostDetails.toUiModel(): RedditPost = RedditPost(
    selfText = selfText,
    title = title,
    thumbnail = thumbnail,

)

fun RedditPost.toNavigationModel(): Screen.PostDetails = Screen.PostDetails(
    title = title,
    selfText = selfText,
    thumbnail = thumbnail,

    )