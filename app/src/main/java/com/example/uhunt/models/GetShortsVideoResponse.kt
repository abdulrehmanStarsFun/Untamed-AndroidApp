package com.example.uhunt.models

data class GetShortsVideoResponse(
    val api_status: String,
    val api_version: String,
    val `data`: List<DataX>,
    val order: String
)