package com.bassem.redditnews.domain.repo

import com.bassem.redditnews.domain.models.RedditPost
import kotlinx.coroutines.flow.Flow

interface GetPostsRepo  {
    fun getPosts(): Flow<Result<List<RedditPost>>>
}