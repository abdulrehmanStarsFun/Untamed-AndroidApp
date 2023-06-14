package com.example.uhunt.landingActivities.otp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.FragmentActivity
import com.example.uhunt.R
import com.example.uhunt.jet.resetpass
import com.example.uhunt.jetpackClassess.DemoDataProvider
import com.example.uhunt.jetpackClassess.dialogs.DialogState
import com.example.uhunt.jetpackClassess.dialogs.DialogType

import com.example.uhunt.ui.activities.landing.ui.theme.UhuntTheme
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.yogeshpaliyal.speld.PinInput

class OtpActviity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UhuntTheme {
                Surface(
//                    modifier = Modifier.background(Color(0xFF000000))
                )
                {
//                    ImageClickableActivity(onBackPressedDispatcher)
                    logscreen()
                }
            }
        }
    }
}


@Composable
fun logscreen(

) {
    val username = remember { mutableStateOf(TextFieldValue()) }
    val username2 = remember { mutableStateOf(TextFieldValue()) }
    val username3 = remember { mutableStateOf(TextFieldValue()) }
    val username4 = remember { mutableStateOf(TextFieldValue()) }

    var dialogState by remember { mutableStateOf(DialogState(false, DialogType.SIMPLE)) }

    if (dialogState.showDialog) {
        //if state of show dialog changes to true it shows dialog passing state as false for dismiss
        ShowDialog(dialogState.dialogType) { dialogState = dialogState.copy(showDialog = false) }
    }
    Box(
        modifier = Modifier
//            .background(Color.Black)
            .fillMaxSize(),
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

                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically


            ) {
                SetTextStyling(
                    "Uhunt",
                    style = TextStyle(
                        fontSize = 20.sp,
//                        color = Color.White
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
                val currentActivity = remember {
                    context as? Activity
                }
                Image(
                    painter = painterResource(id = R.drawable.back_ic),
                    contentDescription = null,
                    modifier = Modifier
                        .wrapContentHeight()
                        .clickable {
//                            val intent = Intent(context, LoginActviity::class.java)
//                            context.startActivity(intent)
                            currentActivity?.finish()
                        }, colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground)

                )
                SetTextStyling(
                    "Verify Your Number ",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
//                        color = Color.White
                    )
                )
            }

            Spacer(modifier = Modifier.height(35.dp))
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(horizontal = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Code has been send to +1 111 ******99",
                    style = TextStyle(
                        fontSize = 15.sp,
//                        color = Color.White
                    ),
                    modifier = Modifier
                        .wrapContentHeight(),

                    textAlign = TextAlign.Center


                )
                Spacer(modifier = Modifier.height(20.dp))
                val focusManager = LocalFocusManager.current
                val otptext = remember { mutableStateOf("") }
                PinInput(
                    cellModifier = Modifier.border(
                        BorderStroke(2.dp, Color.DarkGray),
                        shape = RoundedCornerShape(3.dp)
                    ), value = otptext.value,
                    obscureText = "",
                    length = 4,
                    disableKeypad = false // Optional
                ) {
                    otptext.value = it
                }
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(top = 20.dp)
//                        .padding(horizontal = 10.dp),
//                    horizontalArrangement = Arrangement.SpaceEvenly
//                ) {
//                    val mMaxLength = 1
//                    TextField(
//                        placeholder = {
//                            Text(
//                                text = "*",
//                                color = Color.Gray, modifier = Modifier.align(Alignment.CenterVertically)
//                            )
//                        }, colors = TextFieldDefaults.textFieldColors(
//                            textColor = Color.White,
//                            cursorColor = Color.White,
//                            focusedIndicatorColor = Color.White,
//                            unfocusedIndicatorColor = Color.Transparent
//                        ),
//                        textStyle = TextStyle(color = Color.White),
//
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(horizontal = 10.dp)
//                            .weight(1f)
//
//                            .background(
//                                color = Color(android.graphics.Color.parseColor("#2D2D2F")),
//                                RoundedCornerShape(5.dp)
//                            ), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number,
//                            imeAction = ImeAction.Done
//                            ),
//
//                        keyboardActions = KeyboardActions(
//                            onNext = {
//                                focusManager.moveFocus(FocusDirection.Down)
//                            }
//                        ),
////                    label = { Text(text = "First Name*") },
//                        value = username.value,
//                        onValueChange = { if (it.text.length <= mMaxLength) username.value = it
//                        else Toast.makeText(context, "Cannot be more than 1 digit", Toast.LENGTH_SHORT).show()
//
//                                        },
//                        singleLine = true, maxLines = 1,
//
//                    )
//
//                    TextField(
//                        placeholder = {
//                            Text(
//                                text = "*",
//                                color = Color.Gray,
//                            )
//                        }, colors = TextFieldDefaults.textFieldColors(
//                            textColor = Color.White,
//                            cursorColor = Color.White,
//                            focusedIndicatorColor = Color.White,
//                            unfocusedIndicatorColor = Color.Transparent
//                        ),
//                        textStyle = TextStyle(color = Color.White),
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(horizontal = 10.dp)
//                            .weight(1f)
//                            .background(
//                                color = Color(android.graphics.Color.parseColor("#2D2D2F")),
//                                RoundedCornerShape(5.dp)
//                            ), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number,
//
//                            ),
////                    label = { Text(text = "First Name*") },
//                        value = username2.value,
//                        onValueChange = {if (it.text.length <= mMaxLength) username2.value = it
//                        else Toast.makeText(context, "Cannot be more than 1 digit", Toast.LENGTH_SHORT).show() },
//                        singleLine = true, maxLines = 1)
//
//                    TextField(
//                        placeholder = {
//                            Text(
//                                text = "*",
//                                color = Color.Gray
//                            )
//                        }, colors = TextFieldDefaults.textFieldColors(
//                            textColor = Color.White,
//                            cursorColor = Color.White,
//                            focusedIndicatorColor = Color.White,
//                            unfocusedIndicatorColor = Color.Transparent
//                        ),
//                        textStyle = TextStyle(color = Color.White),
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(horizontal = 10.dp)
//                            .weight(1f)
//                            .background(
//                                color = Color(android.graphics.Color.parseColor("#2D2D2F")),
//                                RoundedCornerShape(5.dp)
//                            ), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
////                    label = { Text(text = "First Name*") },
//                        value = username3.value,
//                        onValueChange = {if (it.text.length <= mMaxLength) username3.value = it
//                        else Toast.makeText(context, "Cannot be more than 1 digit", Toast.LENGTH_SHORT).show() },
//                        singleLine = true, maxLines = 1
//                    )
//
//
//                    TextField(
//                        placeholder = {
//                            Text(
//                                text = "*",
//                                color = Color.Gray
//                            )
//                        },
//                        colors = TextFieldDefaults.textFieldColors(
//                            textColor = Color.White,
//                            cursorColor = Color.White,
//                            focusedIndicatorColor = Color.White,
//                            unfocusedIndicatorColor = Color.Transparent
//                        ),
//                        textStyle = TextStyle(color = Color.White),
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(horizontal = 10.dp)
//                            .weight(1f)
//
//                            .background(
//                                color = Color(android.graphics.Color.parseColor("#2D2D2F")),
//                                RoundedCornerShape(5.dp)
//                            ), keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
////                    label = { Text(text = "Surname*")
////                            },
//                        value = username4.value,
//                        onValueChange = {if (it.text.length <= mMaxLength) username4.value = it
//                        else Toast.makeText(context, "Cannot be more than 1 digit", Toast.LENGTH_SHORT).show()},
//                        singleLine = true, maxLines = 1
//
//                    )
//                }
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Didn't you received any code?",
                    style = TextStyle(
                        fontSize = 17.sp,
//                        color = Color.White
                    ),
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(horizontal = 10.dp),
                    textAlign = TextAlign.Center


                )
                Spacer(modifier = Modifier.height(15.dp))
                Text(
                    text = "Resend a new code.",
                    style = TextStyle(
                        fontSize = 18.sp,
                        color = Color(0xFF2967FF)
                    ),
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(horizontal = 10.dp),
                    textAlign = TextAlign.Center


                )
                Spacer(modifier = Modifier.height(16.dp))
