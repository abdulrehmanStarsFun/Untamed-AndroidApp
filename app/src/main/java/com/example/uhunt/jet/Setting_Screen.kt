package com.example.uhunt.jet


import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.RadioButton
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.uhunt.R
import com.example.uhunt.jet.ui.theme.UhuntTheme

class Setting_Screen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UhuntTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                ) {
settingdesign()
                }
            }
        }
    }
}

@Composable
fun settingdesign(){
Box(modifier = Modifier.fillMaxSize().background(androidx.compose.material.MaterialTheme.colors.background)
) {
    Column(

    ) {


        Column(
        modifier = Modifier.background(color = Color.Black)
        )
        {
            Row(
                modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 10.dp)
//                .padding(horizontal = 10.dp).weight(1f),
//            verticalAlignment = Alignment.CenterVertically
            ) {

                Box(modifier = Modifier.weight(2f)) {
                    Row() {
                        androidx.compose.material.Text(
                            "Uhunt",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontFamily = FontFamily(Font(R.font.opensans_bold)),
//                                color = androidx.compose.material.MaterialTheme.colors.onBackground
                            color = Color.White
                            ),
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
                            modifier = Modifier.size(22.dp, 22.dp)


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

                                .size(22.dp, 22.dp),

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
            val context= LocalContext.current
            val currentActivity = remember {
                context as? Activity
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp, 30.dp)
                        .weight(0.3f)
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
                        .height(60.dp)
                        .padding(end = 10.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    label = {
                        androidx.compose.material.Text(
                            text = "Search for anything",
                            style = TextStyle(fontSize = 14.sp,
                                color = Color.White
                            ),

                        )
                    },
                    placeholder = {
                        androidx.compose.material.Text(
                            text = "", style = TextStyle(
                                color = Color.White
                            ),

                            modifier = Modifier.fillMaxHeight()
                        )
                    },

                    onValueChange = {
                        text = it
                    },
                    singleLine = true, maxLines = 1,
                    colors = TextFieldDefaults.textFieldColors(
                        textColor=Color.White,
                        focusedIndicatorColor = Color.White,
                        unfocusedIndicatorColor =  Color.White,
                        disabledIndicatorColor =  Color.White
                    )
                )


            }
            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(bottom = 10.dp, start = 10.dp, end = 10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .weight(0.5f)

                        .background(
                            color = Color(android.graphics.Color.parseColor("#A13D63")),
                            shape = RoundedCornerShape(25.dp)
                        )
                        .padding(8.dp)

                )
                {
                    androidx.compose.material.Text(
                        text = "Notification Settings",
                        style = TextStyle(
                            fontSize = 18.sp, fontFamily = FontFamily(Font(R.font.roboto_medium)),
                            color = androidx.compose.ui.graphics.Color.White,
                        ), modifier = Modifier
                            .wrapContentWidth()
                            .align(Alignment.Center)

                    )

                }
            }
        }

        Column (modifier = Modifier.verticalScroll(rememberScrollState())){


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFFFFDDE9))
        )
        {
            androidx.compose.material.Text(
                "Message Notifications ",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.opensans_bold)),
                    color = Color(0xFFA34166)
                ), modifier = Modifier.padding(start = 20.dp, top = 20.dp, bottom = 20.dp)
            )
        }

        //setting//
        Box(modifier = Modifier.fillMaxWidth()) {

            Row(modifier = Modifier.padding(10.dp)) {
                Column() {
                    Row() {


                        androidx.compose.material.Text(
                            "Chat Heads",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                                color = androidx.compose.material.MaterialTheme.colors.onBackground

                            ), modifier = Modifier
                                .weight(1.6f)
                                .align(Alignment.CenterVertically)
                        )
                        val mCheckedState = remember { mutableStateOf(false) }

                        // Creating a Switch, when value changes,
                        // it updates mCheckedState value
                        Switch(
                            checked = mCheckedState.value,
                            onCheckedChange = { mCheckedState.value = it },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = Color(0xFFA34166),
                                checkedTrackColor = Color(0xFFA34166),
                                uncheckedThumbColor = Color.Gray,
//                                uncheckedTrackColor = switchColor
                            )

                            )

                    }
                    androidx.compose.material.Text(
                        "Turn on permit drawing over other apps",
                        style = TextStyle(
                            fontSize = 13.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_regular)),
                            color = Color.Gray
                        ), modifier = Modifier
                    )

                }


            }
        }

        //2
        Box(modifier = Modifier.fillMaxWidth()) {

            Row(modifier = Modifier.padding(10.dp)) {
                Column() {
                    Row() {


                        androidx.compose.material.Text(
                            "Notification Popup",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                                color = androidx.compose.material.MaterialTheme.colors.onBackground

                            ), modifier = Modifier
                                .weight(1.6f)
                                .align(Alignment.CenterVertically)
                        )
                        val mCheckedState = remember { mutableStateOf(false) }

                        // Creating a Switch, when value changes,
                        // it updates mCheckedState value
                        Switch(
                            checked = mCheckedState.value,
                            onCheckedChange = { mCheckedState.value = it },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = Color(0xFFA34166),
                                checkedTrackColor = Color(0xFFA34166),
                                uncheckedThumbColor = Color.Gray,
//                                uncheckedTrackColor = switchColor
                            )

                            )

                    }
                    androidx.compose.material.Text(
                        "Get notification when you recieve message",
                        style = TextStyle(
                            fontSize = 13.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_regular)),
                            color = Color.Gray
                        ), modifier = Modifier
                    )

                }


            }
        }



        Box(
            modifier = Modifier
                .height(2.dp)
                .fillMaxWidth()
                .background(color = Color(0xFFFFDDE9))
        )
