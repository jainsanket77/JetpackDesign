package com.example.jetpackdemo.ui.composable.tab_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.jetpackdemo.ui.comonents.AppToolbar

/**
 * Composable function that represents the home screen of the application.
 */
@Composable
fun AddScreen() {
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            AppToolbar(onNotificationClick = {

            })
        }
    }
}