//                ClickableText(
//                    text = AnnotatedString("Verify"),
//
//                    style = TextStyle(
//                        color = Color.Black,
//                        fontSize = 16.sp,
//                        fontWeight = FontWeight.Bold,
//                        textAlign = TextAlign.Center
////                        textDecoration = TextDecoration.Underline
//                    ),
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(40.dp)
//                        .padding(horizontal = 45.dp)
//                        .background(
//                            color = Color(android.graphics.Color.parseColor("#ffffff")),
//                            RoundedCornerShape(25.dp)
//                        )
//                        .wrapContentHeight(),
//
//                    onClick = {
//                        dialogState = DialogState(true, DialogType.LONGDIALOG)
//                    }
//                )

                val buttonColors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primary,
                    contentColor = MaterialTheme.colors.onPrimary
                )
                Button(

                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .height(45.dp)
                        .padding(horizontal = 45.dp)
                        .align(alignment = Alignment.CenterHorizontally),


                    onClick = {
//                        dialogState = DialogState(true, DialogType.LONGDIALOG)
                        if (("${otptext.value}").length < 4){

                            Toast.makeText(context,"4 digit Pin required",Toast.LENGTH_LONG).show()

                        }  else if (("${otptext.value}").length == 4){
                        val intent=Intent(context,resetpass::class.java)
                        context.startActivity(intent)
                    }else{
                            Toast.makeText(context,"Enter Correct Pin",Toast.LENGTH_LONG).show()
                        }


                    },
//                    colors = ButtonDefaults.buttonColors(
//                        backgroundColor = Color.White,
//                        contentColor = Color.Black
//                    ),
                    colors=buttonColors,

                    shape = RoundedCornerShape(20.dp),

                    ) {
                    Text(
                        text = "Verify",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.Serif
                    )
                }
            }


        }

    }


}

