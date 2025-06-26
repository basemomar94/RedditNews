package com.bassem.presentation.mapper

import android.R.id.message
import android.content.Context
import com.bassem.core.ErrorTypes
import org.json.JSONException
import java.io.IOException
import kotlin.coroutines.cancellation.CancellationException
import com.bassem.presentation.R

fun Throwable.mapThrowable(): ErrorTypes = when (this) {
    is IOException -> ErrorTypes.IoException
    is JSONException -> ErrorTypes.JsonException
    is CancellationException -> ErrorTypes.Cancelled
    is IllegalArgumentException -> ErrorTypes.InvalidArgument(this.message)
    else -> ErrorTypes.Unknown(this.message)
}

fun ErrorTypes.getMessage(context: Context): String = when (this) {
    ErrorTypes.IoException -> context.getString(R.string.error_io)
    ErrorTypes.JsonException -> context.getString(R.string.error_json)
    ErrorTypes.Cancelled -> context.getString(R.string.error_cancelled)
    is ErrorTypes.InvalidArgument -> context.getString(
        R.string.error_invalid_argument,
        message ?: ""
    )
    is ErrorTypes.RuntimeException -> context.getString(R.string.error_runtime)
    is ErrorTypes.Unknown -> context.getString(R.string.error_unknown, message ?: "")
    is ErrorTypes.Http -> context.getString(R.string.error_http, code, message ?: "")
}


