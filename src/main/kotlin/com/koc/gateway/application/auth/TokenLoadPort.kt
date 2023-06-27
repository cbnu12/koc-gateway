package com.koc.gateway.application.auth

interface TokenLoadPort {
    suspend fun loadToken(code: String): String
}
