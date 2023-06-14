package com.example.uhunt.viewmodel


import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Constraints
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidorellana.logincomposeretrofit2.network.dto.TokenDto
import com.davidorellana.logincomposeretrofit2.network.repository.RetrofitHelper
import com.davidorellana.logincomposeretrofit2.network.repository.RetrofitHelperUntamed
import com.example.uhunt.SharedPref.UserDataManager
import com.example.uhunt.models.Featured
import com.example.uhunt.network.dto.LoginResponse
import com.example.uhunt.utils.Utilities
import com.example.uhunt.utils.Utilities.showToast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread

class VideoViewModel : ViewModel() {
    val isSuccessLoading = mutableStateOf(value = false)
    val imageErrorAuth = mutableStateOf(value = false)
    val progressBar = mutableStateOf(value = false)
    val _videoItems = MutableLiveData<List<Featured>>()
    private val loginRequestLiveData = MutableLiveData<Boolean>()
    private val _tokenData = MutableLiveData<LoginResponse?>()
    val tokenData: LiveData<LoginResponse?> get() = _tokenData
    fun getVideos(userid: String, accessToken: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                progressBar.value = true
                val authService = RetrofitHelperUntamed.getAuthService()
                val responseService = authService.getConitnueWatchVideosApi(
                    "get_videos", "phone", "1.0", "2",
                    Utilities.Server_Key, accessToken, userid
                )

                if (responseService.isSuccessful) {
                    delay(1500L)

                    isSuccessLoading.value = true

                    responseService.body()?.let { tokenDto ->
                        Log.d("Logging", "Response TokenDto: $tokenDto")
                        _videoItems.value = tokenDto.data.featured
                    }
                } else {
                    responseService.errorBody()?.let { error ->
                        imageErrorAuth.value = true
                        delay(1500L)
                        imageErrorAuth.value = false
                        error.close()
                    }

                }

                loginRequestLiveData.postValue(responseService.isSuccessful)
                progressBar.value = false
            } catch (e: Exception) {
                Log.d("Logging", "Error Authentication", e)
                progressBar.value = false
            }
        }
    }


}