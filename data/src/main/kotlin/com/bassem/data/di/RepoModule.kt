package com.bassem.data.di

import com.bassem.data.repoimp.GetPostsImp
import com.bassem.redditnews.domain.repo.GetPostsRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {
    @Binds
    abstract fun bindsGetPostsModule(imp: GetPostsImp): GetPostsRepo
}