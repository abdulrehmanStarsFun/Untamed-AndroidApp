package com.example.uhunt.network.dto

data class LoginResponse(
    val access_token: String,
    val api_status: Int,
    val membership: Boolean,
    val timezone: String,
    val user_data: UserData,
    val user_id: String
)