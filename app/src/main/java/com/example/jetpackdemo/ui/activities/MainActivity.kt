package com.example.jetpackdemo.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.jetpackdemo.ui.composable.MainScreen
import com.example.jetpackdemo.ui.theme.JetPackDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackDemoTheme {
               MainScreen()
            }
        }
    }
}
