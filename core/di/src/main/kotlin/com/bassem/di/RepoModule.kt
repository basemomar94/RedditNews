package com.bassem.di

import com.bassem.data.repoimp.GetRepoPostsImp
import com.bassem.redditnews.domain.repo.GetPostsRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {
    @Binds
    abstract fun bindsGetPostsModule(imp: GetRepoPostsImp): GetPostsRepo
}