package com.bassem.data.di

import android.content.Context
import androidx.room.Room
import com.bassem.data.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabaseModule(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "reddit_posts").build()

    @Provides
    fun provideDao(appDatabase: AppDatabase) = appDatabase.redditPostDao()

}