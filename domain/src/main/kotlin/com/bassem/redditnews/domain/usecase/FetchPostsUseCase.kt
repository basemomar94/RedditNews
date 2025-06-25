package com.bassem.redditnews.domain.usecase

import com.bassem.redditnews.domain.repo.GetPostsRepo
import javax.inject.Inject

class FetchPostsUseCase @Inject constructor(private val repo: GetPostsRepo) {

    suspend operator fun invoke() = repo.getPosts()
}