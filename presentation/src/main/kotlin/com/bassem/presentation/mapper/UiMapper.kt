package com.bassem.presentation.mapper

import com.bassem.redditnews.domain.models.RedditPost as DomainPost
import com.bassem.presentation.models.RedditPost as UiPost

fun DomainPost.toUi() = UiPost(
    title = title,
    selfText = selfText,
    score = score,
    author = author,
    subreddit = subreddit,
    ups = ups,
    downs = downs,
    createdAt = createdAt,
    permalink = permalink,
    url = url,
    thumbnail = thumbnail,
    upvoteRatio = upvoteRatio
)