package com.example.uhunt.landingActivities.signupActivity

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.uhunt.R
import com.example.uhunt.SharedPref.Utilities
import com.example.uhunt.StartActivity
import com.example.uhunt.jet.ScreenTest
import com.example.uhunt.jet.Testing_Screen
import com.example.uhunt.jet.jetlog
import com.example.uhunt.jet.resetpass
import com.example.uhunt.jet.resetpass_mail_number
import com.example.uhunt.jet.userprofile
import com.example.uhunt.landingActivities.components.ErrorImageAuth
import com.example.uhunt.landingActivities.components.ProgressBarLoading
import com.example.uhunt.landingActivities.homePlaytube.BottomNavigationWithLabelComponent
import com.example.uhunt.landingActivities.homePlaytube.MainPlayTubeActviity

import com.example.uhunt.landingActivities.profile.FillProfileActviity
import com.example.uhunt.navigation.Destination
import com.example.uhunt.ui.activities.landing.ui.theme.UhuntTheme
import com.example.uhunt.viewmodel.SignUpViewModel

class SignupActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UhuntTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),

                    ) {
                    signupSCreen()
                }
            }
        }
    }
}

@Composable
fun signupSCreen(

) {
    val signUpViewModel: SignUpViewModel = viewModel()
    val loadingProgressBar = signUpViewModel.progressBar.value
    val imageError = signUpViewModel.imageErrorAuth.value
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current
    var email by rememberSaveable { mutableStateOf(value = "") }
    var password by rememberSaveable { mutableStateOf(value = "") }
    val snackbarHostState = remember { SnackbarHostState() }
    val scaffoldState = rememberScaffoldState()
//    val isValidate by derivedStateOf { email.isNotBlank() && password.isNotBlank() }
    androidx.compose.material.Scaffold(content = {
        Box(
            modifier = Modifier
                .background(androidx.compose.material.MaterialTheme.colors.background)
                .fillMaxSize()
                .padding(it)
        ) {


            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 15.dp, end = 15.dp),
//                .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically


                ) {
                    Row(modifier = Modifier.weight(2f)) {
                        androidx.compose.material.Text(
                            "Uhunt",
                            style = TextStyle(
                                fontSize = 16.sp,
                            )
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Image(
                            painter = painterResource(id = R.drawable.helpchat),
                            contentDescription = null,
                            modifier = Modifier
                                .size(21.dp, 21.dp)


                        )
                    }

                    androidx.compose.material.Text(
                        " If you have an account?",
                        style = TextStyle(
                            fontSize = 14.sp,
                        ), modifier = Modifier.weight(3f)
                    )
                    val currentActivity = remember {
                        context as? Activity
                    }
                    ClickableText(
                        text = AnnotatedString(
                            " Sign in"
                        ),
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = Color(0xFF2967FF)
                        ), onClick = {
                            val intent = Intent(context, StartActivity::class.java)
                            context.startActivity(intent)
                        }
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.logo_ic),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally).width(200.dp)
                        .height(100.dp)
                        .padding(top = 6.dp),
                    colorFilter = ColorFilter.tint(color = androidx.compose.material.MaterialTheme.colors.onBackground)
                )

                Row(
                    modifier = Modifier
                        .padding(top = 2.dp),
                    verticalAlignment = Alignment.CenterVertically
//                    .fillMaxWidth()

                ) {
                    com.example.uhunt.landingActivities.signupActivity.SetTextStyling(
                        "Need Help? ",
                        style = TextStyle(
                            fontSize = 15.sp,
                        )
                    )

                    com.example.uhunt.landingActivities.signupActivity.SetTextStyling(
                        " click here",
                        style = TextStyle(
                            fontSize = 13.sp,
                            color = Color(0xFF2967FF)
                        )
                    )
                }

                var text by remember { mutableStateOf("") }
                val username = remember { mutableStateOf(TextFieldValue()) }


//            TextField(
//
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(top = 20.dp)
//                    .align(alignment = Alignment.CenterHorizontally),
//                label = { Text(text = "Email") },
//                value = email,
//                onValueChange = { email = it })
                OutlinedTextField(

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)

                        .align(alignment = Alignment.CenterHorizontally),
                    label = { androidx.compose.material.Text(text = "Phone or Email") },
                    placeholder = { androidx.compose.material.Text(text = "Phone or Email") },
                    value = email,
                    onValueChange = { email = it },
                    singleLine = true, maxLines = 1
                )
