package com.example.jetpackdemo.ui.utils

import android.content.Context
import android.widget.Toast

fun Context.showToast(message: String?) {
    if (!message.isNullOrEmpty()) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}