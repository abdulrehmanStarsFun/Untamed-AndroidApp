package com.example.uhunt.jet


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.icu.text.Transliterator.Position
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.widget.ToggleButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Face
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.Observer
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.uhunt.Clist
import com.example.uhunt.R
import com.example.uhunt.SharedPref.Utilities
import com.example.uhunt.jet.ui.theme.UhuntTheme
import com.example.uhunt.jetpackClassess.DemoDataProvider.item
import com.example.uhunt.jetpackClassess.global.getTimeAgo
import com.example.uhunt.models.GetVideoDetailResponse
import com.example.uhunt.models.SuggestedVideoX
import com.example.uhunt.viewmodel.SignUpViewModel
import com.example.uhunt.viewmodel.VideoDetailModel
import com.google.accompanist.coil.rememberCoilPainter
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.material.checkbox.MaterialCheckBox.CheckedState

class VideoProfileScreen : ComponentActivity() {
    private val viewModel: VideoDetailModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            com.example.uhunt.jet.theme.UhuntTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                ) {
                    nestscroll(viewModel)
                }
            }




        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun nestscroll(viewModel: VideoDetailModel) {

//    val scrollState = rememberScrollState()
    var videoUrl by rememberSaveable { mutableStateOf(value = "") }
    var titleText by rememberSaveable { mutableStateOf(value = "") }
    var date by rememberSaveable { mutableStateOf(value = 0L) }
    var totalViews by rememberSaveable { mutableStateOf(value = "") }
    var profilepic by rememberSaveable { mutableStateOf(value = "") }
    var username by rememberSaveable { mutableStateOf(value = "") }
    var likes by rememberSaveable { mutableStateOf(value = "") }
    var description by rememberSaveable { mutableStateOf(value = "") }
    var subscribe_count by rememberSaveable { mutableStateOf(value = "") }
    var suggestedVideoist by rememberSaveable { mutableStateOf(listOf<SuggestedVideoX>()) }

    var clicked by remember { mutableStateOf(false) }
    var rowclick by remember { mutableStateOf(false) }
    var rowclick1 by remember { mutableStateOf(false) }
    var rowclick2 by remember { mutableStateOf(false) }
    var rowclick3 by remember { mutableStateOf(false) }
    var rowclick4 by remember { mutableStateOf(false) }
    var showMore by remember { mutableStateOf(false) }
    var showMore1 by remember { mutableStateOf(false) }
    val text =
        "Jesse heads to the northern territory to catch some bigboars. The bailers step up and manage to bail up good boars all night Lets join the team and see some of the exciting action they captu  A computer science portal for geeks. It contains well written, well thought and well explained computer science and programming articles, quizzes and practice/competitive programming/company interview Questions."

//    val col = if (isToggled) Color.Red else Color.Green
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    viewModel.videoDetails.observe(lifecycleOwner, Observer { videoDetails ->
        if (videoDetails != null) {
            // Access the videoDetails and handle the success response
            videoUrl = videoDetails.data.hls_url
            titleText = videoDetails.data.title
            description = videoDetails.data.description
            date = videoDetails.data.time
            totalViews = videoDetails.data.views.toString()
            profilepic = videoDetails.data.owner.avatar
            username = videoDetails.data.owner.username
            subscribe_count = videoDetails.data.owner.subscribe_count
            likes = videoDetails.data.likes.toString()
            suggestedVideoist = videoDetails.data.suggested_videos

//            Utilities.showToast(context, "" + videoDetails.api_status)
        } else {
            // Handle loading or error state
            // You can show a loading indicator or error message here
        }
//        handleSuccessResponse(context, videoDetails)
    })

    // Call the fetchVideoDetails function to trigger the API request
    val userId = "29699"
    val videoId = "JTpHOXMnoMiv9YS"
    viewModel.fetchVideoDetails(userId, videoId)
    val currentActivity = remember {
        context as? Activity
    }
    Column(modifier = Modifier.background(colors.background))
    {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(230.dp)
//              .background(Color(android.graphics.Color.parseColor("#1B1B1B")))
        ) {

            VideoPlayerView(context, videoUrl)

            Icon(
                painter = painterResource(id = R.drawable.back_arrow) ,
                contentDescription = null,
                tint= Color.White,
                modifier = Modifier
                    .padding(top = 10.dp, start = 10.dp)
                    .size(20.dp)
                    .clickable {
                        currentActivity?.finish()
                    }
                )
        }

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .background(MaterialTheme.colors.background)
        )
        {


            Text(
                titleText,
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 16.sp,
//                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.roboto_medium))
                ), modifier = Modifier.padding(start = 10.dp, end = 5.dp)
            )
            val timeAgo = getTimeAgo(date)
            val totalViewss = totalViews + " Views " + timeAgo.toString()
            Text(
                totalViewss,
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 10.sp,
//                    color = Color.Gray,
                    fontFamily = FontFamily(Font(R.font.opensans_variable))
                ), modifier = Modifier.padding(start = 10.dp, end = 5.dp)
            )

            Box() {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    Text(
                        "Description:",
                        style = TextStyle(
                            fontSize = 12.sp, fontFamily = FontFamily(Font(R.font.roboto_bold)),
//                            color = Color.White,
                        ), modifier = Modifier.padding(start = 10.dp, end = 5.dp)
                    )

                    Column(modifier = Modifier
                        .animateContentSize(animationSpec = tween(100))
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = null
                        ) { showMore = !showMore }) {


                        if (showMore) {
                            Text(
                                text = description,
                                style = TextStyle(
                                    fontSize = 11.sp,
                                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
//                            color = Color.White
                                ), modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                            )
                        } else {
                            Text(
                                text = description,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis,
                                style = TextStyle(
                                    fontSize = 11.sp,
                                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
//                            color = Color.White
                                ),
                                modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                            )
                        }
                    }
                }

            }



            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Image(
                    painter = rememberCoilPainter(
                        request = profilepic,
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 10.dp, top = 10.dp)
                        .size(40.dp)
                        .clip(CircleShape)
                        .clickable {
                            val intent = Intent(context, user_profile::class.java)
                            context.startActivity(intent)
                        }
                        .border(
                            1.dp,
                            Color.Black,
                            CircleShape
                        ) // Add this line to add a border around the image
                )


                Column(
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()
                        .weight(4f)
                        .padding(start = 10.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .wrapContentHeight()
                            .wrapContentWidth()
                            .padding(top = 5.dp)
                    ) {
                        Text(
                            username,
                            modifier = Modifier.weight(7f),
                            style = androidx.compose.ui.text.TextStyle(
                                fontSize = 13.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                // color = Color.White,
                            ),

                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )

                        Text(
                            subscribe_count,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.opensans_variable)),
                                color = Color(android.graphics.Color.parseColor("#AAAAAA")),
                            ),
                            modifier = Modifier
                                .padding(start = 5.dp)
                                .weight(1f)
                        )

                    }

                    Text(
                        "Grunter Hunter Championships",

                        style = androidx.compose.ui.text.TextStyle(
                            fontSize = 11.sp, fontFamily = FontFamily(Font(R.font.roboto_regular)),
                            color = Color(android.graphics.Color.parseColor("#AAAAAA"))
                        ),
                        maxLines = 1,
                    )

                }

                Row(
                    modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                        .weight(3.5f)
                        .padding(horizontal = 10.dp)
                        .align(Alignment.CenterVertically)
                ) {

                    Button(
                        onClick = { /*TODO*/

                            Toast.makeText(context, "Successfully Subscribed", Toast.LENGTH_LONG)
                                .show()

                        },

                        modifier = Modifier,
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Red,
//                            contentColor = Color.White,
                        ),
                    ) {
                        Text(
                            "SUBSCRIBE",

                            style = TextStyle(
                                fontSize = 10.sp, fontFamily = FontFamily(Font(R.font.roboto_bold)),
                                color = Color.White

                            ),
//                        modifier = Modifier.padding(bottom = 0.dp)
                        )
                    }
                    IconButton(onClick = { clicked = !clicked }) {
                        Icon(
                            painterResource(id = R.drawable.bell),
                            contentDescription = null, modifier = Modifier
                                .height(25.dp)
                                .width(25.dp)
                                .padding(start = 5.dp),
                            tint = if (clicked) Color.Red else  MaterialTheme.colors.onBackground
                        )
                    }
                }

            }

Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .horizontalScroll(rememberScrollState())
            ) {


                Spacer(modifier = Modifier.width(5.dp))
                Button(
                    onClick = { rowclick = !rowclick },
                    modifier = Modifier
                        .height(30.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.background

                    ),
                ) {
                    Row {

//                        IconButton(onClick = { rowclick = !rowclick }) {

                            Icon(
                                painterResource(id = R.drawable.like_ic),
                                contentDescription = null,
                                tint = if (rowclick) {
                                    Color.Blue
                                } else Color.Gray
                            )
//                        }
                        Spacer(modifier = Modifier.width(6.dp))
                        androidx.compose.material.Text(
                            text = likes,
                            style = TextStyle(
                                fontSize = 10.sp,
//                                  color = Color.White,
                            )
                        )

                    }
                }
                Spacer(modifier = Modifier.width(5.dp))
                Button(
                    onClick = { rowclick1 = !rowclick1 },
                    modifier = Modifier
                        .height(30.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.background

                    ),
                ) {
                    Row {

//                        IconButton(onClick = { rowclick1 = !rowclick1 }) {

                            Icon(
                                painterResource(id = R.drawable.share_ic),
                                contentDescription = null,
                                tint = if (rowclick1) {
                                    Color.Blue
                                } else Color.Gray
                            )
//                        }
                        Spacer(modifier = Modifier.width(6.dp))
                        androidx.compose.material.Text(
                            text = "share",
                            style = TextStyle(
                                fontSize = 10.sp,
//                                  color = Color.White,
                            )
                        )

                    }
                }
                Spacer(modifier = Modifier.width(5.dp))
                Button(
                    onClick = { rowclick2 = !rowclick2 },
                    modifier = Modifier
                        .height(30.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.background

                    ),
                ) {
                    Row {

//                        IconButton(onClick = { rowclick2 = !rowclick2 }) {

                            Icon(
                                painterResource(id = R.drawable.download_ic),
                                contentDescription = null,
                                tint = if (rowclick2) {
                                    Color.Blue
                                } else Color.Gray
                            )
//                        }
                        Spacer(modifier = Modifier.width(6.dp))
                        androidx.compose.material.Text(
                            text = "Download",
                            style = TextStyle(
                                fontSize = 10.sp,
//                                  color = Color.White,
                            )
                        )

                    }
                }
                Spacer(modifier = Modifier.width(5.dp))
                Button(
                    onClick = { rowclick3 = !rowclick3 },
                    modifier = Modifier
                        .height(30.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.background

                    ),
                ) {
                    Row {

//                        IconButton(onClick = { rowclick3 = !rowclick3 }) {

                            Icon(
                                painterResource(id = R.drawable.savetrailer_ic),
                                contentDescription = null,
                                tint = if (rowclick3) {
                                    Color.Blue
                                } else Color.Gray
                            )
//                        }
                        Spacer(modifier = Modifier.width(6.dp))
                        androidx.compose.material.Text(
                            text = "Save",
                            style = TextStyle(
                                fontSize = 10.sp,
//                                  color = Color.White,
                            )
                        )

                    }
                }
                Spacer(modifier = Modifier.width(5.dp))
                Button(
                    onClick = { rowclick4 = !rowclick4 },
                    modifier = Modifier
                        .height(30.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.background

                    ),
                ) {
                    Row {

//                        IconButton(onClick = { rowclick4 = !rowclick4 }) {

                            Icon(
                                painterResource(id = R.drawable.savetrailer_ic),
                                contentDescription = null,
                                tint = if (rowclick4) {
                                    Color.Blue
                                } else Color.Gray
                            )
//                        }
                        Spacer(modifier = Modifier.width(6.dp))
                        androidx.compose.material.Text(
                            text = "Trailer",
                            style = TextStyle(
                                fontSize = 10.sp,
//                                  color = Color.White,
                            )
                        )

                    }
                }
                Spacer(modifier = Modifier.width(5.dp))

            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
            ) {

                androidx.compose.material.Text(
                    text = "Comments",
                    style = TextStyle(
                        fontSize = 15.sp,
//                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.roboto_bold))
                    ), modifier = Modifier
                        .padding(start = 10.dp)
                        .width(77.dp)
                        .height(20.dp)
                )

                androidx.compose.material.Text(
                    text = ".60",
                    style = TextStyle(
                        fontSize = 13.sp,
                        color = Color(android.graphics.Color.parseColor("#AAAAAA")),
                        fontFamily = FontFamily(Font(R.font.roboto_regular))
                    ), modifier = Modifier
                        .padding(start = 8.dp)
                        .width(14.dp)
                        .height(17.dp)
                )

            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()

//                  .background(Color(android.graphics.Color.parseColor("#1B1B1B")))
            ) {
                Row(
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()
                        .padding(6.dp),
                    verticalAlignment = Alignment.CenterVertically

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.profilepic_ic),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 5.dp)
                            .height(24.dp)
                            .width(24.dp)
                            .offset(x = 4.dp, y = 2.dp)
                            .weight(0.5f)

                    )


                    androidx.compose.material.Text(
                        "Bradley Owens.",
                        style = TextStyle(
                            fontSize = 11.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_bold)),
