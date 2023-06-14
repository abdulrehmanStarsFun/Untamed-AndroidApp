package com.example.uhunt.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.MutableLiveData
import okhttp3.MediaType
import okhttp3.RequestBody
import okhttp3.MultipartBody
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.davidorellana.logincomposeretrofit2.network.repository.RetrofitHelper
import com.example.uhunt.resposeModels.auths.ErrorResponse
import com.example.uhunt.utils.Utilities
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.File

class FillYourProfileViewModel : ViewModel() {

    val isSuccessLoading = mutableStateOf(value = false)
    val imageErrorAuth = mutableStateOf(value = false)
    val progressBar = mutableStateOf(value = false)
    val errorMessage = mutableStateOf<String?>(null)
    val successMessage = mutableStateOf<String?>(null)

    private val signUpRequestLiveData = MutableLiveData<Boolean>()
    fun fillDataApi(
        firstName: String,
        lastName: String,
        userName: String,
        gender: String,
        phoneNumber: String,
        accessToken: String
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                progressBar.value = true
                val authService = RetrofitHelper.getAuthService()
                val responseService = authService.filldata(
                    firstName,
                    lastName,
                    userName,
                    gender,
                    phoneNumber,
                    Utilities.Server_Key,
                    accessToken
                )

                if (responseService.isSuccessful) {
                    delay(1500L)

                    isSuccessLoading.value = true
                    responseService.body()?.let { tokenDto ->
                        successMessage.value = tokenDto.message
                        Log.d("Logging", "Response TokenDto: $tokenDto")
                    }
                } else {
                    responseService.errorBody()?.let { error ->
                        val errorJson = error.string()
                        val errorResponse = Gson().fromJson(errorJson, ErrorResponse::class.java)
                        errorMessage.value = errorResponse.errors?.error_text
                        delay(1500L)
                        imageErrorAuth.value = false
                        error.close()
                    }
                }

                signUpRequestLiveData.postValue(responseService.isSuccessful)
                progressBar.value = false
            } catch (e: Exception) {
                Log.d("Logging", "Error Authentication", e)
                progressBar.value = false
            }
        }
    }
}
