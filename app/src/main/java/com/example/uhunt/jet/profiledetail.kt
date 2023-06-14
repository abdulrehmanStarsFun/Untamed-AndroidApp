package com.example.uhunt.jet


import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import androidx.core.net.toUri
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.example.composephoto.camera.CameraCapture
import com.example.composephoto.gallery.GallerySelect
import com.example.uhunt.R
import com.example.uhunt.SharedPref.Utilities
import com.example.uhunt.customWidgets.myButton
import com.example.uhunt.galleryPickers.getFileFromUri
import com.example.uhunt.jet.tiktokclassess.countrypicker.CountryPicker
import com.example.uhunt.jet.tiktokclassess.countrypicker.getListOfCountries
import com.example.uhunt.jet.theme.UhuntTheme
import com.example.uhunt.landingActivities.otp.OtpActviity
import com.example.uhunt.viewmodel.FillYourProfileViewModel
import com.example.uhunt.viewmodel.LoginViewModel
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import java.io.File


class profiledetail : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UhuntTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {

                    val loginViewModel: LoginViewModel by viewModels()
                    Greeting3(Modifier.fillMaxSize(), loginViewModel)

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalPermissionsApi::class)
@Composable
fun Greeting3(
    modifier: Modifier, loginViewModel: LoginViewModel
) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    val currentActivity = remember {
        context as? Activity
    }
    val listItems = arrayOf("+92", "+91", "+93", "+77")
    val listItems2 = arrayOf("Gender", "Male", "Female", "Other")
    val contextForToast = LocalContext.current.applicationContext
    val emailString = Utilities.getString(context, Utilities.EMAIL)
    val firstName = Utilities.getString(context, Utilities.F_NAME)
    val lastName = Utilities.getString(context, Utilities.L_NAME)
    val userName = Utilities.getString(context, Utilities.USER_NAME)
    var showGallerySelect by remember { mutableStateOf(false) }
    var imageUri by remember { mutableStateOf(EMPTY_IMAGE_URI) }
    var phoneNumber by rememberSaveable { mutableStateOf(value = "") }
    var accessToken = "15dd609a0c263c38c8698d0ef535ce8124c17626ceef1c8417466ae9434ae2c790aca9fb54684175fc2e6a440b94f64831840137698021e1"
    val placeholderPainter = painterResource(R.drawable.profilepic)
    val viewModel = viewModel(FillYourProfileViewModel::class.java)
    var getGender by rememberSaveable { mutableStateOf(value = "") }
    loginViewModel.tokenData.observe(lifecycleOwner) { loginResponse ->
        // Handle the token data here
        loginResponse?.let { tokenDto ->
            val userData = tokenDto.user_data
//            accessToken = tokenDto.access_token
            val userId = userData.user_id
            Toast.makeText(context, userId + "\n" + accessToken, Toast.LENGTH_LONG).show()
            // Use the token data as needed
            // For example, you can save it to SharedPref or perform other actions
//            UserDataManager.saveUserData(context, accessToken, userId)
        }
    }
    // state of the menu
    var expanded by remember {
        mutableStateOf(false)
    }

    var expanded2 by remember {
        mutableStateOf(false)
    }

    // remember the selected item
    var selectedItem by remember {
        mutableStateOf(listItems[0])
    }
    var selectedItem2 by remember {
        mutableStateOf(listItems2[0])
    }
    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        val context = LocalContext.current
        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight()
                .fillMaxWidth()

        ) {


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
                    )
                )
                Image(
                    painter = painterResource(id = R.drawable.helpchat),
                    contentDescription = null,
                    modifier = Modifier.size(21.dp, 17.dp)

                )
            }//first row


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
//                    .fillMaxWidth()

                ) {

                    Image(
                        painter = painterResource(id = R.drawable.arrow),
                        contentDescription = null,
                        modifier = Modifier.size(28.dp, 28.dp),
                        colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground)

                    )
                    SetTextStyling(
                        "Fill Your Profile",
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontFamily = FontFamily(Font(R.font.roboto_bold))
                        )
                    )
                }

            }//second row box
            Spacer(modifier = Modifier.height(30.dp))

            Box(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                contentAlignment = Alignment.TopCenter
            ) {

                if (imageUri != EMPTY_IMAGE_URI) {
                    Image(
                        painter = rememberImagePainter(imageUri),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(120.dp)
                            .width(120.dp)
                            .clip(CircleShape)
                            .clickable(
                                enabled = true,
                                onClickLabel = "Clickable image",
                                onClick = {
                                    showGallerySelect = true
                                }
                            )
                    )
                } else {
                    Image(
                        painter = painterResource(R.drawable.profilepic),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(120.dp)
                            .width(120.dp)
                            .clip(CircleShape)
                            .clickable(
                                enabled = true,
                                onClickLabel = "Clickable image",
                                onClick = {
                                    showGallerySelect = true
                                }
                            )
                    )
                }
                if (showGallerySelect) {
                    GallerySelect(
                        modifier = modifier,
                        onImageUri = { uri ->
                            showGallerySelect = false
                            imageUri = uri
                        }
                    )
//
                } else {

                    Image(
                        painter = painterResource(R.drawable.editprofileimage),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(top = 85.dp, start = 85.dp)
                            .height(40.dp)
                            .width(40.dp)
                            .padding(0.dp)
                            .clickable(
                                enabled = true,
                                onClickLabel = "Clickable image",
                                onClick = {
                                    showGallerySelect = true
                                }
                            )

                    )
//                        Box(modifier = modifier) {
//                            CameraCapture(
//                                modifier = modifier,
//                                onImageFile = { file ->
//                                    imageUri = file.toUri()
//                                }
//                            )
//                            Button(
//                                modifier = Modifier
//                                    .align(Alignment.TopCenter)
//                                    .padding(4.dp),
//                                onClick = {
//                                    showGallerySelect = true
//                                }
//                            ) {
//                                Text("Select from Gallery")
//                            }
//                        }
                }
//                }


            }
            Spacer(modifier = Modifier.height(60.dp))
            Row(

                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,

                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()


                    .padding(PaddingValues(start = 25.dp, end = 25.dp))
            ) {

                val countryCode = CountryPicker()
                countryCode.CountryCodeDialog(
                    pickedCountry = {
                        Log.v("TAG", "country name is : ${it.countryName}")
                    },
                    defaultSelectedCountry = getListOfCountries().single { it.countryCode == "ir" },
                    dialogSearch = true,
                    dialogRounded = 22, modifier = Modifier
                        .weight(1f)
                        .height(50.dp)

                )

                val textFieldColors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = MaterialTheme.colors.primary,
                    unfocusedBorderColor = MaterialTheme.colors.onSurface.copy(alpha = 0.12f),
                    textColor = MaterialTheme.colors.onSurface,
                    backgroundColor = MaterialTheme.colors.surface,
                )
                OutlinedTextField(
                    value = phoneNumber,
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = null,
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .weight(5f),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    label = { Text(text = "Phone Number") },
                    placeholder = { Text(text = "Number") },
//                colors = TextFieldDefaults.outlinedTextFieldColors(
//                    focusedLabelColor = Color.White,
//                    unfocusedLabelColor = Color.White,
//                    focusedBorderColor =Color.White ,
//                    unfocusedBorderColor =Color.White,
//                    textColor = Color.White, leadingIconColor = Color.White
//                ),
                    colors = textFieldColors,
                    onValueChange = {
                        phoneNumber = it
                    }
                )

            }
            val isProgressBarVisible by viewModel.progressBar

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

            Spacer(modifier = Modifier.height(15.dp))

            Box(modifier = Modifier.padding(PaddingValues(start = 10.dp, end = 10.dp))) {
                Text(
                    text = "You will use this number to login or to reset your password." +
                            "It is also used to verify that your a real human & not a bot. ",
                    fontSize = 14.sp
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Box(modifier = Modifier.padding(PaddingValues(start = 20.dp, end = 20.dp))) {


                // box
                ExposedDropdownMenuBox(modifier = Modifier.background(
                    Color(
                        android.graphics.Color.parseColor(
                            "#1B1B1B"
                        )
                    )
                ),
                    expanded = expanded2,
                    onExpandedChange = {
                        expanded2 = !expanded2
                    }
                ) {
                    // text field
                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(android.graphics.Color.parseColor("#1B1B1B"))),
                        value = selectedItem2,
                        onValueChange = {},
                        readOnly = true,
//                    label = { Text(text = "Gender", color = Color.White) },
                        trailingIcon = {
                            Icon(
                                Icons.Filled.ArrowDropDown,
                                contentDescription = "Clear",
                                tint = Color.White// or any other color you want
                            )
                            ExposedDropdownMenuDefaults.TrailingIcon(
                                expanded = expanded2
                            )
                        },
                        colors = ExposedDropdownMenuDefaults.textFieldColors(
                            Color(
                                android.graphics.Color.parseColor(
                                    "#ffffff"
                                )
                            )
                        )
                    )

                    // menu
                    ExposedDropdownMenu(
//                    modifier = Modifier.
//                    background(Color(android.graphics.Color.parseColor("#2D2D2F"))),
                        expanded = expanded2,
                        onDismissRequest = { expanded2 = false }
                    ) {
                        // this is a column scope
                        // all the items are added vertically
                        listItems2.forEach { selectedOption ->
                            // menu item
                            DropdownMenuItem(
                                onClick = {
                                    getGender = selectedOption
                                    selectedItem2 = selectedOption
                                    Toast.makeText(
                                        contextForToast,
                                        getGender,
                                        Toast.LENGTH_SHORT
                                    ).show()

                                    expanded2 = false
                                }) {
                                Text(
                                    text = selectedOption,
                                    //Change the text color here
                                    fontSize = 16.sp,
                                )
                            }
                        }
                    }
                }
            }

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
//                        Toast.makeText(context, "its Back", Toast.LENGTH_LONG).show()

