package com.example.uhunt.models

data class GetShortsVideoModel(
    val api_status: String,
    val api_version: String,
    val `data`: List<ShortsVideoModel>,
    val order: String
)