package com.bassem.data.mapper

import com.bassem.data.dto.RedditPost as RedditPostDto
import com.bassem.redditnews.domain.models.RedditPost as RedditPostDomain

fun RedditPostDto.toDomain() = RedditPostDomain(
    title = title,
    author = author,
    numOfComments = num_comments,
    createdAt = created_utc,
    thumbnail = thumbnail,
    url = url,
    id = id,
    score = score,
    isVideo = is_video,
    selfText = selftext,
    subreddit = subreddit,
    ups = ups,
    downs = downs,
    permalink = permalink,
    upvoteRatio = upvote_ratio,
    domain = domain
)
