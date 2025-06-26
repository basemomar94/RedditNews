package com.bassem.domain

import com.bassem.redditnews.domain.repo.GetPostsRepo
import com.bassem.redditnews.domain.usecase.FetchPostsUseCase
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class FetchPostsUseCaseTest {

    private val getPostsRepo = mockk<GetPostsRepo>()
    private lateinit var fetchPostsUseCase: FetchPostsUseCase


    @BeforeEach
    fun setup() {
        fetchPostsUseCase = FetchPostsUseCase(getPostsRepo)
    }

    @Test
    fun yr_dddA_ddd() = runTest {
        fetchPostsUseCase()
        coVerify { getPostsRepo.getPosts() }
    }
}