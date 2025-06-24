package com.bassem.navigation

sealed class Screen() {
    data object Posts : Screen()
    data class PostDetails(
        val title: String?,
        val selfText: String?,
        val url: String?,
        val author: String?,
        val subreddit: String?,
        val ups: Int?,
        val downs: Int?,
        val score: Int?,
        val createdAt: Long?,
        val permalink: String?,
        val thumbnail: String?,
        val upvoteRatio: Double?,
    ) : Screen()
}