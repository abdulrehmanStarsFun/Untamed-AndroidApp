package com.example.uhunt.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidorellana.logincomposeretrofit2.network.repository.RetrofitHelper
import com.davidorellana.logincomposeretrofit2.network.repository.RetrofitHelperUntamed
import com.example.uhunt.models.Featured
import com.example.uhunt.models.GetWatchingVideoModel
import com.example.uhunt.models.ShortsVideoModel
import com.example.uhunt.network.repository.ContinuesWatchingRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val apiService = RetrofitHelperUntamed.getAuthService()
    private lateinit var repository: ContinuesWatchingRepository
    var trendingMovies: List<Featured> by mutableStateOf(listOf())
    var watching_videosModels: List<GetWatchingVideoModel> by mutableStateOf(listOf())

    lateinit var clickedItem: Featured

    init {
        fetchTrendingMovies()
    }

    fun  fetchTrendingMovies() {

        repository = ContinuesWatchingRepository(apiService)
        viewModelScope.launch {
            var response = repository.fetchTrendingMovies()
            when (response) {
                is ContinuesWatchingRepository.Result.Success -> {

                    Log.d("MainViewModel", "Success")
                    trendingMovies = response.movieList
                }
                is ContinuesWatchingRepository.Result.Failure -> {
                    Log.d("MainViewModel", "FAILURE")
                }
                else -> {}
            }
        }
    }
    fun fetchWatchingMovies() {

        repository = ContinuesWatchingRepository(apiService)
        viewModelScope.launch {
            var response = repository.fetchWatchingMovies()
            when (response) {
                is ContinuesWatchingRepository.Result.SuccessForWatchingVideos -> {

                    Log.d("MainViewModel", "Success")
                    watching_videosModels = response.list
                }
                is ContinuesWatchingRepository.Result.FailureForWatchingVideos -> {
                    Log.d("MainViewModel", "FAILURE")
                }
                else -> {}
            }
        }
    }

    fun itemClicked(item: Featured) {
        clickedItem = item
    }
}