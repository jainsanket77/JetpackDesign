package com.example.jetpackdemo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jetpackdemo.ui.composable.NotificationScreen
import com.example.jetpackdemo.ui.composable.tab_screen.AddScreen
import com.example.jetpackdemo.ui.composable.tab_screen.ChatScreen
import com.example.jetpackdemo.ui.composable.tab_screen.HomeScreen
import com.example.jetpackdemo.ui.composable.tab_screen.ProfileScreen
import com.example.jetpackdemo.ui.composable.tab_screen.SearchScreen
import com.example.jetpackdemo.ui.navigation.NavItem

/**
 * Composable function that defines the navigation screens and their corresponding destinations.
 *
 * @param navController The navigation controller used for handling navigation between screens.
 */
@Composable
fun NavigationScreens(navController: NavHostController) {
    NavHost(navController, startDestination = NavItem.Home.path) {
        composable(NavItem.Home.path) { HomeScreen(navController) }
        composable(NavItem.Search.path) { SearchScreen() }
        composable(NavItem.Add.path) { AddScreen() }
        composable(NavItem.Chat.path) { ChatScreen() }
        composable(NavItem.Profile.path) { ProfileScreen(navController) }
        composable(NavRoute.NOTIFICATION.title) { NotificationScreen(navController) }
    }
}