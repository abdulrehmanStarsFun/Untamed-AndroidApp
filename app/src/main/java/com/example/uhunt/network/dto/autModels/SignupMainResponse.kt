package com.example.uhunt.network.dto.autModels

data class SignupMainResponse(
    val access_token: String,
    val api_status: Int,
    val membership: Boolean,
    val user_data: UserData,
    val user_id: String
)