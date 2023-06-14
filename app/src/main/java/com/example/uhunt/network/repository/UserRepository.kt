package com.example.uhunt.network.repository
import com.davidorellana.logincomposeretrofit2.network.repository.AuthApiService
import com.example.uhunt.models.UserProfileResponseModel
import retrofit2.Response

class UserRepository(private val apiService: AuthApiService) {
    sealed class Result<out T> {
        data class Success<out T>(val data: T) : Result<T>()
        data class Error(val message: String) : Result<Nothing>()
    }

    suspend fun getUserData(
        accessToken: String,
        serverKey: String,
        fetch: String,
        userId: String
    ): Result<UserProfileResponseModel> {
        return try {
            val response = apiService.getUserData(accessToken, serverKey, fetch, userId)
            if (response.isSuccessful) {
                val userData = response.body()
                if (userData != null) {
                    Result.Success(userData)
                } else {
                    Result.Error("User data not found")
                }
            } else {
                Result.Error("Failed to fetch user data")
            }
        } catch (e: Exception) {
            Result.Error("Failed to fetch user data: ${e.message}")
        }
    }
}
