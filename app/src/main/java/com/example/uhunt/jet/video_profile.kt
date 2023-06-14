package com.example.uhunt.jet

import android.os.Bundle

import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState


import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.*

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.uhunt.Clist
import com.example.uhunt.R
import com.example.uhunt.jet.theme.UhuntTheme
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer

import com.google.android.exoplayer2.ui.PlayerView

class video_profile : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UhuntTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),

                    ) {
                    videoprofile()

                }
            }
        }
    }
}

@Composable
fun videoprofile() {
    val scrollState = rememberScrollState()

    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(MaterialTheme.colors.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(230.dp)
                    .background(Color(android.graphics.Color.parseColor("#1B1B1B")))
            ) {
                AndroidView(

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(230.dp), factory = {
                        val player = SimpleExoPlayer.Builder(it).build()
                        val mediaItem =
                            MediaItem.fromUri("android.resource://" + context + "/" + R.raw.exovideo)
                        player.setMediaItem(mediaItem)
                        player.prepare()
                        player.playWhenReady = true
                        val playerView = PlayerView(it)
                        playerView.player = player
                        playerView
                    })//video player
            }//video box


            SetTextStyling(
                "Big Boars Caught in Australia - Hogs downunder\n" +
                        "hunting, fishing",
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 16.sp,
//                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.roboto_medium))
                )
            )

            SetTextStyling(
                "10K views 16 days ago",
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 10.sp,
//                    color = Color.Gray,
                    fontFamily = FontFamily(Font(R.font.opensans_variable))
                )
            )
            Box() {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    SetTextStyling(
                        "Description:",
                        style = androidx.compose.ui.text.TextStyle(
                            fontSize = 12.sp, fontFamily = FontFamily(Font(R.font.roboto_bold)),
//                            color = Color.White,
                        )
                    )


                    SetTextStyling(
                        "Jesse heads to the northern territory to catch some bigboars. The bailers step up and manage to bail up good boars all night\n" +
                                "Lets join the team and see some of the exciting action they captu ...more",
                        style = androidx.compose.ui.text.TextStyle(
                            fontSize = 11.sp, fontFamily = FontFamily(Font(R.font.roboto_regular)),
//                            color = Color.White
                        )
                    )

                }

            }


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

                )

                Column(
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()
                ) {
                    Row(
                        modifier = Modifier
                            .wrapContentHeight()
                            .wrapContentWidth()
                            .padding(top = 8.dp)
                    ) {
                        SetTextStyling(
                            "Bradley Owens",
                            style = androidx.compose.ui.text.TextStyle(
                                fontSize = 15.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_medium)),
//                                color = Color.White,
                            )

                        )
                        SetTextStyling(
                            ".1K",

                            style = androidx.compose.ui.text.TextStyle(
                                fontSize = 14.sp,
                                fontFamily = FontFamily(Font(R.font.opensans_variable)),
                                color = Color(android.graphics.Color.parseColor("#AAAAAA")),
                            ),
                        )

                    }

                    SetTextStyling(
                        "Grunter Hunter Championships",

                        style = androidx.compose.ui.text.TextStyle(
                            fontSize = 11.sp, fontFamily = FontFamily(Font(R.font.roboto_regular)),
                            color = Color(android.graphics.Color.parseColor("#AAAAAA"))
                        )
                    )

                }

                Row(
                    modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                        .padding(top = 17.dp, start = 25.dp)
                ) {

                    Button(
                        onClick = { /*TODO*/

                            Toast.makeText(context, "Successfully Subscribed", Toast.LENGTH_LONG)
                                .show()

                        },

                        modifier = Modifier
                            .width(110.dp)
                            .height(32.dp),
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Red,
//                            contentColor = Color.White,
                        ),
                    ) {
                        Text(
                            "SUBSCRIBE",

                            style = androidx.compose.ui.text.TextStyle(
                                fontSize = 11.sp, fontFamily = FontFamily(Font(R.font.roboto_bold)),
//                                color = Color.White

                            ), modifier = Modifier.padding(bottom = 0.dp)
                        )
                    }

                    Image(
                        painter = painterResource(id = R.drawable.bell_ic),
                        contentDescription = null,
                        modifier = Modifier
                            .height(24.dp)
                            .padding(start = 15.dp, top = 3.dp)
                    )
                }

            }

            lateinit var courselist: List<Clist>
            courselist = ArrayList<Clist>()
            courselist = (courselist + Clist("1.5k", R.drawable.like_ic)) as ArrayList<Clist>
            courselist = (courselist + Clist("Share", R.drawable.share_ic)) as ArrayList<Clist>
            courselist =
                (courselist + Clist("Download", R.drawable.download_ic)) as ArrayList<Clist>
            courselist = (courselist + Clist("Save", R.drawable.savetrailer_ic)) as ArrayList<Clist>
            courselist =
                (courselist + Clist("Trailer", R.drawable.savetrailer_ic)) as ArrayList<Clist>


            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                itemsIndexed(courselist) { index, item ->

                    Button(
                        onClick = {},
                        modifier = Modifier
                            .padding(8.dp),
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color(android.graphics.Color.parseColor("#1B1B1B")),
//                            contentColor = Color.White,
                        ),
                    ) {
                        Row {
                            Image(
                                painter = painterResource(id = courselist[index].languageimage),
                                contentDescription = null
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = courselist[index].languagename,
                                style = androidx.compose.ui.text.TextStyle(
                                    fontSize = 13.sp,
                                    color = Color.White,
                                    fontFamily = FontFamily(Font(R.font.roboto_regular))
                                )
                            )
                        }
                    }

                }
            }

            Row(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
            ) {

                Text(
                    text = "Comments",
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 15.sp,
//                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.roboto_bold))
                    ), modifier = Modifier
                        .padding(start = 10.dp)
                        .width(77.dp)
                        .height(20.dp)
                )

                Text(
                    text = ".60",
                    style = androidx.compose.ui.text.TextStyle(
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

                    .background(Color(android.graphics.Color.parseColor("#1B1B1B")))
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


                    Text(
                        "Bradley Owens.",
                        style = androidx.compose.ui.text.TextStyle(
                            fontSize = 11.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_bold)),
                            color = Color.White,
                        ), modifier = Modifier
                            .offset(x = 3.dp, y = 4.dp)
                            .weight(2.5f)
                            .padding(horizontal = 6.dp)

                    )


                    Text(
                        "2hr",
                        style = androidx.compose.ui.text.TextStyle(
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
                            modifier = Modifier.offset(x = 40.dp, y = 4.dp)
                        )
                    }

                }

                Text(
                    "Awesome Video love the work. Can you please let me know how\n" +
                            "you do your projects this way ...more",
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(R.font.opensans_bold)),
                        color = Color.White,
                    ),
                    modifier = Modifier.padding(horizontal = 6.dp)

                )

                Text(
                    "See All Comments",
                    style = androidx.compose.ui.text.TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_medium)),
                        color = Color.White,
                    ), modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(vertical = 6.dp)
                )
            }
