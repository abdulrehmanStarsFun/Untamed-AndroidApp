package com.example.uhunt.jet

import android.app.Activity
import android.content.Intent

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uhunt.R
import com.example.uhunt.jet.theme.UhuntTheme
import com.example.uhunt.landingActivities.otp.OtpActviity
import com.example.uhunt.landingActivities.signupActivity.SignupActivity

class jetlog : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            UhuntTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Greeting2()
                }
            }
        }
    }
}

@Composable
fun Greeting2() {
    val context= LocalContext.current
    val activity=(LocalContext as? Activity)
    Box(modifier = Modifier
//        .background(Color.Black)
        .fillMaxSize(),
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {


            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically


            ) {
                Text(
                    "Uhunt",
                    style = TextStyle(
                        fontSize = 20.sp,
                        //color = Color.White
                    ), modifier = Modifier.weight(1.6f)
                )

                Image(
                    painter = painterResource(id = R.drawable.helpchat),
                    contentDescription = null,
                    modifier = Modifier
                        .size(21.dp, 17.dp)
                        .weight(1f)

                )
                Text(
                    "Don't have an account?",
                    style = TextStyle(
                        fontSize = 15.sp,
                        //    color = Color.White
                    ), modifier = Modifier.weight(5f)
                )
                ClickableText(
                    text = AnnotatedString( " Sign Up"),
                    style = TextStyle(
                        fontSize = 16.sp,
                        color = Color(0xFF2967FF)
                    ), modifier = Modifier.weight(2f), onClick = {
                        val intent = Intent(context, SignupActivity::class.java)
                        context.startActivity(intent)
                    }
                )
            }

            Image(
                painter = painterResource(id = R.drawable.uhunt),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(top = 10.dp),colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground)
            )
            Row(
                modifier = Modifier
                    .padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically
//                    .fillMaxWidth()

            ) {
                SetTextStyling(
                    "Sign in with social networks",
                    style = TextStyle(
                        fontSize = 20.sp,
//                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.opensans_bold))


                        )
                )



            }
            Spacer(modifier = Modifier.height(20.dp))
            Row() {

                Image(
                    painter = painterResource(id = R.drawable.social_button_3),
                    contentDescription = null,
                    modifier = Modifier.size(80.dp, 65.dp)
                )
                Spacer(modifier = Modifier
                    .height(10.dp)
                    .width(10.dp))

                Image(
                    painter = painterResource(id = R.drawable.g_btn),
                    contentDescription = null,
                    modifier = Modifier.size(95.dp, 70.dp).clickable(
                        enabled = true,
                        onClickLabel = "clicked",
                        onClick = {
val intent=Intent(context,OtpActviity::class.java)
                            context.startActivity(intent)
                        }
                    )
                )

                Spacer(modifier = Modifier
                    .height(10.dp)
                    .width(10.dp))

                Image(
                    painter = painterResource(id = R.drawable.social_button_1),
                    contentDescription = null,
                    modifier = Modifier.size(80.dp, 65.dp)

                )
            }
            Spacer(modifier = Modifier
                .height(30.dp)
                )
            val currentActivity = remember {
                context as? Activity
            }
            Button(onClick = {

            },
                modifier = Modifier
                    .background(color = Color.Blue, RoundedCornerShape(10.dp))
                    .width(160.dp)
                    .height(50.dp),

            ) {

                ClickableText(
                    text = AnnotatedString("GO BACK"),
                    style = TextStyle(
                        fontSize = 18.sp,
                        color =MaterialTheme.colors.background,
                        fontFamily = FontFamily(Font(R.font.montserrat_semibold))

                    ), onClick = {
                        currentActivity?.finish()

                    }
                )




            }
            Spacer(modifier = Modifier
                .height(30.dp))
            val context= LocalContext.current



        }
    }


}



@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    UhuntTheme {
        Greeting2()
    }
}

@Composable
fun SetTextStyling(displayText: String, style: TextStyle? = null, maxLines: Int? = null) {
    // style is used to put some styling to Compose UI elements. Here Default TextStyle is used.
    // overflow is used when the content of the Text crosses the limit. For example, if the maximum
    // allowed lines is one and the total number of lines is two then after 1st line, ellipsis(...)
    // will be shown
    Text(
        text = displayText,
        modifier = Modifier.padding(5.dp),
        style = style ?: TextStyle.Default,
        overflow = TextOverflow.Ellipsis,
        maxLines = maxLines ?: Int.MAX_VALUE
    )
    // There are many other styling that can be done on text. For example, textAlign, lineHeight,
    // letterSpacing, textDecoration, color, background, fontFamily, fontSize, fontStyle, fontWeight, etc
}