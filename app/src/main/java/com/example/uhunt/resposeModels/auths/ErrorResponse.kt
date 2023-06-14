package com.example.uhunt.resposeModels.auths
data class ErrorResponse(
    val errors: ErrorDetails?
)

data class ErrorDetails(
    val error_id: Int?,
    val error_text: String?
)
