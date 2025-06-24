package com.bassem.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bassem.data.dto.RedditPost

@Database(entities = [RedditPost::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun redditPostDao(): RedditPostDao
}