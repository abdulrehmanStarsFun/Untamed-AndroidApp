package com.example.uhunt.landingActivities.homePlaytube

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.uhunt.R
import com.example.uhunt.jetpackClassess.DemoDataProvider
import com.example.uhunt.jetpackClassess.DemoDataProvider.item
import com.example.uhunt.jetpackClassess.RowItems.ClipRowItems
import com.example.uhunt.jetpackClassess.RowItems.ClipRowItemsProfile
import com.example.uhunt.jetpackClassess.RowItems.HomeBottomListItems
import com.example.uhunt.jetpackClassess.dialogs.DialogState
import com.example.uhunt.jetpackClassess.dialogs.DialogType
import com.example.uhunt.jetpackClassess.lists.ContinueVideoHorizListView
import com.example.uhunt.landingActivities.tikTok.TiktokActivity
import com.example.uhunt.models.Featured
import com.example.uhunt.models.ShortsVideoModel

import com.example.uhunt.viewmodel.LoginViewModel
import com.example.uhunt.viewmodel.MainViewModel
import com.example.uhunt.viewmodel.ShortVdieoViewModel
import com.example.uhunt.viewmodel.VideoViewModel
import vpl


class MainPlayTubeActviity : ComponentActivity() {
    val mainViewModel by viewModels<MainViewModel>()
    val shortVideoViewModel by viewModels<ShortVdieoViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            com.example.uhunt.jet.theme.UhuntTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val loginViewModel: LoginViewModel by viewModels()
                    val viewModel: VideoViewModel by viewModels()
                    homeScreen(loginViewModel, viewModel, mainViewModel, shortVideoViewModel)

                }
            }
        }
    }
}

@Composable
fun homeScreen(
    loginViewModel: LoginViewModel,
    videoViewModel: VideoViewModel,
    mainViewModel: MainViewModel,
    shortVdieoViewModel: ShortVdieoViewModel
) {
    val context = LocalContext.current
    val list = remember { DemoDataProvider.itemList }
    var getuserid by rememberSaveable { mutableStateOf(value = "") }
    var getAccessToken by rememberSaveable { mutableStateOf(value = "") }
    val lifecycleOwner = LocalLifecycleOwner.current
    loginViewModel.tokenData.observe(lifecycleOwner) { loginResponse ->
        // Handle the token data here
        loginResponse?.let { tokenDto ->
            val userData = tokenDto.user_data
            getAccessToken = tokenDto.access_token
            getuserid = userData.user_id
            Toast.makeText(context, getuserid + "USER_ID", Toast.LENGTH_LONG).show()
        }
    }
    var dialogState by remember { mutableStateOf(DialogState(false, DialogType.SIMPLE)) }

    if (dialogState.showDialog) {
    }


    Scaffold(content = {
        Box(modifier = Modifier.padding(it)) {
            //add your layout here
            Column() {
                TopLayout()
                Column (modifier = Modifier.verticalScroll(rememberScrollState())){
                    ContinueListRow()
                    if (mainViewModel.trendingMovies.isNotEmpty()) {
                        LazyRow(modifier = Modifier.padding(start = 5.dp, bottom = 1.dp)) {
                            itemsIndexed(mainViewModel.trendingMovies) { index, item ->
                                ContinueVideoHorizListView(
                                    item = item,
                                    modifier = Modifier
                                        .padding(start = 5.dp, bottom = 1.dp)
                                        .size(170.dp)
                                )
                            }
                        }
                    }


                    ClipsListRow()
                    if (shortVdieoViewModel.shortsVideoModel.isNotEmpty()) {
                        LazyRow(modifier = Modifier.padding(start = 5.dp, bottom = 1.dp)) {
                            itemsIndexed(shortVdieoViewModel.shortsVideoModel) { index, item ->
                                ClipRowItems(
                                    item = item,
                                    index,
                                    modifier = Modifier
                                        .padding(start = 5.dp, bottom = 1.dp)
                                )
                            }
                        }
                    }

                    if (mainViewModel.trendingMovies.isNotEmpty()) {
                       Column(modifier = Modifier.padding(start = 5.dp, bottom = 1.dp)) {
                           for ((index, item) in mainViewModel.trendingMovies.withIndex()) {
                                HomeBottomListItems(
                                    item = item,
                                    modifier = Modifier
                                        .padding(start = 5.dp, bottom = 1.dp)
                                        .size(170.dp)
                                )
                            }
                        }
                    }
//
//                    LazyColumn() {
//                        item { vpl() }
//                    }
                }
            }


        }
    },
        bottomBar = {
            BottomNavigationWithLabelComponent()
        })

    val noIndicator: @Composable (List<TabPosition>) -> Unit = {}
}

