package com.bassem.data.repoimp

import com.bassem.data.mapper.toDomain
import com.bassem.data.remote.ApiService
import com.bassem.redditnews.domain.models.RedditPost
import com.bassem.redditnews.domain.repo.GetPostsRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetRepoPostsImp @Inject constructor(private val apiService: ApiService) : GetPostsRepo {
    override fun getPosts(): Flow<Result<List<RedditPost>>> {
        return flow<Result<List<RedditPost>>> {
            val response = apiService.getPosts().children.map { it.data }.map { it.toDomain() }
            emit(Result.success(response))
        }
    }
}