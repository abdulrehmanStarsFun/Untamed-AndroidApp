package com.example.uhunt.landingActivities.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uhunt.R

@Composable
fun ErrorImageAuth(
    modifier: Modifier = Modifier,
    isImageValidate: Boolean
) {
    val context = LocalContext.current
    if (isImageValidate) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
//            Image(
//                painter = painterResource(id = R.drawable.logo_ic),
//                contentDescription = "Image Error",
//                modifier = modifier.size(250.dp)
//
//            )
            Toast.makeText(context, "Failed, Check your Credentials", Toast.LENGTH_SHORT).show()

        }
    }
}