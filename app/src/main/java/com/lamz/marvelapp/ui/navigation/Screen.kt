package com.lamz.marvelapp.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("Home")
    object Cart : Screen("Favorite")
    object Profile : Screen("About")
    object DetailReward : Screen("Home/{rewardId}") {
        fun createRoute(rewardId: Long) = "Home/$rewardId"
    }
}