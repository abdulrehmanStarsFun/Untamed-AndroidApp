package com.example.uhunt.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidorellana.logincomposeretrofit2.network.repository.RetrofitHelperUntamed
import com.example.uhunt.models.GetVideoDetailResponse
import com.example.uhunt.resposeModels.auths.ErrorResponse
import com.example.uhunt.utils.Utilities
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
class VideoDetailModel : ViewModel() {
    private val _videoDetails = MutableLiveData<GetVideoDetailResponse>()
    val videoDetails: LiveData<GetVideoDetailResponse> = _videoDetails

    fun fetchVideoDetails(userId: String, videoId: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitHelperUntamed.getAuthService().getVideoDetailApi(
                    type = "get_video_details",
                    platform = "phone",
                    videoId,Utilities.Server_Key,"7ea1e35bfbec739596a3e12b79faec4ae67fbff32d7094a0a8d5a8ed7764a6a8b19f5a2268901985e9510081ac30ffa83f10b68cde1cac07",
                    userId
                )
                if (response.isSuccessful) {
                    _videoDetails.value = response.body()
                } else {
                    // Handle error case
                    Log.d("VideoDetailModel", "FAILURE")

                }
            } catch (e: Exception) {
                // Handle exception
                Log.d("VideoDetailModel", "FAILURE")

            }
        }
    }
}

