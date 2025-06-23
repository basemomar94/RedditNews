package com.bassem.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.bassem.presentation.screens.PostDetailsScreen
import com.bassem.presentation.screens.posts.PostsScreen

@Composable
fun NavigationC(modifier: Modifier = Modifier) {
    val backStack = remember { mutableStateListOf<Screen>(Screen.Posts) }
    NavDisplay(
        modifier = modifier,
        backStack = backStack,
        entryProvider = { key ->
            when (key) {
                is Screen.PostDetails -> NavEntry(key) {
                    val postDetails: Screen.PostDetails = key
                    PostDetailsScreen(postDetails.toUiModel())
                }

                Screen.Posts -> NavEntry(key) {
                    PostsScreen { post ->
                        backStack.add(
                            post.toNavigationModel()
                        )
                    }

                }
            }
        }
    )
}