//                          color = Color.White,
                        ), modifier = Modifier
                            .offset(x = 3.dp, y = 4.dp)
                            .weight(2.5f)
                            .padding(horizontal = 6.dp)

                    )


                    androidx.compose.material.Text(
                        "2hr",
                        style = TextStyle(
                            fontSize = 9.sp,
                            fontFamily = FontFamily(Font(R.font.opensans_bold)),
                            color = Color(android.graphics.Color.parseColor("#A2A2A2")),
                        ), modifier = Modifier
                            .offset(x = 4.dp, y = 2.dp)
                            .weight(3f)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(6.dp)
                            .weight(1f)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.option_ic),
                            contentDescription = null,
                            //modifier = HorizontalAlignment=Alignment.TopEnd
                            modifier = Modifier.offset(x = 40.dp, y = 4.dp),
                            colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground)

                        )
                    }

                }

                Column(modifier = Modifier
                    .animateContentSize(animationSpec = tween(100))
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null
                    ) { showMore1 = !showMore1 }) {


                    if (showMore1) {

                        androidx.compose.material.Text(
                            text = text,
                            style = TextStyle(
                                fontSize = 10.sp,
                                fontFamily = FontFamily(Font(R.font.opensans_bold)),
//                      color = Color.White,
                            ),
                            modifier = Modifier.padding(horizontal = 6.dp)

                        )
                    } else {
                        Text(
                            text = text,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            style = TextStyle(
                                fontSize = 10.sp,
                                fontFamily = FontFamily(Font(R.font.opensans_bold)),
//                      color = Color.White,
                            ),
                            modifier = Modifier.padding(horizontal = 6.dp)
                        )
                    }
                }

                androidx.compose.material.Text(
                    "See All Comments",
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
//                      color = Color.White,
                    ), modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(vertical = 6.dp)
                )
            }

            Row(modifier = Modifier.padding(10.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.profilepic_ic),
                    contentDescription = null,
                    modifier = Modifier

                        .height(40.dp)
                        .width(40.dp)

                )

                Box(
                    modifier = Modifier
                        .height(50.dp)
                        .padding(start = 10.dp)
//                      .background(
//                          Color(android.graphics.Color.parseColor("#1B1B1B")),
//                          shape = RoundedCornerShape(10.dp)
//                      )
                ) {
                    var text by rememberSaveable { mutableStateOf("") }
                    TextField(
                        value = text, onValueChange = { text = it },
                        label = {
                            androidx.compose.material.Text(
                                text = "Write a comment ...", style = TextStyle(
                                    fontSize = 15.sp,
//                          color = Color.White,
                                    fontFamily = FontFamily(Font(R.font.roboto_bold))
                                ), modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 20.dp)


                            )
                        }, modifier = Modifier.background(MaterialTheme.colors.background)
                    )

