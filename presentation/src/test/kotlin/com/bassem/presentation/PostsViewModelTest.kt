package com.bassem.presentation

import com.bassem.presentation.mapper.toUi
import com.bassem.redditnews.domain.models.RedditPost
import com.bassem.redditnews.domain.usecase.FetchPostsUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class PostsViewModelTest {


    private val fetchPostsUseCase: FetchPostsUseCase = mockk()
    private lateinit var viewModel: PostsViewModel

    private val fakeDomainPosts = listOf(
        RedditPost(
            title = "Test Post",
            selfText = "This is a test post",
            url = "https://example.com",
            author = "Test Author",
            subreddit = "Test Subreddit",
            ups = 100,
            downs = 20,
            score = 80,
            createdAt = 1624556800,
            numOfComments = 50,
            permalink = "/r/test/test-post",
            isVideo = false,
            thumbnail = "https://example.com/thumbnail.jpg",
            upvoteRatio = 0.75,
            domain = "example.com",
            id = "4",
        )
    )
    private val fakeUiPosts = fakeDomainPosts.map { it.toUi() }

    @BeforeEach
    fun setUp() {
        Dispatchers.setMain(StandardTestDispatcher())
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `fetch posts - success`() = runTest {
        coEvery { fetchPostsUseCase() } returns flowOf(Result.success(fakeDomainPosts))
        viewModel = PostsViewModel(fetchPostsUseCase)
        viewModel.setIntent(PostsIntent.FetchPosts)

        advanceUntilIdle()
        val state = viewModel.postsState.first()
        Assertions.assertTrue(state is PostsState.Success)
        assertEquals(fakeUiPosts, (state as PostsState.Success).posts)
    }

    @Test
    fun `fetch posts - failure`() = runTest {
        val error = RuntimeException("Something went wrong")
        coEvery { fetchPostsUseCase() } returns flowOf(Result.failure(error))
        viewModel = PostsViewModel(fetchPostsUseCase)
        viewModel.setIntent(PostsIntent.FetchPosts)

        advanceUntilIdle()
        val state = viewModel.postsState.first()
        Assertions.assertTrue(state is PostsState.Error)


    }
}