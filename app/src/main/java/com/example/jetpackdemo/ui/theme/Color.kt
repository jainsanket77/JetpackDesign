package com.example.jetpackdemo.ui.theme

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

fun getRandomLiteColor(from : Int = 200): Color {
    val random = Random.Default
    val red = random.nextInt(from, 256)
    val green = random.nextInt(from, 256)
    val blue = random.nextInt(from, 256)
    return Color(red, green, blue)
}

fun getRandomColor(input: String): Color {
    val hashCode = input.hashCode()
    val red = (hashCode and 0xFF0000) shr 16
    val green = (hashCode and 0x00FF00) shr 8
    val blue = hashCode and 0x0000FF
    return Color(red, green, blue).copy(alpha = 0.13F)
}
