package com.example.uhunt.models

data class GetWatchingVideosResponse(
    val api_status: String,
    val api_version: String,
    val `data`: List<GetWatchingVideoModel>
)