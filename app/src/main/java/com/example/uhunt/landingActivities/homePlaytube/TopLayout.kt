package com.example.uhunt.landingActivities.homePlaytube

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uhunt.R
import com.example.uhunt.jetpackClassess.colorsThemes.purple
import com.example.uhunt.jetpackClassess.colorsThemes.purple200
@Composable
fun TopLayout() {
//    Text(text = "Buttons", style = typography.h5, modifier = Modifier.padding(8.dp))

    Column(
        modifier = Modifier
            .padding(top = 10.dp)
            .fillMaxWidth(),


    ) {
        Row(
            modifier = Modifier
//                .padding(horizontal = 10.dp).weight(1f),
//            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(modifier = Modifier.weight(2f)) {
                Row( modifier = Modifier
                    .padding(10.dp)
                ) {
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

                Row(modifier = Modifier
                    .padding(10.dp)) {


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
                        painter = painterResource(id = R.drawable.bell_gray),
                        contentDescription = null,
                        modifier = Modifier

                            .size(25.dp, 25.dp),

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
    ScrollableListOfTabs()
}

