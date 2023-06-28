package com.koc.gateway.application.auth

fun interface TokenUseCase {
    suspend fun getToken(code: String): String
}
