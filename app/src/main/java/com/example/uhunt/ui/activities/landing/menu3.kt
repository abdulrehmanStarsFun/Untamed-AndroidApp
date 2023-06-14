package com.example.uhunt.ui.activities.landing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uhunt.Clist
import com.example.uhunt.R
import com.example.uhunt.jet.SetTextStyling
import com.example.uhunt.ui.activities.landing.ui.theme.UhuntTheme

class menu3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UhuntTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    detailmenu2()
                }
            }
        }
    }
}

@Composable
fun detailmenu2() {

    Column(
        modifier = Modifier.fillMaxSize().padding(horizontal = 8.dp)

    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Row(
                modifier = Modifier
//                .padding(horizontal = 10.dp).weight(1f),
//            verticalAlignment = Alignment.CenterVertically


            ) {
                Box(modifier = Modifier.weight(2f)) {
                    Row() {
                        Text(
                            "Uhunt",
                            style = TextStyle(
                                fontSize = 18.sp,
                                color = Color.White, fontFamily = FontFamily(Font(R.font.opensans_bold))
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
                            modifier = Modifier.size(25.dp, 25.dp)


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
                            painter = painterResource(id = R.drawable.bell_ic),
                            contentDescription = null,
                            modifier = Modifier

                                .size(25.dp, 25.dp)


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
        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            var text by remember { mutableStateOf(TextFieldValue("")) }
            OutlinedTextField(
                value = text,
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.magnifier_black),
                        contentDescription = null
                    )
                },
                modifier = Modifier
                    .weight(2f)
                    .height(55.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                label = { Text(text = "Search for anyhing") },
                placeholder = { Text(text = "Email") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White,
                    textColor = Color.White, leadingIconColor = Color.White
                ),
                onValueChange = {
                    text = it
                }
            )


        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Your Profiles & Channels", style = TextStyle(
                fontFamily = FontFamily(Font(R.font.roboto_bold)),
                fontSize = 13.sp, color = Color(
                    android.graphics.Color.parseColor("#A13D63")
                )
            )
        )

        Spacer(modifier = Modifier.height(7.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .background(
                    Color(android.graphics.Color.parseColor("#353535")),
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .align(Alignment.Center)
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.profile_girlpic),
                        contentDescription = null,
                        modifier = Modifier
                            .width(60.dp)
                            .height(65.dp)
                            .align(Alignment.CenterVertically),
                    )
                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = "Jane Doe", style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.opensans_bold)),
                            fontSize = 15.sp, color = Color.White
                        ), modifier = Modifier.align(Alignment.CenterVertically)
                    )
                    Spacer(modifier = Modifier.width(10.dp))

                    Image(
                        painter = painterResource(id = R.drawable.down_arrow),
                        contentDescription = null,
                        modifier = Modifier
                            .size(21.dp, 21.dp)
                            .align(Alignment.CenterVertically),
                    )
                    Spacer(modifier = Modifier.width(170.dp))

                    Image(
                        painter = painterResource(id = R.drawable.horizontal_option),
                        contentDescription = null,
                        modifier = Modifier
                            .size(21.dp, 21.dp)
                            .align(Alignment.CenterVertically)
                    )

                }
            }


        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "All Features", style = TextStyle(
                fontFamily = FontFamily(Font(R.font.opensans_bold)),
                fontSize = 13.sp, color = Color(
                    android.graphics.Color.parseColor("#AEAEAE")
                )
            )
        )
        lateinit var courselist2: List<Clist>
        courselist2 = ArrayList<Clist>()
        courselist2 = (courselist2 + Clist("All", R.drawable.like_ic)) as ArrayList<Clist>
        courselist2 = (courselist2 + Clist("Following", R.drawable.share_ic)) as ArrayList<Clist>
        courselist2 =
            (courselist2 + Clist("Channels", R.drawable.download_ic)) as ArrayList<Clist>
        courselist2 =
            (courselist2 + Clist("Categories", R.drawable.savetrailer_ic)) as ArrayList<Clist>
        courselist2 =
            (courselist2 + Clist("Series", R.drawable.savetrailer_ic)) as ArrayList<Clist>

        courselist2 =
            (courselist2 + Clist("Menu", R.drawable.savetrailer_ic)) as ArrayList<Clist>


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
                    shape = RoundedCornerShape(15.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(android.graphics.Color.parseColor("#1B1B1B")),
                        contentColor = Color.White,
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
                            style = TextStyle(
                                fontSize = 13.sp, color = Color.White,
                                fontFamily = FontFamily(Font(R.font.opensans_bold))
                            )
                        )
                    }
                }

            }
        }

        val  context= LocalContext.current

        val list = (1..18).map { it.toString() }

        lateinit var courselist: List<Clist>
        courselist = ArrayList<Clist>()
        courselist = (courselist + Clist("My Cart", R.drawable.shopping_cart)) as ArrayList<Clist>
        courselist = (courselist + Clist("Saved", R.drawable.save_ic)) as ArrayList<Clist>
        courselist = (courselist + Clist("Channels", R.drawable.playlist)) as ArrayList<Clist>
        courselist = (courselist + Clist("Classifieds", R.drawable.news)) as ArrayList<Clist>
        courselist = (courselist + Clist("My Content", R.drawable.image_gallery)) as ArrayList<Clist>
        courselist = (courselist + Clist("Subscriptions", R.drawable.playlist)) as ArrayList<Clist>
        courselist = (courselist + Clist("Orders", R.drawable.cloud)) as ArrayList<Clist>
        courselist = (courselist + Clist("Read", R.drawable.news)) as ArrayList<Clist>
        courselist = (courselist + Clist("Podcasts", R.drawable.podcast)) as ArrayList<Clist>
        courselist = (courselist + Clist("My Account", R.drawable.calendar)) as ArrayList<Clist>
        courselist = (courselist + Clist("Events", R.drawable.news)) as ArrayList<Clist>
        courselist = (courselist + Clist("Library", R.drawable.cloud)) as ArrayList<Clist>
        courselist = (courselist + Clist("Saved", R.drawable.save_ic)) as ArrayList<Clist>
        courselist = (courselist + Clist("Ads", R.drawable.calendar)) as ArrayList<Clist>
        courselist = (courselist + Clist("Series", R.drawable.playlist_player)) as ArrayList<Clist>
        courselist = (courselist + Clist("Movies", R.drawable.film)) as ArrayList<Clist>
        courselist = (courselist + Clist("Ads", R.drawable.calendar)) as ArrayList<Clist>
        courselist = (courselist + Clist("Movies", R.drawable.film)) as ArrayList<Clist>
        courselist = (courselist + Clist("Classifieds", R.drawable.news)) as ArrayList<Clist>
        courselist = (courselist + Clist("My Content", R.drawable.image_gallery)) as ArrayList<Clist>
        courselist = (courselist + Clist("Subscriptions", R.drawable.playlist)) as ArrayList<Clist>
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),

            // content padding
            contentPadding = PaddingValues(
                start = 12.dp,
                top = 16.dp,
                end = 12.dp,
                bottom = 16.dp
            ),
            content = {
                items(courselist.size) { index ->
                    Button(
                        onClick = {

//                            val intent= Intent(context,menu2::class.java)
//                            context.startActivity(intent)
                        },
                        modifier = Modifier
                            .padding(8.dp)
                            .width(100.dp),
                        shape = RoundedCornerShape(15.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color(android.graphics.Color.parseColor("#1B1B1B")),
                            contentColor = Color.White,
                        ),
                    ) {
                        Column() {
                            Image(
                                painter = painterResource(id = courselist[index].languageimage),
                                contentDescription = null, modifier = Modifier.wrapContentWidth().wrapContentHeight().align(Alignment.CenterHorizontally)
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = courselist[index].languagename,
                                style = TextStyle(
                                    fontSize = 10.sp, color = Color.White,
                                    fontFamily = FontFamily(Font(R.font.opensans_bold))
                                )
                            )
                        }
                    }
                }
            }
        )//lazy grid

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview11() {
    UhuntTheme {
        detailmenu2()
    }
}