package com.example.uhunt.navigation

sealed class Destination(val route: String) {
    object Login : Destination(route = "auth")
    object Home : Destination(route = "home")

    companion object {
        fun getStartDestination() = Login.route
    }
}
