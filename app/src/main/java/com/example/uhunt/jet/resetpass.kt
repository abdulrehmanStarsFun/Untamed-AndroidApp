package com.example.uhunt.jet

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
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
import androidx.fragment.app.FragmentActivity
import com.example.uhunt.R
import com.example.uhunt.jet.theme.UhuntTheme
import com.example.uhunt.jetpackClassess.DemoDataProvider
import com.example.uhunt.jetpackClassess.dialogs.DialogState
import com.example.uhunt.jetpackClassess.dialogs.DialogType
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker

class resetpass : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UhuntTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),

                ) {
                    reset()
                }
            }
        }
    }
}

@Composable
fun reset(){
    var dialogState by remember { mutableStateOf(DialogState(false, DialogType.SIMPLE)) }
    val context= LocalContext.current

    Column (
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())

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
//                                ,color = Color.White,
                    )
                )
                Image(
                    painter = painterResource(id = R.drawable.helpchat),
                    contentDescription = null,
                    modifier = Modifier.size(21.dp, 17.dp)

                )
            }//first row

        }//first row's box

        Spacer(modifier = Modifier.height(20.dp))

        Box (modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()){
            Row(
                modifier = Modifier
                    .padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically
//                    .fillMaxWidth()

            ) {

                Image(
                    painter = painterResource(id = R.drawable.arrow),
                    contentDescription = null,
                    modifier = Modifier.size(28.dp, 28.dp), colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground)

                )
                SetTextStyling(
                    "Reset Your Password",
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold))
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
        "Create Your New Password",
        style = TextStyle(
            fontSize = 18.sp,
            fontFamily = FontFamily(Font(R.font.roboto_medium))
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
        label = { Text(text = "Enter New Password") },
        placeholder = { Text(text = "Password") },
//        colors = TextFieldDefaults.outlinedTextFieldColors(
//            focusedLabelColor = Color.White,
//    unfocusedLabelColor = Color.White,
//            focusedBorderColor =Color.White ,
//           unfocusedBorderColor =Color.White,
//            textColor = Color.White, leadingIconColor = Color.White
//    ),
        colors=textFieldColors,
        onValueChange = {
            text = it
        },
        singleLine = true, maxLines = 1
    )
    Spacer(modifier = Modifier.height(20.dp))

    OutlinedTextField(
        value = text,
        leadingIcon = { Icon(imageVector = Icons.Default.Lock,
            contentDescription = null) },
        modifier = Modifier
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        label = { Text(text = "Re-Enter Password") },
        placeholder = { Text(text = "Re-Enter Password") },
//        colors = TextFieldDefaults.outlinedTextFieldColors(
//            focusedLabelColor = Color.White,
//            unfocusedLabelColor = Color.White,
//            focusedBorderColor =Color.White ,
//            unfocusedBorderColor =Color.White,
//            textColor = Color.White,leadingIconColor = Color.White
//        ),
        colors=textFieldColors,
        onValueChange = {
            text = it
        },
        singleLine = true, maxLines = 1
    )
    Spacer(modifier = Modifier.width(30.dp))

    var isChecked by remember { mutableStateOf(false) }
Row(
    horizontalArrangement = Arrangement.Center,
    verticalAlignment = Alignment.CenterVertically,
    modifier = Modifier.fillMaxWidth()
){
    Checkbox(
        checked = isChecked,
        onCheckedChange = { isChecked = it },
        modifier = Modifier
            .padding(16.dp),

//
//                CheckboxDefaults.colors(
//                checkedColor = Color.Black,
//        uncheckedColor = Color.White,
//        checkmarkColor = Color.Black

    )



    Spacer(modifier = Modifier.height(20.dp))
    SetTextStyling(
        "Remember me",
        style = TextStyle(
            fontSize = 18.sp,
           fontFamily = FontFamily(Font(R.font.roboto_regular))
        )
    )

}

    Spacer(modifier = Modifier.width(30.dp))

    val buttonColors = ButtonDefaults.buttonColors(
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary
    )
    Button(

        modifier = Modifier
            .padding(10.dp)
            .align(alignment = Alignment.CenterHorizontally)
            .fillMaxWidth()
            .height(50.dp),
        onClick = {

            dialogState = DialogState(true, DialogType.LONGDIALOG)

//            val intent= Intent(context,profiledetail::class.java)
//            context.startActivity(intent)

        },
        colors=buttonColors,
        shape = RoundedCornerShape(25.dp)
    ) {
        Text(text = "Continue")
    }
}//third box colum

        }//third box

    }//main colum

}
@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    UhuntTheme {
      reset()
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
                title = { Text(text = item.title, style = MaterialTheme.typography.h6) },
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
                title = { Text(text = item.title, style = MaterialTheme.typography.h6) },
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
                title = { Text(text = item.title, style = MaterialTheme.typography.h6) },
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
                title = { Text(text = "", style = MaterialTheme.typography.h6) },
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
                title = { Text(text = item.title, style = MaterialTheme.typography.h6) },
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