//            TextField(
//
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(top = 20.dp)
//                    .align(alignment = Alignment.CenterHorizontally),
//                label = { Text(text = "Password") },
//                value = password,
//                onValueChange = { password = it },
//            )
                OutlinedTextField(

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)

                        .align(alignment = Alignment.CenterHorizontally),
                    label = { androidx.compose.material.Text(text = "Password") },
                    placeholder = { androidx.compose.material.Text(text = "password") },
                    value = password,
                    onValueChange = { password = it },
                    singleLine = true, maxLines = 1
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()

                        .padding(top = 20.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ClickableText(
                        text = AnnotatedString("Sign up"),
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 16.sp,

                            textAlign = TextAlign.Center
//                        textDecoration = TextDecoration.Underline
                        ),

                        modifier = Modifier
                            .height(45.dp)
                            .fillMaxWidth()
                            .background(
                                color = Color(context.getColor(R.color.blue)),
                                RoundedCornerShape(5.dp)
                            )
                            .wrapContentHeight()
                            .align(Alignment.CenterVertically),

                        onClick = {
                            focusManager.clearFocus()
                            if (email.isEmpty() || password.isEmpty()) {
                                Toast.makeText(
                                    context,
                                    "Email or password cannot be empty",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
//                            Toast.makeText(context, "Signup success", Toast.LENGTH_SHORT).show()
                                Utilities.saveString(context, Utilities.EMAIL, email)
//                            val intent = Intent(context, FillProfileActviity::class.java)
//                            context.startActivity(intent)
                                signUpViewModel.signUp(email, password)
                            }
                        }




                    )

//                Button(
//                    onClick = { /* Do something */ },
//                    modifier = Modifier
//                        .weight(1f)
//                        .padding(horizontal = 5.dp)
//                        .background(color=Color.Gray, RoundedCornerShape(5.dp))
//                ) {
//                    Text("Sign In")
//                }
                }

                Spacer(modifier = Modifier.height(40.dp))
                androidx.compose.material.Text(
                    text = "SIGNUP WITH SMS CODE",
                    style = TextStyle(
                        fontSize = 17.sp,
                        color = Color.White
                    ),
                    modifier = Modifier
                        .height(45.dp)
                        .fillMaxWidth()
                        .background(
                            color = Color(android.graphics.Color.parseColor("#2D2D2F")),
                            RoundedCornerShape(5.dp)
                        )
                        .wrapContentHeight(),
                    textAlign = TextAlign.Center
                )
