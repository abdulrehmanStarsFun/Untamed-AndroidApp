package com.example.uhunt.landingActivities.homePlaytube

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uhunt.R
import com.example.uhunt.landingActivities.tikTok.TiktokActivity
import com.example.uhunt.ui.activities.landing.menu
import com.example.uhunt.ui.activities.landing.menus


@Composable
fun BottomNavigationWithLabelComponent() {
    var selectedItem by remember { mutableStateOf(0) }
    val context= LocalContext.current
    val items = listOf("Home", "Shop", "TV", "Menu")

    // BottomNavigation is a Composable that is used to give easy access to some items
    // and are placed at the bottom of the screen so that the user can easily navigate
    // by clicking the items of the BottomNavigation

    BottomNavigation (
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth(),
        backgroundColor = Color.Black,
        contentColor = Color.White,
            ){
        BottomNavigationItem(
            selected = false, // Set the appropriate selected state for active item
            onClick = { /* Handle item click */
                val intent=Intent(context, MainPlayTubeActviity::class.java)
                context.startActivity(intent)
                      },
            icon = { Icon(painterResource(id = R.drawable.home), contentDescription = null) },
            label = { Text(text = "Home") },
            alwaysShowLabel = true, // Set it to true if you want to always show the labels
//            selectedContentColor = /* Set the color for the selected icon and label */,
//            unselectedContentColor = /* Set the color for the unselected icon and label */,
//            modifier = /* Add any additional modifier if needed */
        )

        BottomNavigationItem(
            selected = false,
            onClick = { /* Handle item click */ },
            icon = { Icon(painterResource(id = R.drawable.shop_menu), contentDescription = null) },
            label = { Text(text ="Shop") },
            alwaysShowLabel = true,
//            selectedContentColor = /* Set the color for the selected icon and label */,
//            unselectedContentColor = /* Set the color for the unselected icon and label */,
//            modifier = /* Add any additional modifier if needed */
        )

        BottomNavigationItem(
            selected = false,
            onClick = { /* Handle item click */ },
            icon = { Icon(painterResource(id = R.drawable.pl), contentDescription = null,
            modifier = Modifier.padding(top = 30.dp)
                ) },
            label = { Text(text ="") },
            alwaysShowLabel = true,
//            selectedContentColor = /* Set the color for the selected icon and label */,
//            unselectedContentColor = /* Set the color for the unselected icon and label */,
//            modifier = /* Add any additional modifier if needed */
        )

        BottomNavigationItem(
            selected = false,
            onClick = { /* Handle item click */
                val intent=Intent(context,MainPlayTubeActviity::class.java)
                context.startActivity(intent)
                      },
            icon = { Icon(painterResource(id = R.drawable.television_black), contentDescription = null) },
            label = { Text(text = "Tv") },
            alwaysShowLabel = true,
//            selectedContentColor = /* Set the color for the selected icon and label */,
//            unselectedContentColor = /* Set the color for the unselected icon and label */,
//            modifier = /* Add any additional modifier if needed */
        )

        BottomNavigationItem(
            selected = false,
            onClick = { /* Handle item click */
                val intent=Intent(context, menu()::class.java)
                context.startActivity(intent)
//
                      },
            icon = { Icon(painterResource(id = R.drawable.menu_bottom), contentDescription = null) },
            label = { Text(text = "Menu") },
            alwaysShowLabel = true,

        )
    }

//    BottomNavigation(
//        modifier = Modifier
//            .height(60.dp)
//            .fillMaxWidth(),
//        backgroundColor = Color.Black,
//        contentColor = Color.White,
//
//        ) {
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
//            onClick = { val intent=Intent(context, MainPlayTubeActviity::class.java)
//                context.startActivity(intent) }
//        )
//        BottomNavigationItem(
//            icon = {
//
//                Image(
//                    painter = painterResource(id = R.drawable.shop_menu),
//                    contentDescription = null,
//
//                    )
//
//
//            }, label = { Text("Shop") },
//            selected = false,
//            onClick = { /*TODO*/ }
//        )
//
//        BottomNavigationItem(
//            icon = {
//
//                Icon(
//                    painter = painterResource(id = R.drawable.pl),
//                    contentDescription = null, tint = Color.White,
//                )
//
//
//            }, label = { },
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
//            onClick = {
//                val intent=Intent(context,MainPlayTubeActviity::class.java)
//                context.startActivity(intent)
//            })
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
//                val intent=Intent(context, menu()::class.java)
//                context.startActivity(intent)
//
//            })
//
////        }
//    }
}