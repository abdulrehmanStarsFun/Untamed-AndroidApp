package com.example.uhunt.ui.activities.landing

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uhunt.R
import com.example.uhunt.ui.activities.landing.ui.theme.UhuntTheme

class JetpackLog : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UhuntTheme {
                Surface(
                    modifier = Modifier.background(Color(0xFF000000))
                )
                {
                    logscreen()
                }
                }
            }
        }
    }


@Composable
fun logscreen(

){

    Column() {
        val username = remember { mutableStateOf(TextFieldValue()) }
        Row(modifier = Modifier.background(Color.Black)) {
            Text(text = "Uhunt",color = Color.White)
            Image(
                painter = painterResource(id = R.drawable.helpchat),
                contentDescription =null,
                modifier = Modifier.size(21.dp ,17.dp )
            )
            Text(text = "Don't have an account? ", color = Color.White)
            Text(
                "Sign Up",
                Modifier.size(16.dp),
                Color(0xFF2967FF),
                fontFamily = FontFamily(Font(R.font.opensans_bold))
            )

        }
        Image(
            painter = painterResource(id = R.drawable.photo),
            contentDescription =null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(20.dp))
        TextField(

            modifier = Modifier
                .background(color = Color.White)
                .align(alignment = Alignment.CenterHorizontally),
            label = { Text(text = "Phone or Email") },
            value = username.value,
            onValueChange = { username.value = it })

        Spacer(modifier = Modifier.height(20.dp))

        Row() {

            Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                Button(
                    onClick = { },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .width(120.dp)
                        .height(50.dp),
                ) {
                    Text(text = "Sign Up")
                }
            }


            Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                Button(
                    onClick = { },
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .width(120.dp)
                        .height(50.dp)
                ) {
                    Text(text = "Sign in")
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Forgot password? ",  Modifier.size(16.dp),
            Color(0xFF2967FF))

        Spacer(modifier = Modifier.height(20.dp))

        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(
                onClick = { },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Login With Sms Code")
            }
        }

        Spacer(modifier = Modifier.height(120.dp))

        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
            Button(
                onClick = { },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
            ) {
                Text(text = "or signin with social networks")
            }
        }


    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UhuntTheme {
      logscreen()
    }
}