package com.bassem.navigation

import com.bassem.presentation.models.RedditPost

fun Screen.PostDetails.toUiModel(): RedditPost = RedditPost(
    selfText = selfText,
    score = score,
    title = title,
    author = author,
    url = url,
    thumbnail = thumbnail,
    subreddit = subreddit,
    ups = ups,
    downs = downs,
    createdAt = createdAt,
    permalink = permalink,
    upvoteRatio = upvoteRatio,
)

fun RedditPost.toNavigationModel(): Screen.PostDetails = Screen.PostDetails(
    title = title,
    selfText = selfText,
    url = url,
    author = author,
    subreddit = subreddit,
    ups = ups,
    downs = downs,
    score = score,
    createdAt = createdAt,
    permalink = permalink,
    thumbnail = thumbnail,
    upvoteRatio = upvoteRatio,
)