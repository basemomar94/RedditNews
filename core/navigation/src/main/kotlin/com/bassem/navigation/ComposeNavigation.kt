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
        modifier =modifier ,
        backStack = remember { mutableStateListOf<Screen>(Screen.Posts) },
        entryProvider = { key ->
            when (key) {
                is Screen.PostDetails -> NavEntry(key) {
                    //    val postDetails: Screen.PostDetails = key as Screen.PostDetails
                    PostDetailsScreen(null
                        /*      RedditPost(
                                  title = postDetails.title,
                                  selfText = postDetails.selfText,
                                  url = postDetails.url,
                                  author = postDetails.author,
                                  subreddit = postDetails.subreddit,
                                  ups = postDetails.ups,
                                  downs = postDetails.downs,
                                  score = postDetails.score,
                                  createdAt = postDetails.createdAt,
                                  numOfComments = postDetails.numOfComments,
                                  permalink = postDetails.permalink,
                                  isVideo = postDetails.isVideo,
                                  thumbnail = postDetails.thumbnail,
                                  upvoteRatio = postDetails.upvoteRatio,
                                  domain = postDetails.domain
                              )*/
                    )
                }

                Screen.Posts -> NavEntry(key) {
                    PostsScreen {
                        backStack.add(
                            Screen.PostDetails(
                                title = it.title,
                                selfText = it.selfText,
                                url = it.url,
                                author = it.author,
                                subreddit = it.subreddit,
                                ups = it.ups,
                                downs = it.downs,
                                score = it.score,
                                createdAt = it.createdAt,
                                numOfComments = it.numOfComments,
                                permalink = it.permalink,
                                isVideo = it.isVideo,
                                thumbnail = it.thumbnail,
                                upvoteRatio = it.upvoteRatio,
                                domain = it.domain
                            )
                        )
                    }

                }
            }
        }
    )
}