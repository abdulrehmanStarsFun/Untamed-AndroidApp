@file:OptIn(ExperimentalComposeUiApi::class)


package com.example.uhunt.jet

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.uhunt.Clist
import com.example.uhunt.R
import com.example.uhunt.jet.theme.UhuntTheme
import com.example.uhunt.jetpackClassess.DemoDataProvider
import com.example.uhunt.landingActivities.homePlaytube.BottomNavigationWithLabelComponent
import com.example.uhunt.landingActivities.homePlaytube.ClipsListHome
import com.example.uhunt.landingActivities.homePlaytube.CustomImageChip
import com.example.uhunt.landingActivities.homePlaytube.HorizontalListView
import com.example.uhunt.landingActivities.homePlaytube.ListItemDivider
import com.example.uhunt.models.UserProfileResponseModel
import com.example.uhunt.network.repository.UserRepository
import com.example.uhunt.viewmodel.LoginViewModel
import com.example.uhunt.viewmodel.UserViewModel

//import com.example.uhunt.landingActivities.homePlaytube.bottom

class user_profile : ComponentActivity() {
//    private val userRepository = UserRepository() // Provide the appropriate UserRepository instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UhuntTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                ) {
                    val loginViewModel: LoginViewModel by viewModels()
//                    val userViewModel = viewModel { UserViewModel(userRepository) }

                    userprofile(onclickLogin = loginViewModel::login)
                }
            }
        }
    }
}

