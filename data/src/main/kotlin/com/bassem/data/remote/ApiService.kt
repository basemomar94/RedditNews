package com.bassem.data.remote


import com.bassem.data.dto.RedditListingData
import retrofit2.http.GET

interface ApiService {

    @GET("kotlin/.json")
    suspend fun getPosts(): RedditListingData
}
