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
import com.example.uhunt.SharedPref.UserDataManager
import com.example.uhunt.network.dto.LoginResponse
import com.example.uhunt.utils.Utilities
import com.example.uhunt.utils.Utilities.showToast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread

class LoginViewModel : ViewModel() {
    val isSuccessLoading = mutableStateOf(value = false)
    val imageErrorAuth = mutableStateOf(value = false)
    val progressBar = mutableStateOf(value = false)
    var snackbarHostState: SnackbarHostState
        private set

    init {
        snackbarHostState = SnackbarHostState()
    }

    private val loginRequestLiveData = MutableLiveData<Boolean>()
    private val _tokenData = MutableLiveData<LoginResponse?>()
    val tokenData: LiveData<LoginResponse?> get() = _tokenData
    fun login(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                progressBar.value = true
                val authService = RetrofitHelper.getAuthService()
                val responseService = authService.getLogin(
                    email, password, Utilities.Server_Key
                )

                if (responseService.isSuccessful) {
                    delay(1500L)

                    isSuccessLoading.value = true

                    responseService.body()?.let { tokenDto ->

                        val userData = tokenDto.user_data
//                        tokenDto.access_token.let { accessToken ->
//                            userData.user_id.let { userId ->
//                                UserDataManager.saveUserData(context, accessToken, userId)
//                            }
//                        }
                        _tokenData.postValue(tokenDto)
                        Log.d("Logging", "Response TokenDto: $tokenDto")
                    }
                }
                else {
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