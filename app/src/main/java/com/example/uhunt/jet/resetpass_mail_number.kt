package com.example.uhunt.jet

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
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
import com.example.uhunt.R
import com.example.uhunt.jet.theme.UhuntTheme
import com.example.uhunt.landingActivities.otp.OtpActviity
import com.example.uhunt.ui.activities.landing.menu

class resetpass_mail_number : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UhuntTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
//                    color = Color.Black
                ) {
restmailphonepass()
                }
            }
        }
    }
}

@Composable
fun restmailphonepass(){
    val context= LocalContext.current

    Column (
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .fillMaxWidth().verticalScroll(rememberScrollState())

    ){
        Box(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically
//                    .fillMaxWidth()

            ) {
                SetTextStyling(
                    "Uhunt",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.opensans_bold))
                               // ,color = Color.White
                    )
                )
                Image(
                    painter = painterResource(id = R.drawable.helpchat),
                    contentDescription = null,
                    modifier = Modifier.size(21.dp, 17.dp)

                )
            }//first row

        }//first row's box

        Spacer(modifier = Modifier.width(30.dp))

        Box (modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()){
            Row(
                modifier = Modifier
                    .padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically
//                    .fillMaxWidth()

            ) {
                val currentActivity = remember {
                    context as? Activity
                }
                Image(
                    painter = painterResource(id = R.drawable.arrow),
                    contentDescription = null,
                    modifier = Modifier.size(28.dp, 28.dp).clickable(
                        enabled = true,
                        onClickLabel = "Clickable image",
                        onClick = {
                            currentActivity?.finish()
                        }
                    ), colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground)

                )
                SetTextStyling(
                    "Reset Your Password",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold))
//                               , color = Color.White,
                    )
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
        }//second row box

        Spacer(modifier = Modifier.width(30.dp))

        Box(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()) {
            Column(
                modifier = Modifier
                    .padding(25.dp)
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                var text by remember { mutableStateOf(TextFieldValue("")) }

                SetTextStyling(
                    "Reset using your email address",
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold))
//                               , color = Color.White,
                    )
                )

                val textFieldColors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = MaterialTheme.colors.primary,
                    unfocusedBorderColor = MaterialTheme.colors.onSurface.copy(alpha = 0.12f),
                    textColor = MaterialTheme.colors.onSurface,
                    backgroundColor = MaterialTheme.colors.surface,
                )
                OutlinedTextField(
                    value = text,
                    leadingIcon = { Icon(imageVector = Icons.Default.Lock,
                        contentDescription = null,) },
                    modifier = Modifier
                        .fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    label = { SetTextStyling(
                            "Enter your email address",
                        style = TextStyle(
                            fontSize = 13.sp,
                           fontFamily = FontFamily(Font(R.font.roboto_bold))
//                                  , color = Color.White
                        ))
                         },
                    placeholder = { Text(text = "Email") },

//                    colors = TextFieldDefaults.outlinedTextFieldColors(
//                        focusedLabelColor = Color.White,
//                        unfocusedLabelColor = Color.White,
//                        focusedBorderColor =Color.White ,
//                        unfocusedBorderColor =Color.White,
//                         leadingIconColor = Color.White
////                                , textColor = Color.White,
//                    ),
                    colors = textFieldColors,
                    onValueChange = {
                        text = it
                    },
                    singleLine = true, maxLines = 1
                )
                Spacer(modifier = Modifier.height(20.dp))

                SetTextStyling(
                    "Reset using your phone number",
                    style = TextStyle(
                        fontSize = 15.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold))
//                                ,color = Color.White,
                    ))

                OutlinedTextField(
                    value = text,
                    leadingIcon = { Icon(imageVector = Icons.Default.Lock,
                        contentDescription = null) },
                    modifier = Modifier
                        .fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    label = {SetTextStyling(
                            "Enter your Phone number",
                        style = TextStyle(
                            fontSize = 13.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_bold))
//                                   , color = Color.White,
                        )) },
                    placeholder = { Text(text = "Phone Number") },
//                    colors = TextFieldDefaults.outlinedTextFieldColors(
//                        focusedLabelColor = Color.White,
//                        unfocusedLabelColor = Color.White,
//                        focusedBorderColor =Color.White ,
//                        unfocusedBorderColor =Color.White,
//                        textColor = Color.White,leadingIconColor = Color.White
//                    ),

                    colors = textFieldColors,
                    onValueChange = {
                        text = it
                    },
                    singleLine = true, maxLines = 1
                )

                Spacer(modifier = Modifier.height(20.dp))

                Row() {

                    //back button
                    Button(

                        modifier = Modifier
                            .padding(10.dp)
                            .weight(1f)
                            .height(50.dp),
                        onClick = {

//                      toast(tc)
//                            val intent= Intent(context,jetlog::class.java)
//                            val intent= Intent(context,faltu::class.java)
//                            context.startActivity(intent)

                        },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color(android.graphics.Color.parseColor("#1B1B1B")),
                            contentColor = Color(android.graphics.Color.parseColor("#707070"))
                        ),
                        shape = RoundedCornerShape(45.dp)
                    ) {
                        Text(text = "Back"
                        , color = Color.White)
                    }

                    //continue button
                    val buttonColors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.primary,
                        contentColor = MaterialTheme.colors.onPrimary
                    )
                    Button(

                        modifier = Modifier
                            .padding(10.dp)
                            .weight(1f)
                            .height(50.dp),
                        onClick = {

//                      toast(tc)
                            val intent= Intent(context,OtpActviity::class.java)
                            context.startActivity(intent)

                        },
//                        colors = ButtonDefaults.buttonColors(
//                            backgroundColor = Color.White,
//                            contentColor = Color.Black
//                        ),
                        colors=buttonColors,
                        shape = RoundedCornerShape(45.dp)
                    ) {
                        Text(text = "Continue")
                    }

                }

                Button(

                    modifier = Modifier
                        .padding(10.dp)
                        .align(alignment = Alignment.CenterHorizontally)
                        .fillMaxWidth()
                        .height(50.dp),
                    onClick = {

//                      toast(tc)
                        val intent= Intent(context,menu::class.java)
                        context.startActivity(intent)

                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(android.graphics.Color.parseColor("#1B1B1B")),
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "LOGIN WITH SMS CODE",
                        color = Color.White
                    )
                    }
                }
            }//third box colum

        }//third box

    }//main colum



@Preview(showBackground = true)
@Composable
fun DefaultPreview6() {
    UhuntTheme {
restmailphonepass()
    }
}