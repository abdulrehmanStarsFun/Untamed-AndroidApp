package com.example.uhunt.jet

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
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
import com.example.uhunt.jet.theme.UhuntTheme
import com.example.uhunt.landingActivities.homePlaytube.BottomNavigationWithLabelComponent
import com.example.uhunt.ui.activities.landing.menu

//import com.example.uhunt.landingActivities.homePlaytube.bottom

class massenger : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UhuntTheme {
                // A surface container using the 'background' color from the theme
                Surface(

                     modifier = Modifier
            .background(MaterialTheme.colors.background)
                ) {

                    massengerdesign()

                }
            }
        }
    }
}

@Composable
fun massengerdesign() {


    val context = LocalContext.current
    val currentActivity = remember {
        context as? Activity
    }
    Scaffold (  content = {
        Box(modifier = Modifier.padding(it)) {

            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Spacer(modifier = Modifier.height(20.dp))
//                Box(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .wrapContentHeight()
//                ) {

                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight())
                            {
                                Box(modifier = Modifier.weight(2f)) {
                                    Row(modifier = Modifier.padding(start = 10.dp)) {
                                        Text(
                                    "Jesse Farr",
                                    style = TextStyle(
                                        fontSize = 20.sp,
//
                                        fontFamily = FontFamily(Font(R.font.roboto_regular))
                                    ),
                                )
                                        Spacer(modifier = Modifier.width(15.dp))

                                        Image(
                                            painter = painterResource(id = R.drawable.down_arrow),
                                            contentDescription = null,
                                            modifier = Modifier
                                                .size(25.dp, 25.dp)
                                                .align(Alignment.CenterVertically)

                                        )
                                    }
                                }

                                Image(
                                    painter = painterResource(id = R.drawable.helpchat),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(21.dp, 21.dp).weight(0.4f)

                                )

                                Image(
                                    painter = painterResource(id = R.drawable.writing),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(21.dp, 21.dp).weight(0.4f)

                                )

                    }


                Spacer(modifier = Modifier.height(20.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp, 30.dp)
                            .weight(0.4f)
                            .align(Alignment.CenterVertically).clickable {
                                currentActivity?.finish()
                            }
                    )
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
                            .weight(1.5f)
                            .height(60.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        label = { Text(text = "Search for anything") },
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
                            .weight(0.3f)
                            .align(Alignment.CenterVertically)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.horizontal_option),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp, 30.dp)
                            .align(Alignment.CenterVertically)
                            .padding(end = 10.dp),
                        colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground)
                    )

                }
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    text = "Recent Contacts", style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        fontSize = 15.sp, color = Color(
                            android.graphics.Color.parseColor("#919191")
                        )
                    )
                )
                lateinit var courselist: List<Clist>
                courselist = ArrayList<Clist>()
                courselist =
                    (courselist + Clist("Daniel James", R.drawable.profilepic)) as ArrayList<Clist>
                courselist =
                    (courselist + Clist("Joey Sir", R.drawable.profilepic)) as ArrayList<Clist>
                courselist =
                    (courselist + Clist("Daniel James", R.drawable.profilepic)) as ArrayList<Clist>
                courselist =
                    (courselist + Clist("Joey Sir", R.drawable.profilepic)) as ArrayList<Clist>
                courselist =
                    (courselist + Clist("Daniel James", R.drawable.profilepic)) as ArrayList<Clist>
                courselist =
                    (courselist + Clist("Joey Sir", R.drawable.profilepic)) as ArrayList<Clist>
                courselist =
                    (courselist + Clist("Daniel James", R.drawable.profilepic)) as ArrayList<Clist>
                courselist =
                    (courselist + Clist("Joey Sir", R.drawable.profilepic)) as ArrayList<Clist>
                courselist =
                    (courselist + Clist("Daniel James", R.drawable.profilepic)) as ArrayList<Clist>
                courselist =
                    (courselist + Clist("Joey Sir", R.drawable.profilepic)) as ArrayList<Clist>
                courselist =
                    (courselist + Clist("Daniel James", R.drawable.profilepic)) as ArrayList<Clist>
                courselist =
                    (courselist + Clist("Joey Sir", R.drawable.profilepic)) as ArrayList<Clist>

                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    itemsIndexed(courselist) { index, item ->

//                Button(
//                    onClick = {
//
//                        val intent= Intent(context, menu2::class.java)
//                        context.startActivity(intent)
//                    },
//                    modifier = Modifier
//                        .padding(8.dp)
//                        .width(100.dp),
//                    shape = RoundedCornerShape(15.dp),
//                    colors = ButtonDefaults.buttonColors(
//                        backgroundColor = Color(android.graphics.Color.parseColor("#1B1B1B")),
//                        contentColor = Color.White,
//                    ),
//                ) {
                        Column(
                            modifier = Modifier.padding(10.dp)
                        ) {
                            Image(
                                painter = painterResource(id = courselist[index].languageimage),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(55.dp)
                                    .height(55.dp)
                                    .align(Alignment.CenterHorizontally)
                                    .border(
                                        2.dp, Color.Gray, CircleShape
                                    )
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Text(
                                text = courselist[index].languagename,
                                style = TextStyle(
                                    fontSize = 10.sp,
//                            color = Color.White,
                                    fontFamily = FontFamily(Font(R.font.roboto_regular))
                                ), modifier = Modifier.align(Alignment.CenterHorizontally)
                            )
                        }
                    }


                }//lazy row 1


                lateinit var courselist5: List<Clist>
                courselist5 = ArrayList<Clist>()
                courselist5 = (courselist5 + Clist("All", R.drawable.like_ic)) as ArrayList<Clist>
                courselist5 =
                    (courselist5 + Clist("Primary", R.drawable.share_ic)) as ArrayList<Clist>
                courselist5 =
                    (courselist5 + Clist("General", R.drawable.download_ic)) as ArrayList<Clist>
                courselist5 =
                    (courselist5 + Clist("Shop", R.drawable.savetrailer_ic)) as ArrayList<Clist>
                courselist5 =
                    (courselist5 + Clist("TV", R.drawable.savetrailer_ic)) as ArrayList<Clist>
                courselist5 = (courselist5 + Clist("Calls", R.drawable.like_ic)) as ArrayList<Clist>
                courselist5 =
                    (courselist5 + Clist("Requests", R.drawable.share_ic)) as ArrayList<Clist>
                courselist5 =
                    (courselist5 + Clist("Unread", R.drawable.download_ic)) as ArrayList<Clist>
                courselist5 =
                    (courselist5 + Clist("Unanswered", R.drawable.like_ic)) as ArrayList<Clist>
                courselist5 =
                    (courselist5 + Clist("Flagged", R.drawable.share_ic)) as ArrayList<Clist>




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
                                backgroundColor = MaterialTheme.colors.background

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
                                        fontFamily = FontFamily(Font(R.font.roboto_regular))
                                    )
                                )
                            }
                        }

                    }
                }//list5


                lateinit var courselist2: List<Clist>
                courselist2 = ArrayList<Clist>()
                courselist2 =
                    (courselist2 + Clist("Jesse Farr", R.drawable.profilepic)) as ArrayList<Clist>
                courselist2 =
                    (courselist2 + Clist("Joey Sir", R.drawable.profilepic)) as ArrayList<Clist>
                courselist2 =
                    (courselist2 + Clist(
                        "Matt Sandford",
                        R.drawable.profilepic
                    )) as ArrayList<Clist>
                courselist2 =
                    (courselist2 + Clist(
                        "Sally Richards",
                        R.drawable.profilepic
                    )) as ArrayList<Clist>
                courselist2 =
                    (courselist2 + Clist("Joey Sir", R.drawable.profilepic)) as ArrayList<Clist>
                courselist2 =
                    (courselist2 + Clist("Kevin Scotch", R.drawable.profilepic)) as ArrayList<Clist>
                courselist2 =
                    (courselist2 + Clist("Sam Bensan", R.drawable.profilepic)) as ArrayList<Clist>
                (courselist2 + Clist("Joey Sir", R.drawable.profilepic)) as ArrayList<Clist>
                courselist2 =
                    (courselist2 + Clist("Kevin Scotch", R.drawable.profilepic)) as ArrayList<Clist>
                courselist2 =
                    (courselist2 + Clist("Sam Bensan", R.drawable.profilepic)) as ArrayList<Clist>


                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    itemsIndexed(courselist2) { index, item ->

                        Button(
                            onClick = {

                                 val intent=Intent(context,Chat::class.java)
                              context.startActivity(intent)
                            },
                            modifier = Modifier
                                .padding(8.dp),
                            shape = RoundedCornerShape(20.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = MaterialTheme.colors.background

                            ),
                        ) {
                            Row(

                            ) {
                                Image(
                                    painter = painterResource(id = courselist2[index].languageimage),
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier
                                        .width(50.dp)
                                        .height(50.dp)
                                        .weight(1f)
                                        .clip(CircleShape)
                                        .border(
                                            2.dp, Color.Gray, CircleShape
                                        )
                                )
                                Spacer(modifier = Modifier.width(5.dp))
                                Column(modifier = Modifier.weight(5f)) {
                                    Row(modifier = Modifier.padding(end = 10.dp)) {
                                        Text(
                                            text = courselist2[index].languagename,
                                            style = androidx.compose.ui.text.TextStyle(
                                                fontSize = 16.sp,
                                                fontFamily = FontFamily(Font(R.font.roboto_medium))
                                            )
                                        )
                                        Spacer(modifier = Modifier.width(20.dp))

                                        Image(
                                            painter = painterResource(id = R.drawable.ellipse_187),
                                            contentDescription = null
                                        )
                                    }

                                    Text(
                                        text = "this is the dummy text for testing purpose only",
                                        style = androidx.compose.ui.text.TextStyle(
                                            fontSize = 10.sp,
                                            fontFamily = FontFamily(Font(R.font.roboto_medium))
                                        ), modifier = Modifier
                                            .padding(start = 8.dp)
                                            .wrapContentWidth()
                                    )

                                }

                                Image(
                                    painter = painterResource(id = R.drawable.writing),
                                    contentDescription = null, modifier = Modifier
                                        .align(Alignment.CenterVertically)
                                        .size(25.dp, 25.dp)
                                        .weight(0.6f)
                                )
                            }
                        }

                    }
                }//list5

            }
        }
    },
        bottomBar = {
//         BottomNavigationWithLabelComponent()
            mbottom()
        })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview12() {
    UhuntTheme {
        massengerdesign()
    }
}


