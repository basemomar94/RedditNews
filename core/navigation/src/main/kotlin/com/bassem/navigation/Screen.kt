package com.bassem.navigation

sealed class Screen() {
    data object Posts : Screen()
    data class PostDetails(
        val title: String?,
        val selfText: String?,
        val thumbnail: String?,
    ) : Screen()
}