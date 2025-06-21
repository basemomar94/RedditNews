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
        val numOfComments: Int?,
        val permalink: String?,
        val isVideo: Boolean?,
        val thumbnail: String?,
        val upvoteRatio: Double?,
        val domain: String?,
    ) : Screen()
}