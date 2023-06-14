package com.example.uhunt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.uhunt.network.dto.LoginResponse

class SharedViewModel : ViewModel() {
    private val _userProfileData = MutableLiveData<LoginResponse?>()
    val userProfileData: LiveData<LoginResponse?> get() = _userProfileData

    fun setUserProfileData(loginResponse: LoginResponse) {
        _userProfileData.value = loginResponse
    }
}
