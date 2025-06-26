package com.bassem.data.repoImp


import com.bassem.data.dto.RedditListingData
import com.bassem.data.dto.RedditListingResponse
import com.bassem.data.dto.RedditPost
import com.bassem.data.dto.RedditPostContainer
import com.bassem.data.local.RedditPostDao
import com.bassem.data.remote.ApiService
import com.bassem.data.repoimp.GetPostsImp
import io.mockk.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@ExperimentalCoroutinesApi
class GetPostsImpTest {

    private val apiService: ApiService = mockk()
    private val redditPostDao: RedditPostDao = mockk(relaxed = true)
    private lateinit var repo: GetPostsImp

    private val testDispatcher = StandardTestDispatcher()

    @BeforeEach
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        repo = GetPostsImp(apiService, redditPostDao)
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `getPosts emits success when API returns data`() = runTest {
        // Arrange
        val postDto = RedditPost(
            id = "1",
            title = "Test",
            author = "author",
            url = "url",
            thumbnail = "thumbnail",
            domain = "domain",
            ups = 10,
            downs = 5,
            dbId = 2,
            selftext = "",
            subreddit = "",
            score = 2,
            created_utc = 300L,
            num_comments = 44,
            permalink = "",
            is_video = false,
            upvote_ratio = 4.5,
        )
        val listingResponse = RedditListingResponse(
            data = RedditListingData(
                children = listOf(RedditPostContainer(data = postDto, kind = "")),
                after = "",
                dist = 4,
                modhash = ""
            ),
            kind = ""
        )
        coEvery { apiService.getPosts() } returns listingResponse
        coEvery { redditPostDao.deleteAllPosts() } just Runs
        coEvery { redditPostDao.insertAll(any()) } just Runs

        // Act
        val result = repo.getPosts().toList().first()

        // Assert
        assertTrue(result.isSuccess)
        assertEquals(1, result.getOrNull()?.size)
        assertEquals("Test", result.getOrNull()?.first()?.title)

        coVerifySequence {
            apiService.getPosts()
            redditPostDao.deleteAllPosts()
            redditPostDao.insertAll(any())
        }
    }

    @Test
    fun `getPosts emits cached data when API fails`() = runTest {
        // Arrange
        val exception = RuntimeException("Network error")
        coEvery { apiService.getPosts() } throws exception

        val cachedPostDto = RedditPost(
            id = "cached_id",
            title = "Cached Post",
            author = "cached_author",
            url = "url",
            thumbnail = "thumb",
            domain = "domain",
            ups = 1,
            downs = 0,
            dbId = 1,
            selftext = "",
            subreddit = "",
            score = 1,
            created_utc = 123L,
            num_comments = 10,
            permalink = "",
            is_video = false,
            upvote_ratio = 1.0,
        )
        coEvery { redditPostDao.getAllPosts() } returns listOf(cachedPostDto)

        // Act
        val result = repo.getPosts().toList().first()

        // Assert
        assertTrue(result.isSuccess)
        assertEquals(1, result.getOrNull()?.size)
        assertEquals("Cached Post", result.getOrNull()?.first()?.title)

        coVerify { apiService.getPosts() }
        coVerify { redditPostDao.getAllPosts() }
    }

    @Test
    fun `getPosts emits failure when both API and cache fail`() = runTest {
        // Arrange
        val exception = RuntimeException("Network unreachable")
        coEvery { apiService.getPosts() } throws exception
        coEvery { redditPostDao.getAllPosts() } returns emptyList()

        // Act
        val result = repo.getPosts().toList().first()

        // Assert
        assertTrue(result.isFailure)
        assertEquals("Network unreachable", result.exceptionOrNull()?.message)

        coVerify { apiService.getPosts() }
        coVerify { redditPostDao.getAllPosts() }
    }

    @Test
    fun `getPosts emits success with empty list when API returns empty children`() = runTest {
        // Arrange
        val listingResponse = RedditListingResponse(
            data = RedditListingData(children = emptyList(), after = "", dist = 0, modhash = ""),
            kind = ""
        )
        coEvery { apiService.getPosts() } returns listingResponse
        coEvery { redditPostDao.deleteAllPosts() } just Runs
        coEvery { redditPostDao.insertAll(any()) } just Runs

        // Act
        val result = repo.getPosts().toList().first()

        // Assert
        assertTrue(result.isSuccess)
        assertEquals(0, result.getOrNull()?.size)

        coVerify { apiService.getPosts() }
    }

    @Test
    fun `getPosts emits success with empty list when API returns null children`() = runTest {
        // Arrange
        val listingResponse = RedditListingResponse(
            data = RedditListingData(children = null, after = "", dist = 0, modhash = ""),
            kind = ""
        )
        coEvery { apiService.getPosts() } returns listingResponse
        coEvery { redditPostDao.deleteAllPosts() } just Runs
        coEvery { redditPostDao.insertAll(any()) } just Runs

        // Act
        val result = repo.getPosts().toList().first()

        // Assert
        assertTrue(result.isSuccess)
        assertEquals(0, result.getOrNull()?.size)

        coVerify { apiService.getPosts() }
    }
}