@Composable

fun bottom() {
    val context = LocalContext.current

    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Home", "Shop", "TV", "Menu")
    // BottomNavigation is a Composable that is used to give easy access to some items
    // and are placed at the bottom of the screen so that the user can easily navigate
    // by clicking the items of the BottomNavigation

    BottomNavigation(
        modifier = Modifier
            .padding(top = 10.dp)
            .fillMaxWidth(),
        backgroundColor = Color.Black,
        contentColor = Color.White
    ) {
//        items.forEachIndexed { index, item ->
        // BottomNavigationItem is used to add items to a BottomNavigation and since the
        // BottomNavigation is having a RowScope, so the BottomNavigationItems will be
        // placed horizontally.
        BottomNavigationItem(
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = null
                )


            }, label = { Text("Home") },
            selected = false,
            onClick = {
                val intent = Intent(context, MainPlayTubeActviity::class.java)
                context.startActivity(intent)
            }
        )
        BottomNavigationItem(
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.shop_menu),
                    contentDescription = null
                )


            }, label = { Text("Shop") },
            selected = false,
            onClick = { /*TODO*/ }
        )
        val context = LocalContext.current
        BottomNavigationItem(
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.television_black),
                    contentDescription = null,
                )


            }, label = { Text("TV") },
            selected = false,
            onClick = {

                val intent = Intent(context, TiktokActivity::class.java)
                context.startActivity(intent)
            })
        BottomNavigationItem(
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.menu_bottom),
                    contentDescription = null
                )


            }, label = { Text("Menu") },
            selected = false,
            onClick = {


            })

//        }
    }
}

//Inspired from jetcaster sample. I hope compose can add simple Chip UI element that can
// support images or icons with multiple states.


//fun bottom() {
//    val context = LocalContext.current
//
//    var selectedItem by remember { mutableStateOf(0) }
//    val items = listOf("Home", "Shop", "TV", "Menu")
//    // BottomNavigation is a Composable that is used to give easy access to some items
//    // and are placed at the bottom of the screen so that the user can easily navigate
//    // by clicking the items of the BottomNavigation
//
//    BottomNavigation(
//        modifier = Modifier
//            .padding(top = 10.dp)
//            .fillMaxWidth(),
//        backgroundColor = Color.Black,
//        contentColor = Color.White
//    ) {
////        items.forEachIndexed { index, item ->
//        // BottomNavigationItem is used to add items to a BottomNavigation and since the
//        // BottomNavigation is having a RowScope, so the BottomNavigationItems will be
//        // placed horizontally.
//        BottomNavigationItem(
//            icon = {
//                Image(
//                    painter = painterResource(id = R.drawable.home),
//                    contentDescription = null
//                )
//
//
//            }, label = { Text("Home") },
//            selected = false,
//            onClick = {
//                val intent = Intent(context, MainPlayTubeActviity::class.java)
//                context.startActivity(intent)
//            }
//        )
//        BottomNavigationItem(
//            icon = {
//                Image(
//                    painter = painterResource(id = R.drawable.shop_menu),
//                    contentDescription = null
//                )
//
//
//            }, label = { Text("Shop") },
//            selected = false,
//            onClick = { /*TODO*/ }
//        )
//        val context = LocalContext.current
//        BottomNavigationItem(
//            icon = {
//                Image(
//                    painter = painterResource(id = R.drawable.television_black),
//                    contentDescription = null,
//                )
//
//
//            }, label = { Text("TV") },
//            selected = false,
//            onClick = {
//
//                val intent = Intent(context, TiktokActivity::class.java)
//                context.startActivity(intent)
//            })
//        BottomNavigationItem(
//            icon = {
//                Image(
//                    painter = painterResource(id = R.drawable.menu_bottom),
//                    contentDescription = null
//                )
//
//
//            }, label = { Text("Menu") },
//            selected = false,
//            onClick = {
//
//
//            })
//
////        }
//    }
//}




