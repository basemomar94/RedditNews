package com.bassem.presentation.mapper

import com.bassem.redditnews.domain.models.RedditPost as DomainPost
import com.bassem.presentation.models.RedditPost as UiPost

fun DomainPost.toUi() = UiPost(
    title = title,
    selfText = selfText,
    thumbnail = thumbnail,
)