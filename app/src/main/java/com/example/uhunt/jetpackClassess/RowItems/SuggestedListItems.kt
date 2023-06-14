package com.example.uhunt.jetpackClassess.RowItems

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uhunt.R
import com.example.uhunt.SharedPref.Utilities

import com.example.uhunt.jet.user_profile
import com.example.uhunt.jetpackClassess.DemoDataProvider
import com.example.uhunt.jetpackClassess.components.Material3Card
import com.example.uhunt.jetpackClassess.model.Item
import com.example.uhunt.jetpackClassess.utils.TestTags
import com.example.uhunt.landingActivities.homePlaytube.ListItemDivider
import com.example.uhunt.landingActivities.homePlaytube.SetTextStyling
import com.example.uhunt.models.Featured
import com.example.uhunt.models.ShortsVideoModel
import com.example.uhunt.ui.activities.landing.ui.theme.UhuntTheme
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun SuggestedListItems(
    item: Featured,
    modifier: Modifier = Modifier
) {

    val context = LocalContext.current
    Material3Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .wrapContentHeight()
            .padding(horizontal = 3.dp),
        elevation = 6.dp,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .padding(8.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.background

                    ),
//                      colors = ButtonDefaults.buttonColors(
//                          backgroundColor = androix.compose.material.MaterialTheme.colors.onBackground
////                          backgroundColor = Color.Black,
////                            contentColor = Color.White,
//                      ),
                ) {

                    Column(modifier = Modifier.wrapContentHeight()) {


                        Row(

                        ) {


                            Image(
                                painter = painterResource(id = item.id),
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
            //list5
        }
    }
}

@Composable
fun MovieImageBanner11(imagePath: String, width: Int, height: Int) {
    Image(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .height(height.dp),
        painter = rememberCoilPainter(
            request = imagePath
        ),
        contentDescription = "",
        contentScale = ContentScale.Crop // Adjust this according to your needs
    )
}


@Preview
@Composable
fun PreviewHorizontalListItem4() {
    val item = DemoDataProvider.item
    UhuntTheme {
//        HomeBottomListItems(item = item)
    }
}