//3
        Box(modifier = Modifier.fillMaxWidth()) {

            Row(modifier = Modifier.padding(10.dp)) {
                Column() {
                    Row() {


                        androidx.compose.material.Text(
                            "Conversation tones",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                                color = androidx.compose.material.MaterialTheme.colors.onBackground

                            ), modifier = Modifier
                                .weight(1.6f)
                                .align(Alignment.CenterVertically)
                        )
                        val mCheckedState = remember { mutableStateOf(false) }

                        // Creating a Switch, when value changes,
                        // it updates mCheckedState value
                        Switch(
                            checked = mCheckedState.value,
                            onCheckedChange = { mCheckedState.value = it },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = Color(0xFFA34166),
                                checkedTrackColor = Color(0xFFA34166),
                                uncheckedThumbColor = Color.Gray,
//                                uncheckedTrackColor = switchColor
                            )

                            )

                    }
                    androidx.compose.material.Text(
                        "Play sound for incoming for outgoing messages",
                        style = TextStyle(
                            fontSize = 13.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_regular)),
                            color = Color.Gray
                        ), modifier = Modifier
                    )

                }


            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFFFFDDE9))
        )
        {
            androidx.compose.material.Text(
                "General ",
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.opensans_bold)),
                    color = Color(0xFFA34166)
                ), modifier = Modifier.padding(start = 20.dp, top = 20.dp, bottom = 20.dp)
            )
        }
