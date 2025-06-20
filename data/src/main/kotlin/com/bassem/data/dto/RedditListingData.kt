package com.bassem.data.dto

data class RedditListingData(
    val after: String?,
    val dist: Int?,
    val modhash: String?,
    val children: List<RedditPostContainer>
)