//
                }


            }


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(horizontal = 10.dp)
            ) {
                suggestedVideoist.forEach { suggestedVideoist ->


                    Column(modifier = Modifier.wrapContentHeight()) {


                        Row(

                        ) {
                            Image(
                                painter = rememberCoilPainter(
                                    request = suggestedVideoist.thumbnail,
                                ),
                                contentDescription = null,contentScale = ContentScale.Crop, modifier = Modifier
                                    .size(147.dp, 83.dp)
                                    .padding(end = 0.dp)
                                    .weight(3f)
                                    .align(Alignment.CenterVertically)
                            )
//                     Spacer(modifier = Modifier.width(5.dp))
                            Column(modifier = Modifier
                                .weight(6f)
                                .align(Alignment.CenterVertically)) {
                                Row(
                                    modifier = Modifier
                                        .padding(end = 10.dp)
//                                        .align(Alignment.CenterHorizontally)
                                ) {
//                                        Text(
//                                            text = courselist2[index].languagename,
//                                            style = TextStyle(
//                                                fontSize = 16.sp, color = Color.White,
//                                                fontFamily = FontFamily(Font(R.font.roboto_medium))
//                                            )
//                                        )
                                    Spacer(modifier = Modifier.width(10.dp))

//                                        Image(
//                                            painter = painterResource(id = R.drawable.ellipse_187),
//                                            contentDescription = null
//                                        )
//                                    }
Column() {
    Text(
        text = suggestedVideoist.title,
        style = TextStyle(
            fontSize = 11.sp,
//                                                color = Color.White,
            fontFamily = FontFamily(Font(R.font.roboto_medium))
        ), modifier = Modifier
            .padding(top = 8.dp)
            .wrapContentWidth()
            .wrapContentHeight()

    )

    Text(
        text ="44m",
        style = TextStyle(
            fontSize = 10.sp,
            color = Color.Gray,
            fontFamily = FontFamily(Font(R.font.roboto_regular))
        ), modifier = Modifier
            .padding(top = 5.dp)
            .wrapContentWidth()
            .wrapContentHeight()

    )
}
                                }

                            }
                            Column(modifier = Modifier
                                .weight(1f)
                                .padding(top = 6.dp)) {

                                var rowclick6 by remember { mutableStateOf(false) }


                                Image(
                                    painter = painterResource(id = R.drawable.vertical_option),
                                    contentDescription = null, modifier = Modifier
                                        .size(15.dp, 15.dp)
                                        .clickable {

                                            rowclick6 = !rowclick6
                                        },
                                    colorFilter = ColorFilter.tint(color = if (rowclick6) {
                                        Color.Blue
                                    } else MaterialTheme.colors.onBackground)

                                )
                                Spacer(modifier = Modifier.height(7.dp))
//                                Image(
//                                    painter = painterResource(id = R.drawable.download_ic),
//                                    contentDescription = null, modifier = Modifier
//
//                                        .size(15.dp, 15.dp).clickable {
//
//                                        },
//                                    colorFilter = ColorFilter.tint(color = Color.Black)
//                                )
                                var rowclick7 by remember { mutableStateOf(false) }

                                Image(
                                    painter = painterResource(id = R.drawable.download_ic),
                                    contentDescription = null, modifier = Modifier
                                        .size(15.dp, 15.dp)
                                        .clickable {

                                            rowclick7 = !rowclick7
                                        },
                                    colorFilter = ColorFilter.tint(color = if (rowclick7) {
                                        Color.Blue
                                    } else MaterialTheme.colors.onBackground)

                                )
                                Spacer(modifier = Modifier.height(7.dp))

                                var rowclick8 by remember { mutableStateOf(false) }

                                Image(
                                    painter = painterResource(id = R.drawable.savetrailer_ic),
                                    contentDescription = null, modifier = Modifier
                                        .size(15.dp, 15.dp)
                                        .clickable {

                                            rowclick8 = !rowclick8
                                        },
                                    colorFilter = ColorFilter.tint(color = if (rowclick8) {
                                        Color.Blue
                                    } else MaterialTheme.colors.onBackground)

                                )
                            }
                        }
                        Text(
                            text = suggestedVideoist.description,
                            style = TextStyle(
                                fontSize = 11.sp,
//                                    color = Color.White,
                                fontFamily = FontFamily(Font(R.font.roboto_regular))
                            ), modifier = Modifier
                                .padding(start = 8.dp)
                                .wrapContentWidth(),
                            maxLines = 3
                        )

                        Spacer(modifier = Modifier.height(15.dp)
                          )
                    }


                }//list5,,,,,,,,,,,,,,,,,,

            }

        }


    }


}

private fun handleSuccessResponse(context: Context, videoDetails: GetVideoDetailResponse?) {
    if (videoDetails != null) {
        // Access the videoDetails and handle the success response
        val videoUrl = videoDetails.data.toString()
        Utilities.showToast(context, "" + videoDetails.api_status)
    } else {
        // Handle loading or error state
        // You can show a loading indicator or error message here
    }
}

@Composable
fun VideoPlayerView(context: Context, videoUrl: String) {
    val player = remember {
        SimpleExoPlayer.Builder(context).build()
    }

    LaunchedEffect(videoUrl) {
        val mediaItem = MediaItem.fromUri(videoUrl)
        player.setMediaItem(mediaItem)
        player.prepare()
        player.playWhenReady = true
    }

    DisposableEffect(player) {
        onDispose {
            player.release()
        }
    }

    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(16f / 9), // Adjust aspect ratio as needed
        factory = { context ->
            val playerView = PlayerView(context).apply {
                this.player = player
            }
            playerView
        }
    )
    
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UhuntTheme {
//        nestscroll()
    }

}

