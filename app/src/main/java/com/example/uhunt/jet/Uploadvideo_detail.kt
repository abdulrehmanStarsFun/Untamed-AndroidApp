package com.example.uhunt.jet

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uhunt.R
import com.example.uhunt.SharedPref.Utilities
import com.example.uhunt.jet.ui.theme.UhuntTheme

class Uploadvideo_detail : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UhuntTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
detail()
                }
            }
        }
    }
}

@Composable
fun detail(){
    val context= LocalContext.current
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()){
        Column() {
Row {
    IconButton(onClick = { /*TODO*/ }, modifier = Modifier.weight(0.5f)) {
        Icon(painter = painterResource(id = R.drawable.back_ic),
            contentDescription = null,

            )
    }
    
    Text(text = "Upload your video",
        style = TextStyle(
            fontSize = 25.sp,
            fontFamily = FontFamily(Font(R.font.roboto_bold))
        ), modifier = Modifier
            .weight(2f)
            .align(Alignment.CenterVertically)
        )

    IconButton(onClick = { /*TODO*/ }, modifier = Modifier.weight(0.5f)) {
        Icon(painter = painterResource(id = R.drawable.close_ic),
            contentDescription = null,

            )
    }

}
            Column(
                modifier = Modifier.padding(start = 20.dp,end=20.dp)
            )

            {
                var listname by rememberSaveable{ mutableStateOf(value = "") }
                var price by rememberSaveable{ mutableStateOf(value = "") }
                var condition by rememberSaveable{ mutableStateOf(value = "") }
                var location by rememberSaveable{ mutableStateOf(value = "") }
                var category by rememberSaveable{ mutableStateOf(value = "") }
                var number by rememberSaveable{ mutableStateOf(value = "") }


                Text(text = "Listing Name",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold))
                    ), modifier = Modifier.padding(top = 10.dp)


                )

                OutlinedTextField(

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                        .align(alignment = Alignment.CenterHorizontally),
                    label = { androidx.compose.material.Text(text = "Listing Name") },
                    placeholder = { androidx.compose.material.Text(text = "Enter Listing Name") },
                    value = listname,
                    onValueChange = { listname = it },
                    singleLine = true, maxLines = 1
                )
                Row() {
                    OutlinedTextField(

                        modifier = Modifier
                            .padding(top = 10.dp, end = 5.dp).weight(0.8f),

                        label = { androidx.compose.material.Text(text = "Enter Price $") },
                        placeholder = { androidx.compose.material.Text(text = "Enter Price $") },
                        value = price,
                        onValueChange = { price = it },
                        singleLine = true, maxLines = 1
                    )

                    OutlinedTextField(

                        modifier = Modifier
                            .padding(top = 10.dp).weight(1.2f),

                        label = { androidx.compose.material.Text(text = "Select New or Use") },
                        placeholder = { androidx.compose.material.Text(text = "Select New or Use") },
                        value = condition,
                        onValueChange = { condition = it },
                        singleLine = true, maxLines = 1
                    )
                }

                OutlinedTextField(

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)

                        .align(alignment = Alignment.CenterHorizontally),
                    leadingIcon = {
                                  Icon(painter = painterResource(id = R.drawable.mapmark_ic), contentDescription =null )
                    },
                    label = { androidx.compose.material.Text(text = "Location") },
                    placeholder = { androidx.compose.material.Text(text = "Lsiting Location") },
                    value = location,
                    onValueChange = { location = it },
                    singleLine = true, maxLines = 1
                )
                OutlinedTextField(

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)

                        .align(alignment = Alignment.CenterHorizontally),
                    leadingIcon = {
                        Icon(painter = painterResource(id = R.drawable.list_ic), contentDescription = null)
                    },
                    label = { androidx.compose.material.Text(text = "category") },
                    placeholder = { androidx.compose.material.Text(text = "Select Category") },
                    value = category,
                    onValueChange = { category = it },
                    singleLine = true, maxLines = 1
                )
                OutlinedTextField(

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)

                        .align(alignment = Alignment.CenterHorizontally),
                    label = { androidx.compose.material.Text(text = "Phone Number") },
                    placeholder = { androidx.compose.material.Text(text = "Enter Your Phone Number(Optional)") },
                    value = number,
                    onValueChange = { number = it },
                    singleLine = true, maxLines = 1
                )
                Spacer(modifier = Modifier.height(30.dp))
                ClickableText(
                    text = AnnotatedString("NEXT"),
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
                        .wrapContentHeight(),
//                    .align(Alignment.CenterVertically),

                    onClick = {

                    }




                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview5() {
    UhuntTheme {
detail()
    }
}