@Composable
fun ShowDialog(type: DialogType, onDismiss: () -> Unit) {
    val item = remember { DemoDataProvider.item }
    var dialogState by remember { mutableStateOf(DialogState(false, DialogType.SIMPLE)) }

    if (dialogState.showDialog) {
        //if state of show dialog changes to true it shows dialog passing state as false for dismiss
        ShowDialog(dialogState.dialogType) { dialogState = dialogState.copy(showDialog = false) }
    }
    when (type) {
        DialogType.SIMPLE ->
            AlertDialog(
                text = {
                    Text(item.subtitle)
                },
                confirmButton = {
                    TextButton(
                        onClick = onDismiss,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(text = "Ok")
                    }
                },
                onDismissRequest = onDismiss
            )
        DialogType.TITLE ->
            AlertDialog(
                title = { Text(text = item.title, style = typography.h6) },
                text = {
                    Text(item.subtitle)
                },
                confirmButton = {
                    Row(modifier = Modifier) {
                        TextButton(
                            onClick = onDismiss,
                            modifier = Modifier.padding(4.dp)
                        ) {
                            Text(text = "Cancel", color = Color.Gray)
                        }
                        TextButton(
                            onClick = onDismiss,
                            modifier = Modifier.padding(4.dp)
                        ) {
                            Text(text = "Ok")
                        }
                    }
                },
                onDismissRequest = onDismiss
            )
        DialogType.VERTICALBUTTON ->
            AlertDialog(
                title = { Text(text = item.title, style = typography.h6) },
                text = {
                    Text(item.subtitle)
                },
                confirmButton = {
                    OutlinedButton(
                        onClick = onDismiss,
                        modifier = Modifier
                            .padding(8.dp)
                            .width(100.dp)
                    ) {
                        Text(text = "Cancel")
                    }
                    Button(
                        onClick = onDismiss,
                        modifier = Modifier
                            .padding(8.dp)
                            .width(100.dp)
                    ) {
                        Text(text = "Ok")
                    }
                },
                onDismissRequest = onDismiss
            )
        DialogType.IMAGE ->
            AlertDialog(
                title = { Text(text = item.title, style = typography.h6) },
                text = {
                    Text(item.subtitle, modifier = Modifier.padding(bottom = 8.dp))
                    Image(
                        painter = painterResource(DemoDataProvider.item.imageId),
                        contentDescription = null
                    )
                },
                confirmButton = {
                    TextButton(
                        onClick = onDismiss,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(text = "Ok")
                    }
                },
                onDismissRequest = onDismiss
            )
        DialogType.LONGDIALOG ->
            AlertDialog(
                title = { Text(text = "", style = typography.h6) },
                text = {
                    Column(
                        modifier = Modifier
                            .wrapContentHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("", modifier = Modifier.padding(bottom = 0.dp))
                        Image(
                            painter = painterResource(id = R.drawable.conratulation_ic),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .align(alignment = Alignment.CenterHorizontally)
//                                .padding(top = 10.dp)
                        )
                        Text(
                            text = "Congratulations! ",
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                color = Color.Black, fontFamily = FontFamily.Serif,
                            ),
                            modifier = Modifier
                                .wrapContentHeight()
                                .padding(top = 10.dp),
                            textAlign = TextAlign.Center


                        )
                        Text(
                            text = "Your account is ready to use. You will be redirected to the Home page in a few seconds..",
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = Color.Gray, fontFamily = FontFamily.Serif
                            ),
                            modifier = Modifier
                                .wrapContentHeight()
                                .padding(top = 10.dp),
                            textAlign = TextAlign.Center


                        )
//                        Spacer(modifier = Modifier.height(10.dp))

                        Image(
                            painter = painterResource(id = R.drawable.progress_dialog),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .align(alignment = Alignment.CenterHorizontally)
                                .padding(top = 10.dp)
                        )
                        Spacer(modifier = Modifier.height(15.dp))
//                        Button(
//
//                            modifier = Modifier
////                                .padding(10.dp)
//                                .fillMaxWidth()
//                                .height(45.dp)
//                                .padding(horizontal = 25.dp)
//                                .align(alignment = Alignment.CenterHorizontally),
//
//
//                            onClick = {
//                                dialogState = dialogState.copy(showDialog = false)
//                            },
//                            colors = ButtonDefaults.buttonColors(
//                                backgroundColor = Color.Black,
//                                contentColor = Color.White
//                            ),
//                            shape = RoundedCornerShape(20.dp),
//
//                            ) {
//                            Text(
//                                text = "OK",
//                                fontSize = 16.sp,
//                                fontWeight = FontWeight.Bold,
//                                fontFamily = FontFamily.Serif
//                            )
//                        }

                    }
                },

                confirmButton = {
//                    TextButton(
//                        onClick = onDismiss,
//                        modifier = Modifier.padding(8.dp)
//                    ) {
//                        Text(text = "Ok")
//                    }
                },
                onDismissRequest = onDismiss,
                shape = RoundedCornerShape(25.dp)
            )
        DialogType.ROUNDED ->
            AlertDialog(
                title = { Text(text = item.title, style = typography.h6) },
                text = {
                    Column {
                        Text(item.subtitle, modifier = Modifier.padding(bottom = 8.dp))
                        Image(
                            painter = painterResource(DemoDataProvider.item.imageId),
                            contentDescription = null,
                            modifier = Modifier.clip(RoundedCornerShape(16.dp))
                        )
                    }
                },
                confirmButton = {
                    TextButton(
                        onClick = onDismiss,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(text = "Ok")
                    }
                },
                onDismissRequest = onDismiss,
                shape = RoundedCornerShape(16.dp)
            )
        DialogType.DATEPICKER -> {
            val context = LocalContext.current
            (context as? FragmentActivity)?.supportFragmentManager?.let { manager ->

                val builder = MaterialDatePicker.Builder.datePicker()
                    .build()

                builder.addOnPositiveButtonClickListener { selectedDate ->

                }
                builder.addOnDismissListener {
                    onDismiss()
                }
                builder.show(manager, "DatePicker")
            }
        }

        DialogType.TIMEPICKER -> {
            val context = LocalContext.current
            (context as? FragmentActivity)?.supportFragmentManager?.let { manager ->
                val builder = MaterialTimePicker.Builder()
                    .build()
                builder.addOnPositiveButtonClickListener {

                }
                builder.addOnDismissListener {
                    onDismiss.invoke()
                }
                builder.show(manager, "TimePicker")
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
//fun ImageClickableActivity(backDispatcher: OnBackPressedDispatcher) {
//
//    Image(
//        painter = painterResource(id = R.drawable.logo_ic),
//        contentDescription = "Back Button",
//        modifier = Modifier
//            .padding(16.dp)
//            .clickable(onClick = { backDispatcher.onBackPressed() }),
//        contentScale = ContentScale.Crop,
//    )
//}

@Composable
fun PinView(onPinEntered: (String) -> Unit) {
    var pin by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Enter your PIN", style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            for (i in 0..3) {
                PinDigit(
                    value = pin.getOrNull(i)?.toString() ?: "",
                    onDigitEntered = { digit ->
                        pin = pin.take(i) + digit + pin.drop(i + 1)
                        if (i == 3) {
                            onPinEntered(pin)
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun PinDigit(
    value: String,
    onDigitEntered: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onDigitEntered,
        label = { Text(text = "PIN") },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        visualTransformation = PasswordVisualTransformation(),
        singleLine = true,
        maxLines = 1,
        modifier = Modifier.width(64.dp)
    )
}


