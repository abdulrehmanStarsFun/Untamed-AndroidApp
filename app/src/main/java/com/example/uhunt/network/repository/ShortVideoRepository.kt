package com.example.uhunt.network.repository

import android.util.Log
import com.davidorellana.logincomposeretrofit2.network.repository.AuthApiServiceUntamedoutback
import com.example.uhunt.models.ShortsVideoModel
import com.example.uhunt.models.Featured
import com.example.uhunt.utils.Utilities

class ShortVideoRepository(val movieFetchApi: AuthApiServiceUntamedoutback) {

    sealed class Result {
        object LOADING : Result()
        data class Success(val movieList: List<ShortsVideoModel>) : Result()

        data class Failure(val throwable: Throwable) : Result()
    }

       suspend fun fetchShortsVideoApi(): Result {
        return try {
            val shortsList = movieFetchApi.getShortsVdieoApi(
                "shorts", "phone", "1.0", "2",
               "get_shorts", Utilities.Server_Key, "7ea1e35bfbec739596a3e12b79faec4ae67fbff32d7094a0a8d5a8ed7764a6a8b19f5a2268901985e9510081ac30ffa83f10b68cde1cac07", "29699"
            ).body()!!.data
//            Log.d("MOVIELIST", "success " + shortsList.size)
            Result.Success(movieList = shortsList)
        } catch (exception: Exception) {
            Log.d("MOVIELIST", "failure ")
            Result.Failure(exception)
        }
    }


}