@SuppressLint("Range")
@Composable
fun userprofile(onclickLogin: (email: String, password: String) -> Unit) {
    val tweets = remember { DemoDataProvider.tweetList.filter { it.tweetImageId > 0 } }
    val selectedIndex = remember { mutableStateOf(0) }
    val list = remember { DemoDataProvider.itemList }
    val profiles = remember { DemoDataProvider.tweetList }
    val context = LocalContext.current
//    val userDataResult by userViewModel.userData.observeAsState()

    // Fetch user data when the screen is first displayed
//    LaunchedEffect(true) {
//        userViewModel.fetchUserData("7ea1e35bfbec739596a3e12b79faec4ae67fbff32d7094a0a8d5a8ed7764a6a8b19f5a2268901985e9510081ac30ffa83f10b68cde1cac07", "d4e8b720bc18f4a5151771982ab2a9195bd66323-f8150098d8df212f472329a755a6b628-56899340", "fetch-value", "29699")
//    }
//    when (val result = userDataResult) {
//        is UserRepository.Result.Success -> {
//            val userProfile = result.data
//            // Handle successful retrieval of user profile data
//            // You can access the user profile data using `userProfile`
//        }
//        is UserRepository.Result.Error -> {
//            val errorMessage = result.message
//            // Handle error while retrieving user profile data
//        }
//        else -> {
//            // Handle initial state or loading state
//        }
//    }

    // Render UI based on the user data result

    // Show loading indicator if data is being fetched

    Scaffold(content = {
        Box(modifier = Modifier.padding(it)) {

            Column() {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    val context = LocalContext.current
                    val currentActivity = remember {
                        context as? Activity
                    }
                    Image(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp, 30.dp)
                            .weight(0.7f)
                            .align(Alignment.CenterVertically)
                            .clickable {
                                currentActivity?.finish()
                            }
                    )
                    var text by remember { mutableStateOf(TextFieldValue("")) }
//                OutlinedTextField(
//                    value = text,
//                    leadingIcon = {
//
//                        Image(
//                            painter = painterResource(id = R.drawable.magnifier_black),
//                            contentDescription = null
//                        )
//                    },
//                    modifier = Modifier
//                        .weight(2.5f)
//                        .height(55.dp),
//                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
//                    label = { Text(text = "Search for anyhing") },
//                    placeholder = { Text(text = "Search") },
////                colors = TextFieldDefaults.outlinedTextFieldColors(
////                    focusedLabelColor = Color.White,
////                    unfocusedLabelColor = Color.White,
////                    focusedBorderColor = Color.White,
////                    unfocusedBorderColor = Color.White,
////                    textColor = Color.White, leadingIconColor = Color.White
////                ),
//                    onValueChange = {
//                        text = it
//                    },
//                    singleLine = true, maxLines = 1
//                )
                    OutlinedTextField(
                        value = text,
                        leadingIcon = {
                            Image(
                                painter = painterResource(id = R.drawable.magnifier_black),
                                contentDescription = null
                            )
                        },
                        modifier = Modifier
                            .weight(2.5f)
                            .height(60.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        label = {
                            Text(
                                text = "Search for anything",
                                style = TextStyle(fontSize = 14.sp)
                            )
                        },
                        placeholder = { Text(text = "", modifier = Modifier.fillMaxHeight()) },

                        onValueChange = {
                            text = it
                        },
                        singleLine = true, maxLines = 1
                    )

                    Image(
                        painter = painterResource(id = R.drawable.chromecast_icon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(25.dp, 22.dp)
                            .weight(1f)
                            .align(Alignment.CenterVertically)

                    )

                    Image(
                        painter = painterResource(id = R.drawable.horizontal_option),
                        contentDescription = null,
                        modifier = Modifier
                            .size(5.dp, 20.dp)
                            .weight(0.4f)
                            .align(Alignment.CenterVertically)
                            .padding(end = 10.dp),
                        colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground)

                    )

                }

                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {


                    Row(
                        modifier = Modifier
                            .wrapContentHeight()
                            .wrapContentWidth()
                            .padding(start = 10.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.user_pro),
                            contentDescription = null,
                            modifier = Modifier
                                .height(80.dp)
                                .width(80.dp)
                                .align(Alignment.CenterVertically)
                                .border(2.dp, Color.Gray, CircleShape)
                                .weight(0.5f)

                        )
                        Column(
                            modifier = Modifier
                                .wrapContentHeight()
                                .fillMaxWidth()
                                .padding(start = 10.dp)
                                .weight(2f)
                        ) {
                            Text(
                                text = "Uhunt App",
                                textAlign = TextAlign.Start,
//                    color = Color.White,
                                style = TextStyle(
                                    fontSize = 22.sp,
                                    fontFamily = FontFamily(Font(R.font.roboto_bold))
                                )
                            )

                            Row() {
                                Text(
                                    text = "@uhuntapp",
//                        color = Color.White,
                                    textAlign = TextAlign.Start,
                                    style = TextStyle(
                                        fontSize = 13.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_regular))
                                    )
                                )
                                Text(
                                    text = "849 videos",
//                        color = Color.White,
                                    textAlign = TextAlign.Start,
                                    style = TextStyle(
                                        fontSize = 13.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_regular))
                                    )
                                )
                                Text(
                                    text = "9 Series",
//                        color = Color.White,
                                    textAlign = TextAlign.Start,
                                    style = TextStyle(
                                        fontSize = 13.sp,
                                        fontFamily = FontFamily(Font(R.font.roboto_regular))
                                    )
                                )


                            }
                            Text(
                                text = "We make some of Australia's best hunting \n" +
                                        "videos specializing in hunting with dogs across\n" +
                                        "Australia. We welcome you to our channel.",
                                textAlign = TextAlign.Start,
//                    color = Color.White,
                                style = TextStyle(
                                    fontSize = 13.sp,
                                    fontFamily = FontFamily(Font(R.font.roboto_regular))
                                )
                            )

                            Text(
                                text = "Partenship:",
                                textAlign = TextAlign.Start,
//                    color = Color.White,
                                style = TextStyle(
                                    fontSize = 13.sp,
                                    fontFamily = FontFamily(Font(R.font.roboto_regular))
                                )
                            )

                            Text(
                                text = "www.bristleup.com.au",
                                textAlign = TextAlign.Start,
                                color = Color(android.graphics.Color.parseColor("#009AFF")),
                                style = TextStyle(
                                    fontSize = 13.sp,
                                    fontFamily = FontFamily(Font(R.font.roboto_regular))
                                )
                            )

                        }

                    }


                    Column() {
                        ScrollableTabRow(
                            selectedTabIndex = selectedIndex.value,
                            divider = {}, /* Disable the built-in divider */
                            edgePadding = 0.dp,
                            backgroundColor = Color.Transparent,
                            modifier = Modifier
                                .fillMaxWidth()

                        ) {
                            tweets.forEachIndexed { index, tweet ->
                                Tab(
                                    selected = index == selectedIndex.value,
                                    onClick = {
                                        selectedIndex.value = index
                                    }
                                ) {
                                    CustomImageChip(
                                        text = tweet.author,
//                        imageId = tweet.authorImageId,
                                        selected = index == selectedIndex.value,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(horizontal = 1.dp, vertical = 10.dp)
                                    )
                                }
                            }
                        }


//        PostItem(
//            post = tweets[selectedIndex.value],
//            isLiked = Random.nextBoolean(),
//            onLikeClicked = {},
//            onCommentsClicked = {},
//            onSendClicked = {}
//        )
                    }


                    Box(
                        modifier = Modifier
                            .wrapContentHeight()
                            .fillMaxWidth()
                    ) {
                        Column() {


                            HorizontalListView("Featured Channel Videos")

                            Row() {
                                Button(
                                    onClick = { /*TODO*/ },
                                    modifier = Modifier
                                        .wrapContentWidth()
                                        .height(35.dp)
                                        .weight(1.5f)
                                        .padding(start = 5.dp),
                                    shape = RoundedCornerShape(10.dp),
                                    colors = ButtonDefaults.buttonColors(
//                            backgroundColor = Color(android.graphics.Color.parseColor("#1B1B1B")),
//                            contentColor = Color(android.graphics.Color.parseColor("#FFFFFF"))
                                        MaterialTheme.colors.background
                                    ),
                                ) {
                                    Text(
                                        text = "View Store", maxLines = 1,
//                            color = Color.White,
                                        style = TextStyle(
                                            fontSize = 10.sp,
                                            fontFamily = FontFamily(Font(R.font.roboto_bold))
                                        ), modifier = Modifier
                                            .fillMaxWidth()
                                            .fillMaxHeight()
                                    )

                                }

                                Button(
                                    onClick = { /*TODO*/ },
                                    modifier = Modifier
                                        .wrapContentWidth()
                                        .height(35.dp)
                                        .weight(1.5f)
                                        .padding(start = 5.dp, end = 5.dp),
                                    shape = RoundedCornerShape(10.dp),
                                    colors = ButtonDefaults.buttonColors(
//                            backgroundColor = Color(android.graphics.Color.parseColor("#1B1B1B")),
//                            contentColor = Color(android.graphics.Color.parseColor("#FFFFFF"))
                                        MaterialTheme.colors.background
                                    ),
                                ) {
                                    Text(
                                        text = "View Social", maxLines = 1,
//                            color = Color.White,
                                        style = TextStyle(
                                            fontSize = 10.sp,
                                            fontFamily = FontFamily(Font(R.font.roboto_bold))
                                        ), modifier = Modifier
                                            .fillMaxWidth()
                                            .fillMaxHeight()
                                    )

                                }
                                Button(
                                    onClick = { /*TODO*/ },
                                    modifier = Modifier
                                        .wrapContentWidth()
                                        .height(35.dp)
                                        .weight(2f)
                                        .padding(start = 5.dp, end = 5.dp),
                                    shape = RoundedCornerShape(10.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        backgroundColor = Color(
                                            android.graphics.Color.parseColor(
                                                "#AC0000"
                                            )
                                        ),
                                        contentColor = Color(android.graphics.Color.parseColor("#FFFFFF"))

                                    ),
                                ) {
                                    Row() {
                                        Text(
                                            text = "Subscribe",
                                            color = Color.White,
                                            style = TextStyle(
                                                fontSize = 14.sp,
                                                fontFamily = FontFamily(Font(R.font.roboto_bold))
                                            ), modifier = Modifier
                                                .fillMaxWidth()
                                                .fillMaxHeight()
                                                .weight(1.5f)
                                        )
                                        Image(
                                            painter = painterResource(id = R.drawable.down_arrow),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .weight(0.5f)
                                                .width(30.dp)
                                                .height(10.dp)
                                                .align(Alignment.CenterVertically),
                                        )
                                    }


                                }
                                var clicked by remember { mutableStateOf(false) }
                                Button(
                                    onClick = { clicked = !clicked },
                                    modifier = Modifier
                                        .wrapContentWidth()
                                        .height(35.dp)
                                        .weight(1f)
                                        .padding(start = 5.dp),
                                    shape = RoundedCornerShape(10.dp),
                                    colors = ButtonDefaults.buttonColors(
//                            backgroundColor = Color(android.graphics.Color.parseColor("#1B1B1B")),
//                            contentColor = Color(android.graphics.Color.parseColor("#FFFFFF"))
                                        MaterialTheme.colors.background
                                    ),
                                ) {

//                        Image(
//                            painter = painterResource(id = R.drawable.bell_ic),
//                            contentDescription = null,
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .height(24.dp),
//                            colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground)
//                        )
//                        IconButton(onClick = {clicked=!clicked}) {
                                    Icon(
                                        painterResource(id = R.drawable.bell),
                                        contentDescription = null,
//                                modifier = Modifier
////                                    .height(35.dp)
////                                    .width(35.dp)
//                                    .padding(start = 15.dp, bottom = 15.dp),
                                        tint = if (clicked) Color.Red else Color.Black
                                    )
//                        }

                                }
                            }

                            lateinit var courselist: List<Clist>
                            courselist = ArrayList<Clist>()
                            courselist =
                                (courselist + Clist(
                                    "All Videos",
                                    R.drawable.playlist_ic
                                )) as ArrayList<Clist>
                            courselist =
                                (courselist + Clist(
                                    "Series",
                                    R.drawable.playlist_player
                                )) as ArrayList<Clist>
                            courselist = (courselist + Clist(
                                "Movies",
                                R.drawable.film
                            )) as ArrayList<Clist>
                            courselist =
                                (courselist + Clist(
                                    "Clips",
                                    R.drawable.video_play
                                )) as ArrayList<Clist>
                            courselist =
                                (courselist + Clist(
                                    "Podcasts",
                                    R.drawable.podcast
                                )) as ArrayList<Clist>
                            courselist =
                                (courselist + Clist(
                                    "Channels",
                                    R.drawable.player
                                )) as ArrayList<Clist>
                            courselist =
                                (courselist + Clist(
                                    "Store",
                                    R.drawable.store_ic
                                )) as ArrayList<Clist>
                            courselist =
                                (courselist + Clist(
                                    "Social",
                                    R.drawable.store_ic
                                )) as ArrayList<Clist>
                            courselist =
                                (courselist + Clist(
                                    "About",
                                    R.drawable.information_button
                                )) as ArrayList<Clist>

                            LazyRow(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentHeight()
                            ) {
                                itemsIndexed(courselist) { index, item ->


                                    Button(
                                        onClick = {},
                                        modifier = Modifier
                                            .padding(8.dp)
                                            .width(100.dp)
                                            .height(60.dp),
                                        shape = RoundedCornerShape(15.dp),
                                        colors = ButtonDefaults.buttonColors(
//                                backgroundColor = Color.Black,
//                                contentColor = Color.White,
                                            MaterialTheme.colors.background
                                        ),
                                    ) {
                                        Column() {
                                            Image(
                                                painter = painterResource(id = courselist[index].languageimage),
                                                contentDescription = null,
                                                modifier = Modifier.align(Alignment.CenterHorizontally),
                                                colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground)
                                            )
                                            Spacer(modifier = Modifier.width(5.dp))
                                            Text(
                                                text = courselist[index].languagename,
                                                style = TextStyle(
                                                    fontSize = 13.sp,
//                                        color = Color.White,
                                                    fontFamily = FontFamily(Font(R.font.roboto_regular))
                                                )
                                            )
                                        }
                                    }//1

                                }

                            }

                            lateinit var courselist2: List<Clist>
                            courselist2 = ArrayList<Clist>()
                            courselist2 = (courselist2 + Clist(
                                "Jesse Farr",
                                R.drawable.video_thumbnail
                            )) as ArrayList<Clist>
                            courselist2 = (courselist2 + Clist(
                                "Joey Sir",
                                R.drawable.video_thumbnail
                            )) as ArrayList<Clist>
                            courselist2 = (courselist2 + Clist(
                                "Matt Sandford",
                                R.drawable.video_thumbnail
                            )) as ArrayList<Clist>
                            courselist2 = (courselist2 + Clist(
                                "Sally Richards",
                                R.drawable.video_thumbnail
                            )) as ArrayList<Clist>
                            courselist2 = (courselist2 + Clist(
                                "Joey Sir",
                                R.drawable.video_thumbnail
                            )) as ArrayList<Clist>
                            courselist2 = (courselist2 + Clist(
                                "Kevin Scotch",
                                R.drawable.video_thumbnail
                            )) as ArrayList<Clist>
                            courselist2 = (courselist2 + Clist(
                                "Sam Bensan",
                                R.drawable.video_thumbnail
                            )) as ArrayList<Clist>
                            courselist2 = (courselist2 + Clist(
                                "Joey Sir",
                                R.drawable.video_thumbnail
                            )) as ArrayList<Clist>


                            LazyRow(
                                modifier = Modifier
                                    .wrapContentWidth()
                                    .wrapContentHeight()
//                        .background(MaterialTheme.colors.onBackground)

                            ) {
                                itemsIndexed(courselist2) { index, item ->

                                    Button(
                                        onClick = {},
                                        modifier = Modifier.width(350.dp),
                                        shape = RoundedCornerShape(15.dp),
                                        colors = ButtonDefaults.buttonColors(
                                            backgroundColor = MaterialTheme.colors.background

                                        ),
                                    ) {
                                        Column(modifier = Modifier.wrapContentHeight()) {
                                            Row(

                                            ) {
                                                Image(
                                                    painter = painterResource(id = courselist2[index].languageimage),
                                                    contentDescription = null,
                                                    modifier = Modifier
                                                        .size(147.dp, 83.dp)
                                                        .padding(0.dp)


                                                )//main image
                                        Image(
                                            painter = painterResource(id = courselist2[index].languageimage),
                                            contentDescription = null, modifier = Modifier
                                                .size(147.dp, 83.dp)
                                                .padding(0.dp)
                                        )//main image
//                     Spacer(modifier = Modifier.width(5.dp))
                                                Column() {
                                                    Row(modifier = Modifier.padding(end = 10.dp)) {
//                                        Text(
//                                            text = courselist2[index].languagename,
//                                            style = TextStyle(
//                                                fontSize = 16.sp, color = Color.White,
//                                                fontFamily = FontFamily(Font(R.font.roboto_medium))
//                                            )
//                                        )


//                                        Image(
//                                            painter = painterResource(id = R.drawable.ellipse_187),
//                                            contentDescription = null
//                                        )
//                                    }

                                                        Text(
                                                            text = "Big Boars Caught in Australia caught by dogs",
                                                            style = TextStyle(
                                                                fontSize = 11.sp,
//                                                    color = Color.White,
                                                                fontFamily = FontFamily(Font(R.font.roboto_medium))
                                                            ),
                                                            modifier = Modifier

                                                                .wrapContentWidth()
                                                                .wrapContentHeight(),


                                                            )

                                                        Image(
                                                            painter = painterResource(id = R.drawable.vertical_option),
                                                            contentDescription = null,
                                                            modifier = Modifier
                                                                .size(15.dp, 20.dp),
                                                            Alignment.TopEnd,
                                                            colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground)

                                                        )

                                                    }

                                                    Text(
                                                        text = "44m", color = Color.Gray,
                                                        style = TextStyle(
                                                            fontSize = 10.sp,
                                                            fontFamily = FontFamily(Font(R.font.roboto_regular))
                                                        ), modifier = Modifier
                                                            .fillMaxWidth()
                                                            .wrapContentHeight()
                                                    )
                                                    Row(verticalAlignment = Alignment.Bottom) {


                                                        Spacer(modifier = Modifier.height(7.dp))
                                                        Image(
                                                            painter = painterResource(id = R.drawable.download_ic),
                                                            contentDescription = null,
                                                            modifier = Modifier

                                                                .size(20.dp, 20.dp)
                                                                .padding(start = 7.dp),
                                                            colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground)
//                                        .background(
//                                            Color(android.graphics.Color.parseColor("#1B1B1B")), shape = RoundedCornerShape(15.dp)
//                                        )
                                                        )
                                                        Spacer(modifier = Modifier.height(7.dp))
                                                        Image(
                                                            painter = painterResource(id = R.drawable.savetrailer_ic),
                                                            contentDescription = null,
                                                            modifier = Modifier

                                                                .size(20.dp, 20.dp)
                                                                .padding(start = 7.dp),
//                                        .background(
//                                            Color(android.graphics.Color.parseColor("#1B1B1B")),
//                                        )
                                                            colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground)
                                                        )
                                                    }
                                                }

                                            }//main row
                                            Text(
                                                text = "Join the team in the territory as they head out on\n the flood plains, chasing big boars and bullalo.more...",
                                                maxLines = 2,
                                                style = TextStyle(
                                                    fontSize = 11.sp,
//                                        color = Color.White,
                                                    fontFamily = FontFamily(Font(R.font.roboto_regular))
                                                ), modifier = Modifier
                                                    .padding(start = 8.dp)

                                            )
                                        }
                                    }

                                    Spacer(modifier = Modifier.width(3.dp))
                                }
                            }
                            Spacer(modifier = Modifier.height(5.dp))

                            ClipsListHome()

                            lateinit var courselist4: List<Clist>
                            courselist4 = ArrayList<Clist>()
                            courselist4 =
                                (courselist4 + Clist(
                                    "1.5k",
                                    R.drawable.home_demo2
                                )) as ArrayList<Clist>
                            courselist4 =
                                (courselist4 + Clist(
                                    "Share",
                                    R.drawable.home_demo2
                                )) as ArrayList<Clist>
                            courselist4 =
                                (courselist4 + Clist(
                                    "Download",
                                    R.drawable.home_demo2
                                )) as ArrayList<Clist>
                            var isScrollEnabled by remember { mutableStateOf(false) }

                            Column(
                                modifier = Modifier
                                    .background(color = Color.Gray)
                                    .fillMaxWidth()
                                    .wrapContentHeight(),
                            ) {
                                Spacer(
                                    modifier = Modifier
                                        .height(10.dp)
                                        .background(color = Color.Black)
                                )
                                courselist4.forEach { courselist4 ->
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .wrapContentHeight()
                                    ) {
                                        Image(
                                            painter = painterResource(id = R.drawable.profilepic_ic),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .padding(start = 10.dp, top = 10.dp)
                                                .height(40.dp)
                                                .width(40.dp)
//                                        .weight(0.3f)

                                        )

                                        Column(
                                            modifier = Modifier
                                                .wrapContentWidth()
                                                .wrapContentHeight()
                                                .weight(2f)
                                                .align(Alignment.CenterVertically)
                                        ) {

                                            Text(
                                                "Big Boars Caught in Australia",
                                                style = TextStyle(
                                                    fontSize = 15.sp,
                                                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                                    color = Color.White,
                                                )

                                            )

                                            Text(
                                                "Bradley Owens",

                                                style = TextStyle(
                                                    fontSize = 11.sp,
                                                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                                                    color = Color(
                                                        android.graphics.Color.parseColor(
                                                            "#AAAAAA"
                                                        )
                                                    )
                                                )
                                            )

                                        }
                                        Spacer(modifier = Modifier.height(5.dp))
                                        Text(
                                            "Exclusive",
                                            style = TextStyle(
                                                fontSize = 10.sp,
                                                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                                color = Color.Black,
                                            ), modifier = Modifier
                                                .background(
                                                    color = Color.Yellow,
                                                    shape = RoundedCornerShape(10.dp)
                                                )
                                                .weight(0.5f)
                                                .align(Alignment.CenterVertically)
                                                .wrapContentHeight()
                                                .padding(start = 4.dp, bottom = 5.dp)

                                        )

                                        Image(
                                            painter = painterResource(id = R.drawable.vertical_option),
                                            contentDescription = null, modifier = Modifier
                                                .padding(10.dp)
                                                .height(25.dp)
                                                .weight(0.5f)
                                        )

                                    }
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Image(
                                        painter = painterResource(id = courselist4.languageimage),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .height(220.dp)
                                            .fillMaxWidth()

                                    )
                                    Spacer(modifier = Modifier.height(10.dp))
                                    Row(modifier = Modifier.padding(start = 10.dp)) {
                                        Text(
                                            "SUBSCRIBE",
                                            style = TextStyle(
                                                fontSize = 13.sp,
                                                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                                color = Color.White,
                                            ), modifier = Modifier
                                                .background(
                                                    color = Color.Red,
                                                    shape = RoundedCornerShape(10.dp)
                                                )
                                                .padding(start = 7.dp, end = 7.dp)


                                        )
                                        Spacer(modifier = Modifier.width(10.dp))
                                        Row(
                                            modifier = Modifier
                                                .background(
                                                    Color(android.graphics.Color.parseColor("#1B1B1B")),
                                                    shape = RoundedCornerShape(10.dp)
                                                )
                                                .padding(start = 7.dp, end = 7.dp)
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.like_ic),
                                                contentDescription = null
                                            )
                                            Spacer(modifier = Modifier.width(5.dp))
                                            Text(
                                                text = " 1.5k",
                                                style = TextStyle(
                                                    fontSize = 13.sp, color = Color.White,
                                                    fontFamily = FontFamily(Font(R.font.roboto_regular))
                                                )
                                            )
                                        }
                                        Spacer(modifier = Modifier.width(10.dp))
                                        Row(
                                            modifier = Modifier
                                                .background(
                                                    Color(android.graphics.Color.parseColor("#1B1B1B")),
                                                    shape = RoundedCornerShape(10.dp)
                                                )
                                                .padding(start = 7.dp, end = 7.dp)
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.comment),
                                                contentDescription = null
                                            )
                                            Spacer(modifier = Modifier.width(5.dp))
                                            Text(
                                                text = " 845",
                                                style = TextStyle(
                                                    fontSize = 13.sp, color = Color.White,
                                                    fontFamily = FontFamily(Font(R.font.roboto_regular))
                                                )
                                            )
                                        }
                                        Spacer(modifier = Modifier.width(10.dp))
                                        Row(
                                            modifier = Modifier
                                                .background(
                                                    Color(android.graphics.Color.parseColor("#1B1B1B")),
                                                    shape = RoundedCornerShape(10.dp)
                                                )
                                                .padding(start = 7.dp, end = 7.dp)
                                        ) {
                                            Image(
                                                painter = painterResource(id = R.drawable.share_ic),
                                                contentDescription = null
                                            )
                                            Spacer(modifier = Modifier.width(5.dp))
                                            Text(
                                                text = " Share",
                                                style = TextStyle(
                                                    fontSize = 13.sp, color = Color.White,
                                                    fontFamily = FontFamily(Font(R.font.roboto_regular))
                                                )
                                            )
                                        }

                                    }

                                }

                            }


                        }


                    }
                }
            }
//        Scrollbar(
//            modifier = Modifier.align(Aligm)
//        )

        }
    },
        bottomBar = {
            BottomNavigationWithLabelComponent()
        })

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview15() {
    UhuntTheme {
//        userprofile()
    }
}