//            Spacer(modifier = Modifier.height(8.dp))

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
                        .background(
                            Color(android.graphics.Color.parseColor("#1B1B1B")),
                            shape = RoundedCornerShape(10.dp)
                        )
                ) {
                    Text(
                        text = "Write a comment ...", style = androidx.compose.ui.text.TextStyle(
                            fontSize = 15.sp,
                            color = Color.White,
                            fontFamily = FontFamily(Font(R.font.roboto_bold))
                        ), modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, top = 10.dp)


                    )
//
                }


            }


            lateinit var courselist2: List<Clist>
            courselist2 = ArrayList<Clist>()
            courselist2 =
                (courselist2 + Clist("Jesse Farr", R.drawable.video_thumbnail)) as ArrayList<Clist>
            courselist2 =
                (courselist2 + Clist("Joey Sir", R.drawable.video_thumbnail)) as ArrayList<Clist>
            courselist2 = (courselist2 + Clist(
                "Matt Sandford",
                R.drawable.video_thumbnail
            )) as ArrayList<Clist>
            courselist2 = (courselist2 + Clist(
                "Sally Richards",
                R.drawable.video_thumbnail
            )) as ArrayList<Clist>
            courselist2 =
                (courselist2 + Clist("Joey Sir", R.drawable.video_thumbnail)) as ArrayList<Clist>
            courselist2 = (courselist2 + Clist(
                "Kevin Scotch",
                R.drawable.video_thumbnail
            )) as ArrayList<Clist>
            courselist2 =
                (courselist2 + Clist("Sam Bensan", R.drawable.video_thumbnail)) as ArrayList<Clist>
            courselist2 =
                (courselist2 + Clist("Joey Sir", R.drawable.video_thumbnail)) as ArrayList<Clist>


            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                itemsIndexed(courselist2) { index, item ->

                    Button(
                        onClick = {},
                        modifier = Modifier
                            .padding(8.dp),
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Black,
//                            contentColor = Color.White,
                        ),
                    ) {
                        Column(modifier = Modifier.wrapContentHeight()) {


                            Row(

                            ) {
                                Image(
                                    painter = painterResource(id = courselist2[index].languageimage),
                                    contentDescription = null, modifier = Modifier
                                        .size(147.dp, 83.dp)
                                        .padding(end = 0.dp)
                                        .weight(2f)
                                )
//                     Spacer(modifier = Modifier.width(5.dp))
                                Column(modifier = Modifier.weight(4f)) {
                                    Row(
                                        modifier = Modifier
                                            .padding(end = 10.dp)
                                            .align(Alignment.CenterHorizontally)
                                    ) {
//                                        Text(
//                                            text = courselist2[index].languagename,
//                                            style = TextStyle(
//                                                fontSize = 16.sp, color = Color.White,
//                                                fontFamily = FontFamily(Font(R.font.roboto_medium))
//                                            )
//                                        )
                                        Spacer(modifier = Modifier.width(20.dp))

//                                        Image(
//                                            painter = painterResource(id = R.drawable.ellipse_187),
//                                            contentDescription = null
//                                        )
//                                    }

                                        Text(
                                            text = "Big Boars Caught in Australia caught by dogs",
                                            style = TextStyle(
                                                fontSize = 11.sp,
//                                                color = Color.White,
                                                fontFamily = FontFamily(Font(R.font.roboto_medium))
                                            ), modifier = Modifier
                                                .padding(top = 8.dp)
                                                .wrapContentWidth()
                                                .wrapContentHeight()
//                                                .align(Alignment.CenterVertically)
                                        )

                                    }


                                }
                                Column() {

                                    Image(
                                        painter = painterResource(id = R.drawable.vertical_option),
                                        contentDescription = null, modifier = Modifier
                                            .size(15.dp, 20.dp)

                                    )
                                    Spacer(modifier = Modifier.height(7.dp))
                                    Image(
                                        painter = painterResource(id = R.drawable.download_ic),
                                        contentDescription = null, modifier = Modifier

                                            .size(20.dp, 20.dp)

//                                        .background(
//                                            Color(android.graphics.Color.parseColor("#1B1B1B")), shape = RoundedCornerShape(15.dp)
//                                        )
                                    )
                                    Spacer(modifier = Modifier.height(7.dp))
                                    Image(
                                        painter = painterResource(id = R.drawable.savetrailer_ic),
                                        contentDescription = null, modifier = Modifier

                                            .size(20.dp, 20.dp)
//                                        .background(
//                                            Color(android.graphics.Color.parseColor("#1B1B1B")),
//                                        )
                                    )
                                }
                            }
                            Text(
                                text = "Join the team in the territory as they head out on the flood plains, chasing big boars and bullalo. more...",
                                style = TextStyle(
                                    fontSize = 11.sp,
//                                    color = Color.White,
                                    fontFamily = FontFamily(Font(R.font.roboto_regular))
                                ), modifier = Modifier
                                    .padding(start = 8.dp)
                                    .wrapContentWidth()
                            )
                        }

                    }
                }//list5
            }


        }

    }

}

//for preview
@Preview(showBackground = true)
@Composable
fun DefaultPreview7() {
    UhuntTheme {
        videoprofile()
    }
}