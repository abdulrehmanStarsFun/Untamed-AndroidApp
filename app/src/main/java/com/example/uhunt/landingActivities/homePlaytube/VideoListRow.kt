package com.example.uhunt.landingActivities.homePlaytube

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uhunt.Clist
import com.example.uhunt.R
import com.example.uhunt.jetpackClassess.DemoDataProvider
import com.example.uhunt.jetpackClassess.RowItems.ClipRowItems


@Composable
fun VideoListRow() {
    val list = remember { DemoDataProvider.itemList }
    val profiles = remember { DemoDataProvider.tweetList }
    Box(modifier = Modifier
        .wrapContentHeight()
        .fillMaxWidth()
    ) {
        lateinit var courselist4: List<Clist>
        courselist4 = ArrayList<Clist>()
        courselist4 =
            (courselist4 + Clist("1.5k", R.drawable.home_demo2)) as ArrayList<Clist>
        courselist4 =
            (courselist4 + Clist("Share", R.drawable.home_demo2)) as ArrayList<Clist>
        courselist4 =
            (courselist4 + Clist("Download", R.drawable.home_demo2)) as ArrayList<Clist>
        var isScrollEnabled by remember { mutableStateOf(false) }
        if (isScrollEnabled) {
            LazyColumn(
                modifier = Modifier
                    .background(color = Color.Gray)
                    .fillMaxWidth()
                    .wrapContentHeight(),
            ) {
                itemsIndexed(courselist4) { index, item ->
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
                                .weight(0.3f)

                        )

                        Column(
                            modifier = Modifier
                                .wrapContentWidth()
                                .wrapContentHeight()
                                .weight(2f)
                        ) {

                            com.example.uhunt.jet.SetTextStyling(
                                "Big Boars Caught in Australia",
                                style = TextStyle(
                                    fontSize = 15.sp,
                                    fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                    color = Color.White,
                                )

                            )

                            com.example.uhunt.jet.SetTextStyling(
                                "Bradley Owens",

                                style = TextStyle(
                                    fontSize = 11.sp,
                                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                                    color = Color(android.graphics.Color.parseColor("#AAAAAA"))
                                )
                            )

                        }
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            "Exclusive",
                            style = TextStyle(
                                fontSize = 13.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                color = Color.Black,
                            ), modifier = Modifier
                                .background(
                                    color = Color.Yellow,
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .weight(0.5f)
                                .padding(top = 7.dp)

                        )

                        Image(
                            painter = painterResource(id = R.drawable.vertical_option),
                            contentDescription = null, modifier = Modifier
                                .padding(10.dp)
                                .weight(0.5f)
                        )

                    }

                    Image(
                        painter = painterResource(id = courselist4[index].languageimage),
                        contentDescription = null,
                        modifier = Modifier.height(220.dp)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Row() {
                        Text(
                            "SUBSCRIBE",
                            style = TextStyle(
                                fontSize = 15.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                                color = Color.Black,
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