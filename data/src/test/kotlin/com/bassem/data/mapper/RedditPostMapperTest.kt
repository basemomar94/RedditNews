package com.bassem.data.mapper

import com.bassem.data.dto.RedditPost as RedditPostDto
import kotlin.test.Test
import kotlin.test.assertEquals

class RedditPostMapperTest {

    @Test
    fun `toDomain maps all fields correctly`() {
        // Arrange
        val dto = RedditPostDto(
            id = "123",
            title = "Test Title",
            author = "Test Author",
            url = "https://example.com",
            thumbnail = "https://example.com/thumb.jpg",
            domain = "example.com",
            ups = 100,
            downs = 10,
            dbId = 1,
            selftext = "Post content",
            subreddit = "testing",
            score = 90,
            created_utc = 1650000000L,
            num_comments = 50,
            permalink = "/r/testing/123",
            is_video = false,
            upvote_ratio = 0.95
        )

        // Act
        val domain = dto.toDomain()

        // Assert
        assertEquals(dto.title, domain.title)
        assertEquals(dto.author, domain.author)
        assertEquals(dto.num_comments, domain.numOfComments)
        assertEquals(dto.created_utc, domain.createdAt)
        assertEquals(dto.thumbnail, domain.thumbnail)
        assertEquals(dto.url, domain.url)
        assertEquals(dto.id, domain.id)
        assertEquals(dto.score, domain.score)
        assertEquals(dto.is_video, domain.isVideo)
        assertEquals(dto.selftext, domain.selfText)
        assertEquals(dto.subreddit, domain.subreddit)
        assertEquals(dto.ups, domain.ups)
        assertEquals(dto.downs, domain.downs)
        assertEquals(dto.permalink, domain.permalink)
        assertEquals(dto.upvote_ratio, domain.upvoteRatio)
        assertEquals(dto.domain, domain.domain)
    }
}
