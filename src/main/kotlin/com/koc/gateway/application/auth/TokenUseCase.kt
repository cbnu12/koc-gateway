package com.koc.gateway.application.auth

interface TokenUseCase {
    suspend fun getToken(code: String): String
}
