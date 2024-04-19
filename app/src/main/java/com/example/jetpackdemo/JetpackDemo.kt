package com.example.jetpackdemo

import android.app.Application
import com.example.jetpackdemo.ui.utils.TimberUtil

class JetpackDemo : Application() {

    override fun onCreate() {
        super.onCreate()

        TimberUtil.init()
    }

}