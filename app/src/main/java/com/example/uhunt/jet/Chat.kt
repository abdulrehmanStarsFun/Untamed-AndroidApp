package com.example.uhunt.jet

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uhunt.R
import com.example.uhunt.jet.ui.theme.UhuntTheme

class Chat : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UhuntTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                       ) {
chatting()
                }
            }
        }
    }
}

@Composable
fun chatting(){
    val context= LocalContext.current
    val currentActivity = remember {
        context as? Activity
    }
    Box() {
        Column (modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
                .background(androidx.compose.material.MaterialTheme.colors.background)
        ){
            Row(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(
//                    color = Color(0xFFF1F1F1)
                    androidx.compose.material.MaterialTheme.colors.background

                )
                .padding(top = 10.dp, bottom = 10.dp))
            {
                Box(modifier = Modifier.weight(2f)) {
                    Row(modifier = Modifier.padding(start = 10.dp)) {
                        Image(
                            painter = painterResource(id = R.drawable.backarrow_ic),
                            contentDescription = null,
                            modifier = Modifier
                                .size(24.dp, 24.dp)
                                .align(Alignment.CenterVertically).clickable {

                                    currentActivity?.finish()

                                }

                        )
                        Image(painter = painterResource(id = R.drawable.photo), contentDescription = null, contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                        )
Column(modifier = Modifier.padding(start=6.dp)) {
    androidx.compose.material.Text(
        "Jesse Farr",
        style = TextStyle(
            fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
            color = androidx.compose.material.MaterialTheme.colors.onBackground
        ),
    )
    androidx.compose.material.Text(
        "online",
        color=Color(0xFF9D9D9D),
        style = TextStyle(
            fontSize = 12.sp,
//
            fontFamily = FontFamily(Font(R.font.roboto_regular))
        ),
    )

}



                    }
                }

                Image(
                    painter = painterResource(id = R.drawable.call_ic),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp, 24.dp)
                        .weight(0.4f)
                        .align(Alignment.CenterVertically)

                )

                Image(
                    painter = painterResource(id = R.drawable.cam_ic),
                    contentDescription = null,
                    modifier = Modifier
                        .size(24.dp, 24.dp)
                        .weight(0.4f)
                        .align(Alignment.CenterVertically)

                )

            }
person_two()
    Spacer(modifier = Modifier.height(20.dp))

    Column(horizontalAlignment = Alignment.End, modifier = Modifier
        .fillMaxWidth()
        .padding(end = 10.dp)){
        person_one()
    }

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Bottom,
//                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                //////
                Row(modifier = Modifier.padding(bottom = 10.dp))
                {

                    var text by remember { mutableStateOf(TextFieldValue("")) }
                    androidx.compose.material.OutlinedTextField(
                        value = text,
                        leadingIcon = {
                            Image(
                                painter = painterResource(id = R.drawable.smiley_ic),
                                contentDescription = null
                            )
                        },
                        modifier = Modifier
                            .height(60.dp)
                            .background(color = Color.White,)
                            .width(320.dp)
                            .padding(start = 10.dp).clip(RoundedCornerShape(30.dp))
                         ,shape = RoundedCornerShape(30.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
//        label = { androidx.compose.material.Text(text = "Search for anything") },
                        placeholder = {
                            androidx.compose.material.Text(
                                text = "Message",
                                modifier = Modifier.fillMaxHeight()
                            )

                        },trailingIcon = {
                            Row() {
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(painter = painterResource(id = R.drawable.clip_ic), contentDescription =null )
                                }
                                IconButton(onClick = { /*TODO*/ }) {
                                    Icon(painter = painterResource(id = R.drawable.camera_ic), contentDescription =null )
                                }
                            }

                        },

                        onValueChange = {
                            text = it
                        },
                        singleLine = true, maxLines = 1
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    Box(
                        modifier = Modifier
                            .background(
                                color = Color(0xFF2A87FF),
                                shape = RoundedCornerShape(25.dp)
                            )
                            .align(Alignment.CenterVertically)
                            .size(50.dp)
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.mic_ic),
                            contentDescription = null, modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }


        }
    }



}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    UhuntTheme {
chatting()
    }

}