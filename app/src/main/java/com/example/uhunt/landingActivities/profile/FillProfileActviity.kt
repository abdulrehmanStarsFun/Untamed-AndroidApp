package com.example.uhunt.landingActivities.profile

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalLifecycleOwner
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.uhunt.R
import com.example.uhunt.SharedPref.Utilities

import com.example.uhunt.jet.profiledetail

import com.example.uhunt.landingActivities.otp.OtpActviity
import com.example.uhunt.ui.activities.landing.ui.theme.UhuntTheme
import com.example.uhunt.viewmodel.FillYourProfileViewModel
import com.example.uhunt.viewmodel.SignUpViewModel

class FillProfileActviity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UhuntTheme {
                Surface(
                    modifier = Modifier.background(Color(0xFF000000))
                )
                {
                    // ImageClickableActivity(onBackPressedDispatcher)
                    fillYourProifle()
                }
            }
        }
    }
}


@Composable
fun fillYourProifle(

) {
    val viewModel: FillYourProfileViewModel = viewModel()
    val loadingProgressBar = viewModel.progressBar.value
    val imageError = viewModel.imageErrorAuth.value
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current
    var firstName by rememberSaveable { mutableStateOf(value = "") }
    var lastName by rememberSaveable { mutableStateOf(value = "") }
    var userName by rememberSaveable { mutableStateOf(value = "") }
    val emailString = Utilities.getString(context, Utilities.EMAIL)
    var email by rememberSaveable { mutableStateOf(emailString) }

    var phoneNumber by rememberSaveable { mutableStateOf(value = "") }
    var gender by rememberSaveable { mutableStateOf(value = "") }
//    val lifecycleOwner = LocalLifecycleOwner.current
//    loginViewModel.tokenData.observe(lifecycleOwner) { loginResponse ->
//        // Handle the token data here
//        loginResponse?.let { tokenDto ->
//            val userData = tokenDto.user_data
//            val accessToken = tokenDto.access_token
//            val userId = userData.user_id
//            Toast.makeText(context, userId + "\n" + accessToken, Toast.LENGTH_LONG).show()
//            // Use the token data as needed
//            // For example, you can save it to SharedPref or perform other actions
////            UserDataManager.saveUserData(context, accessToken, userId)
//        }
//    }
    Box(
        modifier = Modifier

            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        val context = LocalContext.current
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .padding(20.dp),
//            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically


            ) {
                SetTextStyling(
                    "Uhunt",
                    style = TextStyle(
                        fontSize = 20.sp,

                        )
                )
                Image(
                    painter = painterResource(id = R.drawable.helpchat),
                    contentDescription = null,
                    modifier = Modifier.size(21.dp, 17.dp)

                )
            }

            Row(
                modifier = Modifier
                    .padding(top = 10.dp),
                verticalAlignment = Alignment.CenterVertically
//                    .fillMaxWidth()

            ) {

                Image(
                    painter = painterResource(id = R.drawable.back_ic),
                    contentDescription = null,
                    modifier = Modifier
                        .wrapContentHeight()
                        .clickable {

                        }, colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground)

                )
                SetTextStyling(
                    "Fill your Profile ",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,

                        )
                )
            }

            var text by remember { mutableStateOf("") }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                OutlinedTextField(

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 4.dp)
                        .weight(1f),
                    label = { Text(text = "First Name") },
                    placeholder = { Text(text = "First Name") },
                    value = firstName,
                    onValueChange = { firstName = it },
                            singleLine = true, maxLines = 1
                )

                OutlinedTextField(

                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    label = { Text(text = "Last Name") },
                    placeholder = { Text(text = "Last Name") },
                    value = lastName,
                    onValueChange = { lastName = it },
                    singleLine = true, maxLines = 1
                )
            }


            Spacer(modifier = Modifier.height(7.dp))

            OutlinedTextField(

                modifier = Modifier
                    .fillMaxWidth(),
                label = { Text(text = "Username(you can change this later)*") },
                placeholder = { Text(text = "Username") },
                value = userName,
                onValueChange = { userName = it },
                singleLine = true, maxLines = 1
            )


            Spacer(modifier = Modifier.height(7.dp))
            OutlinedTextField(

                modifier = Modifier
                    .fillMaxWidth(),
                label = { Text(text = "Email") },
                placeholder = { Text(text = "Email") },
                value = email,
                onValueChange = { email = it },
                singleLine = true, maxLines = 1
            )


        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .align(Alignment.BottomCenter),
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
//            horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Image(
                    painter = painterResource(id = R.drawable.logo_ic),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally)
                        .padding(top = 10.dp)
                        .height(85.dp),
                    colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ClickableText(
                        text = AnnotatedString("Back"),

                        style = TextStyle(
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
//                        textDecoration = TextDecoration.Underline
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .height(50.dp)
                            .padding(horizontal = 5.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#2D2D2F")),
                                RoundedCornerShape(25.dp)
                            )
                            .wrapContentHeight(),

                        onClick = {
//                            Toast.makeText(context, "its Back", Toast.LENGTH_LONG).show()


                        }
                    )
                    ClickableText(
                        text = AnnotatedString("Continue"),

                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
//                        textDecoration = TextDecoration.Underline
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .height(50.dp)
                            .padding(horizontal = 5.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#ffffff")),
                                RoundedCornerShape(25.dp)
                            )
                            .wrapContentHeight(),

                        onClick = {
                            focusManager.clearFocus()
                            if (firstName.isEmpty() || lastName.isEmpty()) {
                                Toast.makeText(
                                    context,
                                    "fields cannot be empty",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                Utilities.saveString(context,Utilities.F_NAME,firstName)
                                Utilities.saveString(context,Utilities.L_NAME,lastName)
                                Utilities.saveString(context,Utilities.USER_NAME,userName)
                                val intent = Intent(context, profiledetail::class.java)
                                context.startActivity(intent)
                            }
//                            val intent = Intent(context, profiledetail::class.java)
//                            context.startActivity(intent)
                        }
                    )
                    Spacer(modifier = Modifier.width(8.dp))


                }

            }

        }
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UhuntTheme {
        fillYourProifle()
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

@Composable
fun ImageClickableActivity(backDispatcher: OnBackPressedDispatcher) {

    Image(
        painter = painterResource(id = R.drawable.logo_ic),
        contentDescription = "Back Button",
        modifier = Modifier
            .padding(16.dp)
            .clickable(onClick = { backDispatcher.onBackPressed() }),
        contentScale = ContentScale.Crop,
    )
}


