package com.koc.gateway.application.auth

fun interface TokenLoadPort {
    suspend fun loadToken(code: String): String
}
