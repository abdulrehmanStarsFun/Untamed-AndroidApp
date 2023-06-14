package com.example.uhunt.viewmodel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uhunt.models.UserProfileResponseModel
import com.example.uhunt.network.repository.UserRepository
import com.example.uhunt.network.repository.UserRepository.Result
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {
    private val _userData = MutableLiveData<Result<UserProfileResponseModel>>()
    val userData: LiveData<Result<UserProfileResponseModel>> = _userData

    fun fetchUserData(
        accessToken: String,
        serverKey: String,
        fetch: String,
        userId: String
    ) {
        viewModelScope.launch {
            val result = userRepository.getUserData(accessToken, serverKey, fetch, userId)
            _userData.value = result
        }
    }
}