Spacer(modifier = Modifier.height(60.dp))
                Column(

                ) {
                    ClickableText(
                        text = AnnotatedString("Or sign up with social networks"),
                        onClick = ({
                            val intent = Intent(context, jetlog::class.java)
                            context.startActivity(intent)
                        }),
                        style = TextStyle(
                            fontSize = 15.sp,
                            color = Color.White,
                            textAlign = TextAlign.Center,
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(45.dp)
                            .padding(horizontal = 30.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#2D2D2F")),
                                RoundedCornerShape(5.dp)
                            )
                            .wrapContentHeight(),

                        )
                }
            }




        }
    },
        bottomBar = {
            BottomNavigationWithLabelComponent()
        })
    val isSuccessLoading by signUpViewModel.isSuccessLoading
    if (isSuccessLoading) {
        // Show a toast message
//        Toast.makeText(context, "Signup success", Toast.LENGTH_SHORT).show()
        Utilities.saveString(context, Utilities.EMAIL, email)
        val intent = Intent(context, FillProfileActviity::class.java)
        context.startActivity(intent)
    }
    val isProgressBarVisible by signUpViewModel.progressBar

    // Show a progress dialog if the progressBar state is true
    if (isProgressBarVisible) {
        AlertDialog(
            onDismissRequest = { /* Disable dismiss on outside touch */ },
            properties = DialogProperties(dismissOnBackPress = false),
            title = { Text(text = "Signing Up") },
            text = { Text(text = "Please wait...") },
            buttons = {
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(8.dp),
//                    horizontalArrangement = Arrangement.End
//                ) {
//                    TextButton(
//                        onClick = { /* Handle button 1 click */ }
//                    ) {
//                        Text(text = "Button 1")
//                    }
//                    TextButton(
//                        onClick = { /* Handle button 2 click */ }
//                    ) {
//                        Text(text = "Button 2")
//                    }
//                }
            }
        )
    }
    SnackbarHost(
        hostState = snackbarHostState,
        snackbar = { snackbarData ->
            Snackbar(
                action = {
                    Button(onClick = {
                        snackbarData.performAction()
                    }) {
                        Text(text = snackbarData.actionLabel!!)
                    }
                }
            ) {
                Text(text = snackbarData.message)
            }
        }
    )
    // Show Snackbar with the error message
    if (signUpViewModel.errorMessage.value != null) {
        Toast.makeText(context, "" + signUpViewModel.errorMessage.value, Toast.LENGTH_SHORT).show()

//        LaunchedEffect(key1 = scaffoldState.snackbarHostState) {
//            scaffoldState.snackbarHostState.showSnackbar(signUpViewModel.errorMessage.value!!)
//        }
    }
    ErrorImageAuth(isImageValidate = imageError)

    ProgressBarLoading(isLoading = loadingProgressBar)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UhuntTheme {
//        logscreen()
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

//@Composable
//fun BottomNavigationWithLabelComponent() {
//    var selectedItem by remember { mutableStateOf(0) }
//    val items = listOf("Home", "Shop", "TV", "Menu")
//    // BottomNavigation is a Composable that is used to give easy access to some items
//    // and are placed at the bottom of the screen so that the user can easily navigate
//    // by clicking the items of the BottomNavigation
//    BottomNavigation(
//        modifier = Modifier
//            .padding(top = 10.dp)
//            .fillMaxWidth(),
//        backgroundColor = Color.Black,
//        contentColor = Color.White
//    ) {
////        items.forEachIndexed { index, item ->
//        // BottomNavigationItem is used to add items to a BottomNavigation and since the
//        // BottomNavigation is having a RowScope, so the BottomNavigationItems will be
//        // placed horizontally.
//        BottomNavigationItem(
//            icon = {
//                Image(
//                    painter = painterResource(id = R.drawable.home),
//                    contentDescription = null
//                )
//
//
//            }, label = { Text("Home") },
//            selected = false,
//            onClick = { /*TODO*/ }
//        )
//        BottomNavigationItem(
//            icon = {
//                Image(
//                    painter = painterResource(id = R.drawable.shop_menu),
//                    contentDescription = null
//                )
//
//
//            }, label = { Text("Shop") },
//            selected = false,
//            onClick = { /*TODO*/ }
//        )
//
//        BottomNavigationItem(
//            icon = {
//                Image(
//                    painter = painterResource(id = R.drawable.television_black),
//                    contentDescription = null
//                )
//
//
//            }, label = { Text("TV") },
//            selected = false,
//            onClick = {})
//        BottomNavigationItem(
//            icon = {
//                Image(
//                    painter = painterResource(id = R.drawable.menu_bottom),
//                    contentDescription = null
//                )
//
//
//            }, label = { Text("Menu") },
//            selected = false,
//            onClick = {
//
//
//            })
//
////        }
//    }
//
//}



