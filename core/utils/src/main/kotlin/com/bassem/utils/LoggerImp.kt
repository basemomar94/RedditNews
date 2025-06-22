package com.bassem.utils

import android.util.Log

class LoggerImp(private val tag: String) : Logger {

    override fun d(message: String) {
        Log.d(tag, message)
    }

    override fun i(message: String) {
        Log.i(tag, message)
    }

    override fun e(message: String) {
        Log.e(tag, message)
    }


}