@Composable
fun mbottom(){
val context= LocalContext.current
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Home", "Shop", "TV", "Menu")
    // BottomNavigation is a Composable that is used to give easy access to some items
    // and are placed at the bottom of the screen so that the user can easily navigate
    // by clicking the items of the BottomNavigation

    BottomNavigation(
        modifier = Modifier
            .padding(top = 8.dp)
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
                    painter = painterResource(id = R.drawable.back_arrow),
                    contentDescription = null,
                )


            }, label = { Text("Back",
                style = TextStyle(
                    fontSize = 10.sp
                )
            )},
            selected = false,
            onClick = { /*TODO*/ }
        )

        BottomNavigationItem(
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.massage),
                    contentDescription = null,modifier = Modifier
                        .padding(top = 8.dp)
                )


            }, label = { Text("Messages",
          style = TextStyle(
              fontSize = 10.sp
          )
                ) },
            selected = false,
            onClick = { /*TODO*/ }
        )
        BottomNavigationItem(
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.video_call),
                    contentDescription = null,
                )


            }, label = { Text("Calls",
                style = TextStyle(
                    fontSize = 10.sp
                )) },
            selected = false,
            onClick = { /*TODO*/ }
        )

        BottomNavigationItem(
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.contacts),
                    contentDescription = null,
                )


            }, label = { Text("Contacts",
                style = TextStyle(
                    fontSize = 10.sp
                )) },
            selected = false,
            onClick = {})
        BottomNavigationItem(
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.menu_bottom),
                    contentDescription = null,
                )


            }, label = { Text("Menu",
                style = TextStyle(
                    fontSize = 10.sp
                )) },
            selected = false,
            onClick = {
                val intent= Intent(context, menu::class.java)
                context.startActivity(intent)

            })

        }
    }
