package com.example.uhunt.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.uhunt.network.dto.LoginResponse

class UserProfileViewModel : ViewModel() {
    val userProfileData = mutableStateOf<LoginResponse?>(null)

    fun setUserProfileData(loginResponse: LoginResponse) {
        userProfileData.value = loginResponse
    }
}
