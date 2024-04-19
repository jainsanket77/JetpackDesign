package com.example.jetpackdemo.ui.utils

import com.example.jetpackdemo.BuildConfig
import timber.log.Timber

object TimberUtil {

    fun init() {
        // Plant a debug tree for logging
        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
    }

    fun d(message: String) {
        Timber.d(message)
    }

    fun d(tag: String, message: String) {
        Timber.tag(tag).d(message)
    }

    fun e(message: String, vararg args: Any?) {
        Timber.e(message, args)
    }

    fun e(throwable: Throwable) {
        Timber.e(throwable)
    }

    fun e(tag: String, throwable: Throwable) {
        Timber.tag(tag).e(throwable)
    }

    fun w(message: String) {
        Timber.w(message)
    }

    fun w(tag: String, message: String) {
        Timber.tag(tag).w(message)
    }

    fun i(message: String) {
        Timber.i(message)
    }

    fun i(tag: String, message: String) {
        Timber.tag(tag).i(message)
    }

    fun v(message: String) {
        Timber.v(message)
    }

    fun v(tag: String, message: String) {
        Timber.tag(tag).v(message)
    }

    fun wtf(message: String) {
        Timber.wtf(message)
    }

    fun logAssert(tag: String, message: String) {
        Timber.tag(tag).wtf(message)
    }
}