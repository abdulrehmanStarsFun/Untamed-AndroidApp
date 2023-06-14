package com.example.uhunt.jet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uhunt.jet.theme.UhuntTheme
import kotlinx.coroutines.launch

class createscrean : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UhuntTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting5()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Greeting5() {

    val context = LocalContext.current.applicationContext

    val bottomSheetState =
        rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

    val coroutineScope = rememberCoroutineScope()

    ModalBottomSheetLayout(
        sheetContent = {
            Column(modifier = Modifier.background(Color.Black)) {
Row {
    Text(text = "Create",
    style = TextStyle(
        fontSize = 18.sp,

        color = Color.White,
    ) ,modifier = Modifier
        .weight(2f).padding(start = 10.dp)

        )

    Image(
        painter = painterResource(id = com.example.uhunt.R.drawable.cancle_ic),
        contentDescription = null,
        //modifier = HorizontalAlignment=Alignment.TopEnd
        modifier = Modifier
            .offset(x = 40.dp, y = 4.dp)
            .weight(1f)
    )

}//row 1
                Spacer(modifier = Modifier.height(10.dp))
                Row {

                    Image(
                        painter = painterResource(id = com.example.uhunt.R.drawable.create_ic),
                        contentDescription = null,
                        //modifier = HorizontalAlignment=Alignment.TopEnd
                        modifier = Modifier
                            .width(23.dp)
                            .height(20.dp)
                            .weight(0.5f)
                    )
                    Text(text = "Create a post",
                        style = TextStyle(
                            fontSize = 18.sp,
                            color = Color.White,
                        ) ,modifier = Modifier
                            .weight(3f)

                    )



                }//2
Spacer(modifier = Modifier.height(10.dp))
                Row {

                    Image(
                        painter = painterResource(id = com.example.uhunt.R.drawable.player),
                        contentDescription = null,
                        //modifier = HorizontalAlignment=Alignment.TopEnd
                        modifier = Modifier
                            .width(23.dp)
                            .height(20.dp)
                            .weight(0.5f)
                    )
                    Text(text = "Upload a video",
                        style = TextStyle(
                            fontSize = 18.sp,

                            color = Color.White,
                        ) ,modifier = Modifier
                            .weight(3f)

                    )



                }//3
                Spacer(modifier = Modifier.height(10.dp))
                Row {

                    Image(
                        painter = painterResource(id = com.example.uhunt.R.drawable.relatedvideo_ic),
                        contentDescription = null,
                        //modifier = HorizontalAlignment=Alignment.TopEnd
                        modifier = Modifier
                            .width(23.dp)
                            .height(20.dp)
                            .weight(0.5f)
                    )
                    Text(text = "Create a clip",
                        style = TextStyle(
                            fontSize = 18.sp,

                            color = Color.White,
                        ) ,modifier = Modifier
                            .weight(3f)

                    )



                }//4
                Spacer(modifier = Modifier.height(10.dp))

                Row {
                    Image(
                        painter = painterResource(id = com.example.uhunt.R.drawable.store_ic),
                        contentDescription = null,
                        //modifier = HorizontalAlignment=Alignment.TopEnd
                        modifier = Modifier
                            .width(23.dp)
                            .height(20.dp)
                            .weight(0.5f)
                    )
                    Text(text = "Sell something",
                        style = TextStyle(
                            fontSize = 18.sp,
                            color = Color.White,
                        ) ,modifier = Modifier
                            .weight(3f)

                    )



                }//5
                Spacer(modifier = Modifier.height(10.dp))
                Row {

                    Image(
                        painter = painterResource(id = com.example.uhunt.R.drawable.camvid_ic),
                        contentDescription = null,
                        //modifier = HorizontalAlignment=Alignment.TopEnd
                        modifier = Modifier
                            .width(23.dp)
                            .height(20.dp)
                            .weight(0.5f)
                    )

                    Text(text = "Add to your story",
                        style = TextStyle(
                            fontSize = 18.sp,

                            color = Color.White,
                        ) ,modifier = Modifier
                            .weight(3f)

                    )



                }//6
                Spacer(modifier = Modifier.height(10.dp))
                Row {

                    Image(
                        painter = painterResource(id = com.example.uhunt.R.drawable.podcast),
                        contentDescription = null,
                        //modifier = HorizontalAlignment=Alignment.TopEnd
                        modifier = Modifier
                            .width(23.dp)
                            .height(20.dp)
                            .weight(0.5f)
                    )

                    Text(text = "Upload a podcast",
                        style = TextStyle(
                            fontSize = 18.sp,

                            color = Color.White,
                        ) ,modifier = Modifier
                            .weight(3f)

                    )



                }//7
                Spacer(modifier = Modifier.height(10.dp))



                       }
},
sheetState = bottomSheetState
) {
    // app UI
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            coroutineScope.launch {
                bottomSheetState.show()
            }
        }) {
            Text(text = "Show Bottom Sheet")
        }
    }
}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview14() {
    UhuntTheme {
Greeting5()
    }
}