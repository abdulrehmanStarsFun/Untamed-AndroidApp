package com.example.uhunt.jet

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uhunt.Clist
import com.example.uhunt.R
import com.example.uhunt.jet.theme.UhuntTheme
import kotlinx.coroutines.launch

class bot : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UhuntTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
MyUI()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyUI() {
    val context = LocalContext.current.applicationContext

    val bottomSheetState =
        rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

    val coroutineScope = rememberCoroutineScope()

    ModalBottomSheetLayout(
        sheetContent = {

           Column(modifier = Modifier.background(Color.Black),) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {



                    Text(
                        "Comments.",
                        style = androidx.compose.ui.text.TextStyle(
                            fontSize = 11.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_bold)),
                            color = androidx.compose.ui.graphics.Color.White,
                        ),modifier = Modifier
                            .offset(x = 3.dp, y = 4.dp)
                            .weight(1.2f)
                            .height(22.dp)
                            .width(83.dp)

                    )


                    Text(
                        "12",
                        style = androidx.compose.ui.text.TextStyle(
                            fontSize = 8.sp,
                            fontFamily = FontFamily(Font(R.font.opensans_bold)),
                            color = Color(android.graphics.Color.parseColor("#A2A2A2")),
                        ), modifier = Modifier
                            .offset(x = 4.dp, y = 2.dp)
                            .weight(4f)
                    )
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .weight(2f)
                        .padding(end = 5.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.option_ic),
                            contentDescription = null,
                            //modifier = HorizontalAlignment=Alignment.TopEnd
                            modifier = Modifier
                                .offset(x = 40.dp, y = 4.dp)
                                .weight(0.1f)

                        )

                        Image(
                            painter = painterResource(id = R.drawable.cancle_ic),
                            contentDescription = null,
                            //modifier = HorizontalAlignment=Alignment.TopEnd
                            modifier = Modifier
                                .offset(x = 40.dp, y = 4.dp)
                                .weight(1.9f)
                        )
                    }

                }//row 1

               Row(
                   modifier = Modifier
                       .wrapContentWidth()
                       .padding(top = 10.dp),
                   horizontalArrangement = Arrangement.SpaceEvenly
               ) {
                   ClickableText(
                       text = AnnotatedString("Newest"),

                       style = TextStyle(
                           color = Color.White,
                           fontSize = 16.sp,
                           fontWeight = FontWeight.Bold,
                           textAlign = TextAlign.Center
//                        textDecoration = TextDecoration.Underline
                       ),
                       modifier = Modifier
                           .wrapContentWidth()
//                           .weight(1f)
                           .height(29.dp)
                           .padding(horizontal = 5.dp)
                           .background(
                               color = Color(android.graphics.Color.parseColor("#1B1B1B")),
                               RoundedCornerShape(25.dp)
                           )
                           .wrapContentHeight(),

                       onClick = {
                           Toast.makeText(context, "its Back", Toast.LENGTH_LONG).show()

                       }
                   )
                   ClickableText(
                       text = AnnotatedString("Top comments"),

                       style = TextStyle(
                           color = Color(android.graphics.Color.parseColor("#2D2D2F")),
                           fontSize = 16.sp,
                           fontWeight = FontWeight.Bold,
                           textAlign = TextAlign.Center
//                        textDecoration = TextDecoration.Underline
                       ),
                       modifier = Modifier
                           .wrapContentWidth()
//                           .weight(1f)
                           .height(29.dp)
                           .padding(horizontal = 5.dp)
                           .background(
                               color = Color(android.graphics.Color.parseColor("#ffffff")),
                               RoundedCornerShape(25.dp)
                           )
                           .wrapContentHeight(),

                       onClick = {
//                        val intent = Intent(context, OtpActviity::class.java)
//                        context.startActivity(intent)
                           Toast.makeText(context, "bottomsheet", Toast.LENGTH_LONG).show()

                       }
                   )
               }
                   Spacer(modifier = Modifier.width(8.dp))

                   lateinit var courselist2: List<Clist>
                   courselist2 = ArrayList<Clist>()
                   courselist2 = (courselist2 + Clist("Jesse Farr", R.drawable.profilepic_ic)) as ArrayList<Clist>
                   courselist2 = (courselist2 + Clist("Joey Sir", R.drawable.profilepic_ic)) as ArrayList<Clist>
                   courselist2 = (courselist2 + Clist("Matt Sandford", R.drawable.profilepic_ic)) as ArrayList<Clist>
                   courselist2 = (courselist2 + Clist("Sally Richards", R.drawable.profilepic_ic)) as ArrayList<Clist>
                   courselist2 = (courselist2 + Clist("Joey Sir", R.drawable.profilepic_ic)) as ArrayList<Clist>
                   courselist2 = (courselist2 + Clist("Kevin Scotch", R.drawable.profilepic_ic)) as ArrayList<Clist>
                   courselist2 = (courselist2 + Clist("Sam Bensan", R.drawable.profilepic_ic)) as ArrayList<Clist>
                   courselist2 = (courselist2 + Clist("Joey Sir", R.drawable.profilepic_ic)) as ArrayList<Clist>

                   LazyColumn( modifier = Modifier
                       .fillMaxWidth()
                       .wrapContentHeight()
                       .background(Color.Black)
                       ) {
                       itemsIndexed(courselist2) { index, item ->


                                   Row(modifier = Modifier
                                       .weight(2f)
                                       .fillMaxWidth()
                                       .wrapContentHeight()) {


                                       Image(
                                           painter = painterResource(id = courselist2[index].languageimage),
                                           contentDescription = null,
                                           modifier = Modifier

                                               .height(21.dp)
                                               .width(21.dp)
                                               .offset(x = 4.dp, y = 2.dp)
                                               .weight(1f)

                                       )

                                       Text(
                                           text = courselist2[index].languagename,
                                           style = androidx.compose.ui.text.TextStyle(
                                               fontSize = 11.sp,
                                               fontFamily = FontFamily(Font(R.font.roboto_bold)),
                                               color = Color.White,
                                           ),modifier = Modifier
                                               .offset(x = 3.dp, y = 4.dp)
                                               .weight(1.4f)

                                       )


                                       Text(
                                           "2hr ago",
                                           style = androidx.compose.ui.text.TextStyle(
                                               fontSize = 8.sp,
                                               fontFamily = FontFamily(Font(R.font.opensans_bold)),
                                               color = Color(android.graphics.Color.parseColor("#A2A2A2")),
                                           ), modifier = Modifier
                                               .offset(x = 4.dp, y = 2.dp)
                                               .weight(3f)
                                       )
                                       Row(modifier = Modifier
                                           .fillMaxWidth()
                                           .wrapContentHeight()
                                           .weight(0.6f)) {
                                           Image(
                                               painter = painterResource(id = R.drawable.option_ic),
                                               contentDescription = null,
                                               //modifier = HorizontalAlignment=Alignment.TopEnd
                                               modifier = Modifier.offset(x=40.dp, y = 4.dp)
                                           )
                                       }
                                   }
                           Spacer(modifier = Modifier.height(8.dp))
                               Column() {
                                   Text(
                                       "Ikea furniture is so shit",
                                       style = androidx.compose.ui.text.TextStyle(
                                           fontSize = 8.sp,
                                           fontFamily = FontFamily(Font(R.font.opensans_bold)),
                                           color = Color.White,
                                       ), modifier = Modifier.padding(start = 15.dp)

                                   )
                                   Spacer(modifier = Modifier.height(8.dp))

                                   Row(){
                                       Image(
                                           painter = painterResource(id = R.drawable.like_ic),
                                           contentDescription = null,
                                           modifier = Modifier
                                               .padding(start = 5.dp)
                                               .height(21.dp)
                                               .width(21.dp)
                                               .offset(x = 4.dp, y = 2.dp)


                                       )

                                       Text(
                                           "60",
                                           style = androidx.compose.ui.text.TextStyle(
                                               fontSize = 12.sp,
                                               fontFamily = FontFamily(Font(R.font.roboto_regular)),
                                               color = Color.White,
                                           ), modifier = Modifier.padding(start = 7.dp, top = 5.dp)
                                       )

                                       Image(
                                           painter = painterResource(id = R.drawable.chat_ic),
                                           contentDescription = null,
                                           modifier = Modifier
                                               .padding(start = 5.dp)
                                               .height(21.dp)
                                               .width(21.dp)
                                               .offset(x = 4.dp, y = 2.dp)


                                       )

                                       Text(
                                           "7",
                                           style = androidx.compose.ui.text.TextStyle(
                                               fontSize = 12.sp,
                                               fontFamily = FontFamily(Font(R.font.roboto_regular)),
                                               color = Color.White,
                                           ), modifier = Modifier.padding(start = 7.dp, top = 5.dp)
                                       )



                                       Text(
                                           "Reply",
                                           style = androidx.compose.ui.text.TextStyle(
                                               fontSize = 12.sp,
                                               fontFamily = FontFamily(Font(R.font.roboto_regular)),
                                               color = Color.White,
                                           ), modifier = Modifier.padding(start = 7.dp, top = 5.dp)
                                       )

                                       Spacer(modifier = Modifier.height(8.dp))


                                   }



                               }




                       }

                   }

               Row() {
                   Image(
                       painter = painterResource(id = R.drawable.profilepic_ic),
                       contentDescription = null,
                       modifier = Modifier
                           .padding(start = 10.dp, top = 10.dp)
                           .height(40.dp)
                           .width(40.dp)

                   )


                   Text(text = "Write a comment ...", style = androidx.compose.ui.text.TextStyle(
                       fontSize = 15.sp,
                       color = Color.White, fontFamily = FontFamily(Font(R.font.roboto_bold))
                   ) ,modifier = Modifier
                       .fillMaxWidth()
                       .padding(10.dp)
                       .height(50.dp)
                       .background(
                           Color(android.graphics.Color.parseColor("#1B1B1B")),
                           shape = RoundedCornerShape(10.dp)
                       )
                       .align(Alignment.CenterVertically)
                   )
//

               }

               }


        },
        sheetState = bottomSheetState
    ) {
        // app UI
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                coroutineScope.launch {
                    bottomSheetState.show()
                }
            }) {
                Text(text = "Show Bottom Sheet")
            }
        }
    }
}

//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview13() {
//    UhuntTheme {
//MyUI()
//    }
//}