//4
        Box(modifier = Modifier.fillMaxWidth()) {

            Row(modifier = Modifier.padding(10.dp)) {


                androidx.compose.material.Text(
                    "Someone liked my posts",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        color = androidx.compose.material.MaterialTheme.colors.onBackground

                    ), modifier = Modifier
                        .weight(1.6f)
                        .align(Alignment.CenterVertically)
                )
                val checkedState = remember { mutableStateOf(true) }
                Checkbox(
                    // below line we are setting
                    // the state of checkbox.
                    checked = checkedState.value,
                    // below line is use to add padding
                    // to our checkbox.
                    // below line is use to add on check
                    // change to our checkbox.
                    onCheckedChange = { checkedState.value = it },

                    colors = CheckboxDefaults.colors(
                        checkedColor = Color(0xFFA34166),
//                        uncheckedColor = checkboxColor,
                        checkmarkColor = Color.White
                    )
                )


            }
        }
        Box(
            modifier = Modifier
                .height(2.dp)
                .fillMaxWidth()
                .background(color = Color(0xFFFFDDE9))
        )
        //5
        Box(modifier = Modifier.fillMaxWidth()) {

            Row(modifier = Modifier.padding(10.dp)) {


                androidx.compose.material.Text(
                    "Someone commented on my posts",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        color = androidx.compose.material.MaterialTheme.colors.onBackground

                    ), modifier = Modifier
                        .weight(1.6f)
                        .align(Alignment.CenterVertically)
                )
                val checkedState = remember { mutableStateOf(true) }
                Checkbox(
                    // below line we are setting
                    // the state of checkbox.
                    checked = checkedState.value,
                    // below line is use to add padding
                    // to our checkbox.
                    // below line is use to add on check
                    // change to our checkbox.
                    onCheckedChange = { checkedState.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color(0xFFA34166),
//                        uncheckedColor = checkboxColor,
                        checkmarkColor = Color.White
                    )
                )


            }
        }
        Box(
            modifier = Modifier
                .height(2.dp)
                .fillMaxWidth()
                .background(color = Color(0xFFFFDDE9))
        )
        //6
        Box(modifier = Modifier.fillMaxWidth()) {

            Row(modifier = Modifier.padding(10.dp)) {


                androidx.compose.material.Text(
                    "Someone shared on my posts",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        color = androidx.compose.material.MaterialTheme.colors.onBackground

                    ), modifier = Modifier
                        .weight(1.6f)
                        .align(Alignment.CenterVertically)
                )
                val checkedState = remember { mutableStateOf(true) }
                Checkbox(
                    // below line we are setting
                    // the state of checkbox.
                    checked = checkedState.value,
                    // below line is use to add padding
                    // to our checkbox.
                    // below line is use to add on check
                    // change to our checkbox.
                    onCheckedChange = { checkedState.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color(0xFFA34166),
//                        uncheckedColor = checkboxColor,
                        checkmarkColor = Color.White
                    )
                )


            }
        }
        Box(
            modifier = Modifier
                .height(2.dp)
                .fillMaxWidth()
                .background(color = Color(0xFFFFDDE9))
        )
        //7
        Box(modifier = Modifier.fillMaxWidth()) {

            Row(modifier = Modifier.padding(10.dp)) {


                androidx.compose.material.Text(
                    "Someone followed me",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        color = androidx.compose.material.MaterialTheme.colors.onBackground

                    ), modifier = Modifier
                        .weight(1.6f)
                        .align(Alignment.CenterVertically)
                )
                val checkedState = remember { mutableStateOf(true) }
                Checkbox(
                    // below line we are setting
                    // the state of checkbox.
                    checked = checkedState.value,
                    // below line is use to add padding
                    // to our checkbox.
                    // below line is use to add on check
                    // change to our checkbox.
                    onCheckedChange = { checkedState.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color(0xFFA34166),
//                        uncheckedColor = checkboxColor,
                        checkmarkColor = Color.White
                    )
                )


            }
        }
        Box(
            modifier = Modifier
                .height(2.dp)
                .fillMaxWidth()
                .background(color = Color(0xFFFFDDE9))
        )
        //8
        Box(modifier = Modifier.fillMaxWidth()) {

            Row(modifier = Modifier.padding(10.dp)) {


                androidx.compose.material.Text(
                    "Someone liked my pages",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        color = androidx.compose.material.MaterialTheme.colors.onBackground

                    ), modifier = Modifier
                        .weight(1.6f)
                        .align(Alignment.CenterVertically)
                )
                val checkedState = remember { mutableStateOf(true) }
                Checkbox(
                    // below line we are setting
                    // the state of checkbox.
                    checked = checkedState.value,
                    // below line is use to add padding
                    // to our checkbox.
                    // below line is use to add on check
                    // change to our checkbox.
                    onCheckedChange = { checkedState.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color(0xFFA34166),
//                        uncheckedColor = checkboxColor,
                        checkmarkColor = Color.White
                    )
                )


            }
        }

        Box(
            modifier = Modifier
                .height(2.dp)
                .fillMaxWidth()
                .background(color = Color(0xFFFFDDE9))
        )
        //9
        Box(modifier = Modifier.fillMaxWidth()) {

            Row(modifier = Modifier.padding(10.dp)) {


                androidx.compose.material.Text(
                    "Someone visited my profile",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        color = androidx.compose.material.MaterialTheme.colors.onBackground

                    ), modifier = Modifier
                        .weight(1.6f)
                        .align(Alignment.CenterVertically)
                )
                val checkedState = remember { mutableStateOf(true) }
                Checkbox(
                    // below line we are setting
                    // the state of checkbox.
                    checked = checkedState.value,
                    // below line is use to add padding
                    // to our checkbox.
                    // below line is use to add on check
                    // change to our checkbox.
                    onCheckedChange = { checkedState.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color(0xFFA34166),
//                        uncheckedColor = checkboxColor,
                        checkmarkColor = Color.White
                    )
                )


            }
        }
        Box(
            modifier = Modifier
                .height(2.dp)
                .fillMaxWidth()
                .background(color = Color(0xFFFFDDE9))
        )
        //10
        Box(modifier = Modifier.fillMaxWidth()) {

            Row(modifier = Modifier.padding(10.dp)) {


                androidx.compose.material.Text(
                    "Someone mentioned me",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        color = androidx.compose.material.MaterialTheme.colors.onBackground

                    ), modifier = Modifier
                        .weight(1.6f)
                        .align(Alignment.CenterVertically)
                )
                val checkedState = remember { mutableStateOf(true) }
                Checkbox(
                    // below line we are setting
                    // the state of checkbox.
                    checked = checkedState.value,
                    // below line is use to add padding
                    // to our checkbox.
                    // below line is use to add on check
                    // change to our checkbox.
                    onCheckedChange = { checkedState.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color(0xFFA34166),
//                        uncheckedColor = checkboxColor,
                        checkmarkColor = Color.White
                    )
                )


            }
        }

        Box(
            modifier = Modifier
                .height(2.dp)
                .fillMaxWidth()
                .background(color = Color(0xFFFFDDE9))
        )
        //11
        Box(modifier = Modifier.fillMaxWidth()) {

            Row(modifier = Modifier.padding(10.dp)) {


                androidx.compose.material.Text(
                    "Someone joined my groups",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        color = androidx.compose.material.MaterialTheme.colors.onBackground

                    ), modifier = Modifier
                        .weight(1.6f)
                        .align(Alignment.CenterVertically)
                )
                val checkedState = remember { mutableStateOf(true) }
                Checkbox(
                    // below line we are setting
                    // the state of checkbox.
                    checked = checkedState.value,
                    // below line is use to add padding
                    // to our checkbox.
                    // below line is use to add on check
                    // change to our checkbox.
                    onCheckedChange = { checkedState.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color(0xFFA34166),
//                        uncheckedColor = checkboxColor,
                        checkmarkColor = Color.White
                    )
                )


            }
        }

        Box(
            modifier = Modifier
                .height(2.dp)
                .fillMaxWidth()
                .background(color = Color(0xFFFFDDE9))
        )
        //12
        Box(modifier = Modifier.fillMaxWidth()) {

            Row(modifier = Modifier.padding(10.dp)) {


                androidx.compose.material.Text(
                    "Someone accepted my friend/follow request",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        color = androidx.compose.material.MaterialTheme.colors.onBackground

                    ), modifier = Modifier
                        .weight(1.6f)
                        .align(Alignment.CenterVertically)
                )
                val checkedState = remember { mutableStateOf(true) }
                Checkbox(
                    // below line we are setting
                    // the state of checkbox.
                    checked = checkedState.value,
                    // below line is use to add padding
                    // to our checkbox.
                    // below line is use to add on check
                    // change to our checkbox.
                    onCheckedChange = { checkedState.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color(0xFFA34166),
//                        uncheckedColor = checkboxColor,
                        checkmarkColor = Color.White
                    )
                )


            }
        }
        Box(
            modifier = Modifier
                .height(2.dp)
                .fillMaxWidth()
                .background(color = Color(0xFFFFDDE9))
        )
        //13
        Box(modifier = Modifier.fillMaxWidth()) {

            Row(modifier = Modifier.padding(10.dp)) {


                androidx.compose.material.Text(
                    "Someone posted on my timeline",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        color = androidx.compose.material.MaterialTheme.colors.onBackground

                    ), modifier = Modifier
                        .weight(1.6f)
                        .align(Alignment.CenterVertically)
                )
                val checkedState = remember { mutableStateOf(true) }
                Checkbox(
                    // below line we are setting
                    // the state of checkbox.
                    checked = checkedState.value,
                    // below line is use to add padding
                    // to our checkbox.
                    // below line is use to add on check
                    // change to our checkbox.
                    onCheckedChange = { checkedState.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color(0xFFA34166),
//                        uncheckedColor = checkboxColor,
                        checkmarkColor = Color.White
                    )
                )


            }
        }
        Box(
            modifier = Modifier
                .height(2.dp)
                .fillMaxWidth()
                .background(color = Color(0xFFFFDDE9))
        )
        //14
        Box(modifier = Modifier.fillMaxWidth()) {

            Row(modifier = Modifier.padding(10.dp)) {


                androidx.compose.material.Text(
                    "You have remembrance on this day",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_regular)),
                        color = androidx.compose.material.MaterialTheme.colors.onBackground

                    ), modifier = Modifier
                        .weight(1.6f)
                        .align(Alignment.CenterVertically)
                )
                val checkedState = remember { mutableStateOf(true) }
                Checkbox(
                    // below line we are setting
                    // the state of checkbox.
                    checked = checkedState.value,
                    // below line is use to add padding
                    // to our checkbox.
                    // below line is use to add on check
                    // change to our checkbox.
                    onCheckedChange = { checkedState.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color(0xFFA34166),
//                        uncheckedColor = checkboxColor,
                        checkmarkColor = Color.White
                    )
                )


            }
        }

    }
}
}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview6() {
    UhuntTheme {
settingdesign()
    }
}