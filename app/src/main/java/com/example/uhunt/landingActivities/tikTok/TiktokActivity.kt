package com.example.uhunt.landingActivities.tikTok

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.navigation.compose.composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.example.uhunt.SharedPref.Utilities
import com.example.uhunt.jet.TikTokScreen
import com.example.uhunt.jet.tiktokclassess.*
import com.example.uhunt.jet.tiktokclassess.carousalClassess.ProfileScreen
import com.example.uhunt.jetpackClassess.colorsThemes.tiktokBlack
import com.example.uhunt.ui.activities.landing.ui.theme.UhuntTheme
import com.example.uhunt.viewmodel.MainViewModel
import com.example.uhunt.viewmodel.ShortVdieoViewModel
import com.example.uhunt.viewmodel.VideoViewModel
import org.w3c.dom.Text

class TiktokActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // We can also use  SystemUiController(window) to control status theme inside compose.
        window.statusBarColor = ContextCompat.getColor(this, android.R.color.black)

        setContent {
            UhuntTheme(darkTheme = true) {
                val viewModel: ShortVdieoViewModel by viewModels()

                TiktokAppContent(viewModel)
            }
        }
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, TiktokActivity::class.java)
    }
}

@Composable
fun TiktokAppContent( viewModel: ShortVdieoViewModel) {
    val navController = rememberNavController()
    val context = LocalContext.current
    val videoId = Utilities.getString(context, "videoId")
    val videoUrl = Utilities.getString(context, "videoUrl")
    Scaffold(
//        bottomBar = { TikTokBottomNavigation(navController) },
        bottomBar = {  },
        content = { paddingValues ->
            TikTokBodyContent(
                navController = navController,
                modifier = Modifier.padding(paddingValues),viewModel
            )
        }
    )
}

@Composable
fun TikTokBottomNavigation(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.arguments?.getString("route")

    BottomNavigation(backgroundColor = tiktokBlack) {
        TiktokDemoDataProvider.bottomBarList.forEach { tiktokScreen ->
            BottomNavigationItem(
                icon = { BottomBarIcon(tiktokScreen) },
                selected = currentRoute == tiktokScreen.route,
                onClick = {
                    navController.popBackStack(navController.graph.startDestinationId, false)
                    if (currentRoute != tiktokScreen.route) {
                        navController.navigate(tiktokScreen.route)
                    }
                },
                label = {
                    if (tiktokScreen != TikTokScreen.Create) {
                        Text(text = tiktokScreen.route)
                    }
                },
            )
        }
    }
}

@Composable
fun BottomBarIcon(screen: TikTokScreen) {
    when (screen) {
        TikTokScreen.Home -> Icon(imageVector = Icons.Filled.Home, contentDescription = null)
        TikTokScreen.Discover -> Icon(imageVector = Icons.Filled.Search, contentDescription = null)
        TikTokScreen.Create -> TiktokCreateIcon()
        TikTokScreen.Inbox -> Icon(imageVector = Icons.Filled.Menu, contentDescription = null)
        TikTokScreen.Me -> Icon(imageVector = Icons.Filled.Person, contentDescription = null)
        TikTokScreen.Profile -> { /* this branch added to satisfy exhaustive when */
        }
    }
}
@Composable
public fun NavHost(
    navController: NavHostController,
    startDestination: String,
    modifier: Modifier = Modifier,
    route: String? = null,
    builder: NavGraphBuilder.() -> Unit
) {
    androidx.navigation.compose.NavHost(
        navController,
        remember(route, startDestination, builder) {
            navController.createGraph(startDestination, route, builder)
        },
        modifier
    )
}
@Composable
fun TikTokBodyContent(
    navController: NavHostController,
    modifier: Modifier = Modifier,viewModel: ShortVdieoViewModel
) {
    NavHost(
        navController = navController,
        startDestination = TikTokScreen.Home.route,
        modifier = modifier,
    ) {
        composable(TikTokScreen.Home.route) {
            HomeScreen(tiktokInteractionEvents = { handleInteractionEvent(it, navController) },viewModel)
        }
        composable(TikTokScreen.Discover.route) { DiscoverScreen() }
        composable(TikTokScreen.Create.route) { Text(text = "Create:TODO") }
        composable(TikTokScreen.Inbox.route) { Text(text = "Inbox:TODO") }
        composable(TikTokScreen.Me.route) { ProfileScreen("10", navController) }
        // This navigation is for going to user profile but it should be moved to separate place
        composable("${TikTokScreen.Profile.route}/{userId}") { backStackEntry ->
            ProfileScreen(backStackEntry.arguments?.getString("userId")!!, navController)
        }
    }
}

fun handleInteractionEvent(
    tiktokHomeInteractionEvents: TiktokHomeInteractionEvents,
    navController: NavHostController
) {
    when (tiktokHomeInteractionEvents) {
        is TiktokHomeInteractionEvents.OpenProfile -> {
            navController.navigate("${TikTokScreen.Profile.route}/${tiktokHomeInteractionEvents.album.id}")
        }
//          is TiktokHomeInteractionEvents.OpenProfile -> {
//            navController.navigate("${TikTokScreen.Profile.route}/${tiktokHomeInteractionEvents.album.id}")
//        }
//
        else -> {
            //TODO
        }
    }

}

