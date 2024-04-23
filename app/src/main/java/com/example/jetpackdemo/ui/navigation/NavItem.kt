package com.example.jetpackdemo.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavItem {
    object Home : Item(
        path = NavRoute.HOME.title, title = NavRoute.HOME.title,
        icon = Icons.Outlined.Home, selectedIcon = Icons.Filled.Home
    )

    object Search : Item(
        path = NavRoute.SEARCH.title, title = NavRoute.SEARCH.title,
        icon = Icons.Outlined.Search, selectedIcon = Icons.Filled.Search
    )

    object Add : Item(
        path = NavRoute.ADD.title, title = NavRoute.ADD.title,
        icon = Icons.Default.AddCircle, selectedIcon = Icons.Default.AddCircle
    )

    object Chat : Item(
        path = NavRoute.CHAT.title, title = NavRoute.CHAT.title,
        icon = Icons.Outlined.MailOutline, selectedIcon = Icons.Filled.Email
    )

    object Profile : Item(
        path = NavRoute.PROFILE.title, title = NavRoute.PROFILE.title,
        icon = Icons.Outlined.Person, selectedIcon = Icons.Filled.Person
    )
}

open class Item(val path: String, val title: String, val icon: ImageVector, val selectedIcon: ImageVector)

enum class NavRoute(val title: String) {
    HOME("Home"),
    SEARCH("Search"),
    ADD("Add"),
    CHAT("Chat"),
    PROFILE("Profile"),
    NOTIFICATION("notification")
}