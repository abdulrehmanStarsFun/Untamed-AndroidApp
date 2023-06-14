package com.example.uhunt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.uhunt.navigation.NavigationScreen
import com.example.uhunt.ui.activities.landing.ui.theme.UhuntTheme
import com.example.uhunt.utils.Utilities
import com.example.uhunt.viewmodel.LoginViewModel
import com.example.uhunt.viewmodel.MainViewModel
import com.example.uhunt.viewmodel.ShortVdieoViewModel


import com.example.uhunt.viewmodel.VideoViewModel

class StartActivity : ComponentActivity() {

    private val viewModel: LoginViewModel by viewModels()
    val videoViewModel: VideoViewModel by viewModels()

    val mainViewModel by viewModels<MainViewModel>()
    val shortVdieoViewModel by viewModels<ShortVdieoViewModel>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UhuntTheme() {
                Surface(color = MaterialTheme.colors.background) {
                    val isLogged=Utilities.getString(LocalContext.current,"isLoggee")
//                    NavigationScreen(viewModel = viewModel,videoViewModel)

                    NavigationScreen(viewModel = viewModel, videoViewModel =videoViewModel,mainViewModel,shortVdieoViewModel)
                }
            }
        }
    }
}

@Composable
fun test(){

//    var clicked by remember { mutableStateOf(false) }
//var tint=Color.Black
//    IconButton(onClick = ) {
//        Icon(imageVector = Icons.Outlined.Face,
//            contentDescription = null,
//          tint = if (tint== Color.Black){
//              tint= Color.Green
//          }
//        )
//    }

}