//                            val intent = Intent(context, createscrean::class.java)
//                            context.startActivity(intent)
                            currentActivity?.finish()


                        }
                    )
                    val buttonColors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.primary,
                        contentColor = MaterialTheme.colors.onPrimary
                    )
                    ClickableText(
                        text = AnnotatedString("Continue"),

                        style = TextStyle(

                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
color = if (isSystemInDarkTheme()){
     Color.Black
}else{
    Color.White
}
//                        textDecoration = TextDecoration.Underline
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .height(50.dp)
                            .padding(horizontal = 5.dp)
                            .background(
                                color = androidx.compose.material.MaterialTheme.colors.onBackground,
                                RoundedCornerShape(25.dp)
                            )
                            .wrapContentHeight(),

                        onClick = {
//                            if (EMPTY_IMAGE_URI != null) {
//                                val file = getFileFromUri(context, imageUri)
//                              Toast.makeText(context,"Something went wrong",Toast.LENGTH_LONG).show()

                            viewModel.fillDataApi(
                                firstName, lastName, userName, getGender,
                              phoneNumber, accessToken
                            )
//
//                            val intent = Intent(context, OtpActviity::class.java)
//                            context.startActivity(intent)

                            //  Toast.makeText(context,"bottomsheet",Toast.LENGTH_LONG).show()
//val intent=Intent(context,bot::class.java)
//                        context.startActivity(intent)
//                            } else {
//                                Toast.makeText(context, "chhose profile image", Toast.LENGTH_LONG)
//                                    .show()
//
//                            }
                        }
                    )
                    Spacer(modifier = Modifier.width(8.dp))


                }

            }

        }
    }
    if (viewModel.successMessage.value != null) {
        Toast.makeText(context, "" + viewModel.successMessage.value, Toast.LENGTH_SHORT).show()

//        LaunchedEffect(key1 = scaffoldState.snackbarHostState) {
//            scaffoldState.snackbarHostState.showSnackbar(signUpViewModel.errorMessage.value!!)
//        }
    }
    val isProgressBarVisible by viewModel.progressBar
    if (isProgressBarVisible) {
        AlertDialog(
            onDismissRequest = { /* Disable dismiss on outside touch */ },
            properties = DialogProperties(dismissOnBackPress = false),
            title = { Text(text = "User Signing Up") },
            text = { Text(text = "Please wait...") },
            buttons = {
            }
        )
    }
    if (viewModel.errorMessage.value != null) {
        Toast.makeText(context, "" + viewModel.errorMessage.value, Toast.LENGTH_SHORT).show()
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    UhuntTheme {
//        val loginViewModel: LoginViewModel by viewModels()
//        Greeting3(Modifier.fillMaxSize())
    }
}

@Composable
fun MainCountryPicker() {
    val countryCode = CountryPicker()
    countryCode.CountryCodeDialog(
        pickedCountry = {
            Log.v("TAG", "country name is : ${it.countryName}")
        },
        defaultSelectedCountry = getListOfCountries().single { it.countryCode == "ir" },
        dialogSearch = true,
        dialogRounded = 22
    )
}

val EMPTY_IMAGE_URI: Uri = Uri.parse("file://dev/null")



