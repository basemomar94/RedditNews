package com.bassem.data.repoimp

import com.bassem.data.mapper.toDomain
import com.bassem.data.remote.ApiService
import com.bassem.redditnews.domain.models.RedditPost
import com.bassem.redditnews.domain.repo.GetPostsRepo
import com.bassem.utils.Logger
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetRepoPostsImp @Inject constructor(
    private val apiService: ApiService,
) : GetPostsRepo {
    private val logger = Logger("GetRepoPostsImp")

    override fun getPosts(): Flow<Result<List<RedditPost>>> {
        return flow<Result<List<RedditPost>>> {
            val response = apiService.getPosts().data.children!!.map { it.data }.map { it!!.toDomain() }
            logger.d("response is $response")
           emit(Result.success(response))
            logger.d(response.toString())
        }.catch { e ->
            logger.e(e.message.toString())
            emit(Result.failure(e))
        }
    }
}