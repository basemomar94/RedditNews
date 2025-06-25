package com.bassem.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bassem.data.dto.RedditPost

@Dao
interface RedditPostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(posts: List<RedditPost>)

    @Query("SELECT * FROM reddit_posts")
    suspend fun getAllPosts(): List<RedditPost>

    @Query("DELETE FROM reddit_posts")
    suspend fun deleteAllPosts()
}