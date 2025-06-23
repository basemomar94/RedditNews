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
    numOfComments = numOfComments,
    permalink = permalink,
    isVideo = isVideo,
    upvoteRatio = upvoteRatio,
    domain = domain
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
    numOfComments = numOfComments,
    permalink = permalink,
    isVideo = isVideo,
    thumbnail = thumbnail,
    upvoteRatio = upvoteRatio,
    domain = domain
)