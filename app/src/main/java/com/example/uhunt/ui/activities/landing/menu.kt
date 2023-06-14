package com.example.uhunt.ui.activities.landing

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape


import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*

import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uhunt.Clist
import com.example.uhunt.R
import com.example.uhunt.jet.Setting_Screen
import com.example.uhunt.jet.massenger

import com.example.uhunt.jet.user_profile
import com.example.uhunt.landingActivities.homePlaytube.BottomNavigationWithLabelComponent
import com.example.uhunt.ui.activities.landing.ui.theme.UhuntTheme

class menu : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UhuntTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
menus()
                }
            }
        }
    }
}

@Composable
fun menus() {

    val context= LocalContext.current

    Scaffold (  content = {
        Box(modifier = Modifier.padding(it)) {
Column(
    modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 8.dp)
) {
    Spacer(modifier = Modifier.height(20.dp))
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier.padding(start = 10.dp,end=10.dp)
//                .padding(horizontal = 10.dp).weight(1f),
//            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(modifier = Modifier.weight(2f)) {
                Row() {
                    Text(
                        "Uhunt",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = FontFamily(Font(R.font.opensans_bold))
                        ), modifier = Modifier
                    )
                    Spacer(modifier = Modifier.width(15.dp))

                    Image(
                        painter = painterResource(id = R.drawable.helpchat),
                        contentDescription = null,
                        modifier = Modifier
                            .size(25.dp, 25.dp)
                            .align(Alignment.CenterVertically)



                    )
                }
            }



            Box(modifier = Modifier.weight(1.2f)) {

                Row() {


                    Image(
                        painter = painterResource(id = R.drawable.chromecast_icon),
                        contentDescription = null,
                        modifier = Modifier.size(22.dp, 22.dp)


                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Image(
                        painter = painterResource(id = R.drawable.gray_cart),
                        contentDescription = null,
                        modifier = Modifier

                            .size(25.dp, 25.dp)


                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Image(
                        painter = painterResource(id = R.drawable.bell_gray),
                        contentDescription = null,
                        modifier = Modifier

                            .size(22.dp, 22.dp),

                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Image(
                        painter = painterResource(id = R.drawable.helpchat),
                        contentDescription = null,
                        modifier = Modifier

                            .size(25.dp, 25.dp)


                    )
                }
            }

        }//first row
    }
    val currentActivity = remember {
        context as? Activity
    }
    Spacer(modifier = Modifier.height(20.dp))
    Row(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = R.drawable.back),
            contentDescription = null,
            modifier = Modifier
                .size(30.dp, 30.dp)
                .weight(0.5f)
                .align(Alignment.CenterVertically).clickable {
                    currentActivity?.finish()
                }
        )
        var text by remember { mutableStateOf(TextFieldValue("")) }
//        OutlinedTextField(
//            value = text,
//            leadingIcon = {
//                Image(
//                    painter = painterResource(id = R.drawable.magnifier_black),
//                    contentDescription = null
//                )
//            },
//            modifier = Modifier
//                .weight(2f)
//                .height(55.dp),
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
//            label = { Text(text = "Search for anyhing") },
//            placeholder = { Text(text = "Search") },
////            colors = TextFieldDefaults.outlinedTextFieldColors(
////                focusedLabelColor = Color.White,
////                unfocusedLabelColor = Color.White,
////                focusedBorderColor = Color.White,
////                unfocusedBorderColor = Color.White,
////                textColor = Color.White, leadingIconColor = Color.White
////            ),
//            onValueChange = {
//                text = it
//            },
//            singleLine = true, maxLines = 1
//        )
        OutlinedTextField(
            value = text,
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.magnifier_black),
                    contentDescription = null
                )
            },
            modifier = Modifier
                .weight(1.5f)
                .height(60.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text(text = "Search for anything", style = TextStyle(fontSize = 14.sp)) },
            placeholder = { Text(text = "", modifier = Modifier.fillMaxHeight()) },

            onValueChange = {
                text = it
            },
            singleLine = true, maxLines = 1
        )


        Image(
            painter = painterResource(id = R.drawable.setting),
            contentDescription = null,
            modifier = Modifier
                .size(30.dp, 30.dp)
                .weight(0.5f)
                .align(Alignment.CenterVertically).clickable {
                    val intent=Intent(context,Setting_Screen::class.java)
                    context.startActivity(intent)
                }
        )

    }
    Spacer(modifier = Modifier.height(20.dp))
    Text(
        text = "Your Profiles & Channels", style = TextStyle(
            fontFamily = FontFamily(Font(R.font.roboto_bold)),
            fontSize = 16.sp, color = Color(
                android.graphics.Color.parseColor("#A13D63")
            )

        ), modifier = Modifier.padding(start = 10.dp)
    )



    Spacer(modifier = Modifier.height(7.dp))

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(
                MaterialTheme.colors.background,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .align(Alignment.Center)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
                    .wrapContentHeight()
                    .align(Alignment.CenterHorizontally)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile_girlpic),
                    contentDescription = null,
                    modifier = Modifier
                        .size(60.dp)
                        .clickable {
                            Toast
                                .makeText(
                                    context,
                                    "Image clicked",
                                    Toast.LENGTH_SHORT
                                )
                                .show()

                            val intent = Intent(context, massenger::class.java)
                            context.startActivity(intent)
                        }
                )
                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text = "Jane Doe",
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.opensans_bold)),
                        fontSize = 15.sp,
                    ),
                    modifier = Modifier

                        .align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.width(10.dp))

                Image(
                    painter = painterResource(id = R.drawable.down_arrow),
                    contentDescription = null,
                    modifier = Modifier
                        .size(21.dp)
                        .align(Alignment.CenterVertically),
                    colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground)
                )

                Spacer(modifier = Modifier.weight(1f))
                Image(
                    painter = painterResource(id = R.drawable.horizontal_option),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                        .align(Alignment.CenterVertically),
                    colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground)
                )
            }

            Row(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(top = 15.dp, bottom = 10.dp)) {
                Box(   modifier = Modifier
                    .weight(0.5f)

                    .background(
                        color = Color(android.graphics.Color.parseColor("#A13D63")),
                        shape = RoundedCornerShape(25.dp)
                    ).padding(8.dp)

                )
                {
                    Text(
                        text = "All Settings",
                        style = TextStyle(
                            fontSize = 18.sp, fontFamily = FontFamily(Font(R.font.roboto_medium)),
                            color = Color.White,
                        ),modifier = Modifier.wrapContentWidth().align(Alignment.Center)

                    )

                }
                Spacer(modifier = Modifier.width(5.dp))
                Box(   modifier = Modifier
                    .weight(0.5f)
                    .background(
                        color = Color(android.graphics.Color.parseColor("#A13D63")),
                        shape = RoundedCornerShape(25.dp)
                    ).padding(8.dp)

                )
                {
                    Text(
                        text = "Notifications",
                        style = TextStyle(
                            fontSize = 18.sp, fontFamily = FontFamily(Font(R.font.roboto_medium)),
                            color = Color.White,
                        ), modifier = Modifier.wrapContentWidth().align(Alignment.Center)

                    )
                }

            }
        }

    }
    Spacer(modifier = Modifier.height(20.dp))
    Column(modifier = Modifier.verticalScroll(rememberScrollState()))
    {

        Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(
                text = "Social",
                style = TextStyle(
                    fontSize = 18.sp, fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    color = Color.White,
                ),
                modifier = Modifier
                    .width(75.dp)
                    .height(30.dp)
                    .background(
                        color = Color(android.graphics.Color.parseColor("#A13D63")),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(start = 10.dp),
            )

        }
        lateinit var courselist: List<Clist>
        courselist = ArrayList<Clist>()
        courselist = (courselist + Clist("Profile", R.drawable.calendar)) as ArrayList<Clist>
        courselist = (courselist + Clist("Events", R.drawable.calendar)) as ArrayList<Clist>
        courselist = (courselist + Clist("Articles", R.drawable.news)) as ArrayList<Clist>
        courselist = (courselist + Clist("Listings", R.drawable.news)) as ArrayList<Clist>
val context= LocalContext.current
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            itemsIndexed(courselist) { index, item ->

                Button(
                    onClick = {

                              val intent= Intent(context,user_profile::class.java)
                        context.startActivity(intent)
                    },
                    modifier = Modifier
                        .padding(8.dp)
                        .width(100.dp),
                    shape = RoundedCornerShape(15.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.background,
//                        contentColor = Color.White,
                    ),
                ) {
                    Column() {
                        Image(
                            painter = painterResource(id = courselist[index].languageimage),
                            contentDescription = null,
                            modifier = Modifier
                                .wrapContentWidth()
                                .wrapContentHeight()
                                .align(Alignment.CenterHorizontally),
                            colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground)
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = courselist[index].languagename,
                            style = TextStyle(
                                fontSize = 11.sp,
//                                color = Color.White,
                                fontFamily = FontFamily(Font(R.font.opensans_bold))
                            )
                        )
                    }
                }

            }
        }//lazy row 1

        lateinit var courselist2: List<Clist>
        courselist2 = ArrayList<Clist>()
        courselist2 = (courselist2 + Clist("Properties", R.drawable.like_ic)) as ArrayList<Clist>
        courselist2 = (courselist2 + Clist("Outfitters", R.drawable.share_ic)) as ArrayList<Clist>
        courselist2 =
            (courselist2 + Clist("Categories", R.drawable.download_ic)) as ArrayList<Clist>
        courselist2 =
            (courselist2 + Clist("Settings", R.drawable.savetrailer_ic)) as ArrayList<Clist>
        courselist2 =
            (courselist2 + Clist("Categories", R.drawable.savetrailer_ic)) as ArrayList<Clist>


        LazyRow(
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
                        backgroundColor = MaterialTheme.colors.background,
//                        contentColor = Color.White,
                    ),
                ) {
                    Row {
//                    Image(
//                        painter = painterResource(id = courselist2[index].languageimage),
//                        contentDescription = null
//                    )
//                    Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = courselist2[index].languagename,
                            style = androidx.compose.ui.text.TextStyle(
                                fontSize = 13.sp,
//                                color = Color.White,
                                fontFamily = FontFamily(Font(R.font.roboto_regular))
                            )
                        )
                    }
                }

            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(
                text = "TV & Video",
                style = TextStyle(
                    fontSize = 18.sp, fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    color = Color.White,
                ),
                modifier = Modifier
                    .wrapContentWidth()
                    .height(30.dp)
                    .background(
                        color = Color(android.graphics.Color.parseColor("#A13D63")),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(start = 10.dp, end = 10.dp),
            )

        }
        lateinit var courselist3: List<Clist>
        courselist3 = ArrayList<Clist>()
        courselist3 =
            (courselist3 + Clist("My Content", R.drawable.image_gallery)) as ArrayList<Clist>
        courselist3 = (courselist3 + Clist("Library", R.drawable.cloud)) as ArrayList<Clist>
        courselist3 = (courselist3 + Clist("Podcasts", R.drawable.podcast)) as ArrayList<Clist>
        courselist3 =
            (courselist3 + Clist("Series", R.drawable.playlist_player)) as ArrayList<Clist>
        courselist3 = (courselist3 + Clist("Cloud", R.drawable.cloud)) as ArrayList<Clist>

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            itemsIndexed(courselist3) { index, item ->

                Button(
                    onClick = {

//                              val intent = Intent(context,StartActivity::class.java)
//                        context.startActivity(intent)
                    },
                    modifier = Modifier
                        .padding(8.dp)
                        .width(100.dp),
                    shape = RoundedCornerShape(15.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.background,
//                        contentColor = Color.White,
                    ),
                ) {
                    Column() {
                        Image(
                            painter = painterResource(id = courselist3[index].languageimage),
                            contentDescription = null,
                            modifier = Modifier
                                .wrapContentWidth()
                                .wrapContentHeight()
                                .align(Alignment.CenterHorizontally),
                            colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground)

                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = courselist3[index].languagename,
                            style = TextStyle(
                                fontSize = 10.sp,
//                                color = Color.White,
                                fontFamily = FontFamily(Font(R.font.opensans_bold))
                            )
                        )
                    }
                }

            }
        }//l

        lateinit var courselist4: List<Clist>
        courselist4 = ArrayList<Clist>()
        courselist4 = (courselist4 + Clist("Movies", R.drawable.film)) as ArrayList<Clist>
        courselist4 = (courselist4 + Clist("Subscription", R.drawable.playlist)) as ArrayList<Clist>
        courselist4 = (courselist4 + Clist("Clips", R.drawable.video_play)) as ArrayList<Clist>
        courselist4 = (courselist4 + Clist("Channels", R.drawable.player)) as ArrayList<Clist>
        courselist4 = (courselist4 + Clist("Clips", R.drawable.video_play)) as ArrayList<Clist>

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            itemsIndexed(courselist4) { index, item ->

                Button(
                    onClick = {},
                    modifier = Modifier
                        .padding(8.dp)
                        .width(100.dp),
                    shape = RoundedCornerShape(15.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.background,
//                        contentColor = Color.White,
                    ),
                ) {
                    Column() {
                        Image(
                            painter = painterResource(id = courselist4[index].languageimage),
                            contentDescription = null,
                            modifier = Modifier
                                .wrapContentWidth()
                                .wrapContentHeight()
                                .align(Alignment.CenterHorizontally),
                            colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground)

                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = courselist4[index].languagename,
                            style = TextStyle(
                                fontSize = 9.sp,
//                                color = Color.White,
                                fontFamily = FontFamily(Font(R.font.opensans_bold))
                            )
                        )
                    }
                }

            }
        }//l


        lateinit var courselist5: List<Clist>
        courselist5 = ArrayList<Clist>()
        courselist5 = (courselist5 + Clist("Following", R.drawable.like_ic)) as ArrayList<Clist>
        courselist5 = (courselist5 + Clist("Products", R.drawable.share_ic)) as ArrayList<Clist>
        courselist5 =
            (courselist5 + Clist("Categories", R.drawable.download_ic)) as ArrayList<Clist>
        courselist5 = (courselist5 + Clist("Stores", R.drawable.savetrailer_ic)) as ArrayList<Clist>
        courselist5 =
            (courselist5 + Clist("Categories", R.drawable.savetrailer_ic)) as ArrayList<Clist>


        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            itemsIndexed(courselist5) { index, item ->

                Button(
                    onClick = {},
                    modifier = Modifier
                        .padding(8.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.background,
//                        contentColor = Color.White,
                    ),
                ) {
                    Row {
//                    Image(
//                        painter = painterResource(id = courselist2[index].languageimage),
//                        contentDescription = null
//                    )
//                    Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = courselist5[index].languagename,
                            style = androidx.compose.ui.text.TextStyle(
                                fontSize = 13.sp,

//                                color = Color.White,
                                fontFamily = FontFamily(Font(R.font.roboto_regular))
                            )
                        )
                    }
                }

            }
        }//list5
        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(
                text = "Shopping",
                style = TextStyle(
                    fontSize = 18.sp, fontFamily = FontFamily(Font(R.font.roboto_medium)),
                    color = Color.White,
                ),
                modifier = Modifier
                    .wrapContentWidth()
                    .height(30.dp)
                    .background(
                        color = Color(android.graphics.Color.parseColor("#A13D63")),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(start = 10.dp, end = 10.dp),
            )

        }
        lateinit var courselist6: List<Clist>
        courselist6 = ArrayList<Clist>()
        courselist6 = (courselist6 + Clist("Account", R.drawable.podcast)) as ArrayList<Clist>
        courselist6 = (courselist6 + Clist("Cart", R.drawable.shopping_cart)) as ArrayList<Clist>
        courselist6 = (courselist6 + Clist("Orders", R.drawable.news)) as ArrayList<Clist>
        courselist6 = (courselist6 + Clist("Classifieds", R.drawable.newspaper)) as ArrayList<Clist>

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            itemsIndexed(courselist6) { index, item ->

                Button(
                    onClick = {},
                    modifier = Modifier
                        .padding(8.dp)
                        .width(100.dp),
                    shape = RoundedCornerShape(15.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.background,
//                        contentColor = Color.White,
                    ),
                ) {
                    Column() {
                        Image(
                            painter = painterResource(id = courselist6[index].languageimage),
                            contentDescription = null, modifier = Modifier
                                .wrapContentWidth()
                                .wrapContentHeight()
                                .align(Alignment.CenterHorizontally),
                            colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground)

                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = courselist6[index].languagename,
                            style = TextStyle(
                                fontSize = 11.sp,
//                                color = Color.White,
                                fontFamily = FontFamily(Font(R.font.opensans_bold))
                            )
                        )
                    }
                }

            }
        }//lazy row 1

        lateinit var courselist7: List<Clist>
        courselist7 = ArrayList<Clist>()
        courselist7 = (courselist7 + Clist("Properties", R.drawable.like_ic)) as ArrayList<Clist>
        courselist7 = (courselist7 + Clist("Outfitters", R.drawable.share_ic)) as ArrayList<Clist>
        courselist7 =
            (courselist7 + Clist("Categories", R.drawable.download_ic)) as ArrayList<Clist>
        courselist7 =
            (courselist7 + Clist("Settings", R.drawable.savetrailer_ic)) as ArrayList<Clist>
        courselist7 =
            (courselist7 + Clist("Categories", R.drawable.savetrailer_ic)) as ArrayList<Clist>


        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            itemsIndexed(courselist7) { index, item ->

                Button(
                    onClick = {},
                    modifier = Modifier
                        .padding(8.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.background,
//                        contentColor = Color.White,
                    ),
                ) {
                    Row {
//                    Image(
//                        painter = painterResource(id = courselist2[index].languageimage),
//                        contentDescription = null
//                    )
//                    Spacer(modifier = Modifier.width(5.dp))
                        Text(
                            text = courselist7[index].languagename,
                            style = androidx.compose.ui.text.TextStyle(
                                fontSize = 13.sp,
//                                color = Color.White,
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
    },
        bottomBar = {
            BottomNavigationWithLabelComponent()
        })
 }






@Preview(showBackground = true)
@Composable
fun DefaultPreview8() {
    UhuntTheme {
menus()
    }
}