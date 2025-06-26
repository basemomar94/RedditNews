package com.bassem.data.repoimp

import com.bassem.data.local.RedditPostDao
import com.bassem.data.mapper.toDomain
import com.bassem.data.remote.ApiService
import com.bassem.redditnews.domain.models.RedditPost
import com.bassem.redditnews.domain.repo.GetPostsRepo
import com.bassem.utils.Logger
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetPostsImp @Inject constructor(
    private val apiService: ApiService, private val dao: RedditPostDao
) : GetPostsRepo {
    private val logger = Logger("GetRepoPostsImp")

    override suspend fun getPosts(): Flow<Result<List<RedditPost>>> = flow {
        val result = runCatching {
            val response = apiService.getPosts()
            val dataPosts = response.data.children?.mapNotNull { it.data } ?: emptyList()
            val domainPosts = dataPosts.map { it.toDomain() }

            dao.deleteAllPosts()
            dao.insertAll(dataPosts)
            domainPosts
        }
        result
            .onSuccess { emit(Result.success(it)) }
            .onFailure { exception ->
                val cached = dao.getAllPosts().map { it.toDomain() }
                if (cached.isNotEmpty()) {
                    emit(Result.success(cached))
                } else {
                    emit(Result.failure(exception))
                }
            }
    }.flowOn(Dispatchers.IO)

}