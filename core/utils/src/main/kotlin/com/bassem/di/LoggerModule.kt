package com.bassem.di

import com.bassem.utils.Logger
import com.bassem.utils.LoggerImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LoggerModule {

    @Binds
    abstract fun bindsLogger(impl: LoggerImp): Logger
}