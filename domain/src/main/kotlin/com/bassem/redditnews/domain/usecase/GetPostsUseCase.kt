package com.bassem.redditnews.domain.usecase

import com.bassem.redditnews.domain.repo.GetPostsRepo
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(private val repo: GetPostsRepo) {

    operator fun invoke() = repo.getPosts()
}