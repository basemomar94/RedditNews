package com.bassem.di

import com.bassem.redditnews.domain.repo.GetPostsRepo
import com.bassem.redditnews.domain.usecase.FetchPostsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object FetchPostsUseCaseModule {

    @Provides
    fun provideFetchPostsUseCase(repo: GetPostsRepo) = FetchPostsUseCase(repo)
}