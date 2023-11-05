package com.lamz.marvelapp.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("Home")
    object Profile : Screen("About")
    object DetailMarvel : Screen("Home/{rewardId}") {
        fun createRoute(rewardId: Long) = "Home/$rewardId"
    }
}