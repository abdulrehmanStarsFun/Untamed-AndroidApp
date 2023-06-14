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
import com.example.uhunt.network.repository.ShortVideoRepository
import kotlinx.coroutines.launch

class ShortVdieoViewModel : ViewModel() {
    private val apiService = RetrofitHelperUntamed.getAuthService()
    private lateinit var repository: ShortVideoRepository
    var shortsVideoModel: List<ShortsVideoModel> by mutableStateOf(listOf())

    lateinit var clickedItem: ShortsVideoModel

    init {
        fetchShortsVideos()
    }
  fun fetchShortsVideos() {

        repository = ShortVideoRepository(apiService)
        viewModelScope.launch {
            var response = repository.fetchShortsVideoApi()
            when (response) {
                is ShortVideoRepository.Result.Success -> {

                    Log.d("MainViewModel", "Success")
                    shortsVideoModel = response.movieList
                }
                is ShortVideoRepository.Result.Failure -> {
                    Log.d("MainViewModel", "FAILURE")
                }
                else -> {}
            }
        }
    }

    fun itemClicked(item: ShortsVideoModel) {
        clickedItem = item
    }
}