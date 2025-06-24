package com.bassem.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bassem.data.dto.RedditPost

@Dao
interface RedditPostDao {

   @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(posts: List<RedditPost>)

    @Query("SELECT * FROM reddit_posts")
    fun getAllPosts(): List<RedditPost>
}