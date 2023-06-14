package com.example.uhunt.navigation

import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.uhunt.SharedPref.Utilities
import com.example.uhunt.landingActivities.homePlaytube.homeScreen
import com.example.uhunt.landingActivities.logscreen
import com.example.uhunt.viewmodel.LoginViewModel
import com.example.uhunt.viewmodel.MainViewModel
import com.example.uhunt.viewmodel.ShortVdieoViewModel
import com.example.uhunt.viewmodel.VideoViewModel

@Composable
fun NavigationScreen(viewModel: LoginViewModel, videoViewModel: VideoViewModel,mainViewModel: MainViewModel,shortVdieoViewModel: ShortVdieoViewModel) {

    val navController = rememberNavController()
    val loadingProgressBar = viewModel.progressBar.value
    val imageError = viewModel.imageErrorAuth.value
    NavHost(
        navController = navController,
        startDestination = Destination.getStartDestination()
    ) {
        composable(route = Destination.Login.route) {
            if (viewModel.isSuccessLoading.value) {
                LaunchedEffect(key1 = Unit) {
                    navController.navigate(route = Destination.Home.route) {
                        popUpTo(route = Destination.Login.route) {
                            inclusive = true
                        }
                    }
                }
            } else {
                logscreen(
                    loadingProgressBar = loadingProgressBar,
                    onclickLogin = viewModel::login,
                    imageError = imageError,
                    viewModel = viewModel
                )
            }
        }

        composable(route = Destination.Home.route) {
            Utilities.saveString(LocalContext.current,"isLogged","true")

            homeScreen(viewModel,videoViewModel,mainViewModel,shortVdieoViewModel)
        }
    }
}