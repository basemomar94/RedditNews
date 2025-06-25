package com.bassem.core

sealed class ErrorTypes {
    data object IoException : ErrorTypes()
    data object Cancelled : ErrorTypes()
    data class Http(val code: Int, val message: String?) : ErrorTypes()
    data class Unknown(val message: String?) : ErrorTypes()
    data class InvalidArgument(val message: String?) : ErrorTypes()
    data object  JsonException:ErrorTypes()
}