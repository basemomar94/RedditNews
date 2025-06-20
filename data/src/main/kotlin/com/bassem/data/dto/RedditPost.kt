package com.bassem.data.dto

data class RedditPost(
    val id: String?,
    val title: String?,
    val selftext: String?,
    val url: String?,
    val author: String?,
    val subreddit: String?,
    val ups: Int?,
    val downs: Int?,
    val score: Int?,
    val created_utc: Long?,
    val num_comments: Int?,
    val permalink: String?,
    val is_video: Boolean?,
    val thumbnail: String?,
    val upvote_ratio: Double?,
    val domain: String?
)
