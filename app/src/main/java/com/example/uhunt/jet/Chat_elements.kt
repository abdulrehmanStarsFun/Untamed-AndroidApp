package com.example.uhunt.jet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uhunt.R
import com.example.uhunt.jet.ui.theme.UhuntTheme
@Composable
fun person_one( ){


    Box(
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .background(color = Color(0xFF2A87FF),
                shape = RoundedCornerShape(
                    topStart = 25.dp,
                    topEnd = 25.dp,
                    bottomStart = 25.dp
                )
//                CutCornerShape(bottomEnd = 16.dp)
            )
            .padding(start = 10.dp, 6.dp, end = 10.dp, bottom = 8.dp)

    )
    {
        Row() {
            Text(
                text = "How about this friday?",
                color=Color.White,
                style = TextStyle(
                    fontSize =13.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_regular))
                )

            )
            Spacer(modifier = Modifier.width(5.dp))
            Row(modifier = Modifier.padding(top = 8.dp)) {
                Text(
                    text = "10:32 AM",
                    color= Color.Gray,
                    style = TextStyle(
                        fontSize =10.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_regular))
                    ),

                    )
                Spacer(modifier = Modifier.width(4.dp))
                Image(painter = painterResource(id = R.drawable.tick),
                    contentDescription = null,
                    modifier = Modifier.padding(top = 5.dp)
                )

            }

        }

    }

}

@Composable
fun person_two(){
    Column(modifier = Modifier
        .padding(top = 15.dp, start = 10.dp)
        .fillMaxWidth())
    {
        Row() {
            Image(painter = painterResource(id = R.drawable.photo), contentDescription = null, contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Box(
                modifier = Modifier
                    .wrapContentWidth()
                    .wrapContentHeight()
                    .align(Alignment.CenterVertically)
                    .background(
                        color = Color(0xFFDCDBDB),
                        shape = RoundedCornerShape(
                            topStart = 25.dp,
                            topEnd = 25.dp,
                            bottomEnd = 25.dp
                        )
//                CutCornerShape(bottomEnd = 16.dp)
                    )
                    .padding(start = 10.dp, 6.dp, end = 10.dp, bottom = 8.dp),

                )
            {
                Row() {
                    Text(
                        text = "How about this friday?",

                        style = TextStyle(
                            fontSize = 13.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_regular))
                        )

                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Row(modifier = Modifier.padding(top = 8.dp)) {
                        Text(
                            text = "10:32 AM",
                            color = Color.Gray,
                            style = TextStyle(
                                fontSize = 10.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_regular))
                            ),

                            )
                        Spacer(modifier = Modifier.width(4.dp))
//                    Image(
//                        painter = painterResource(id = R.drawable.tick),
//                        contentDescription = null,
//                        modifier = Modifier.padding(top = 5.dp)
//                    )

                    }

                }

            }
        }


    }
}