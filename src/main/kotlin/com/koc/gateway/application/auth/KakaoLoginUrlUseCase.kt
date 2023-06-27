package com.koc.gateway.application.auth

interface KakaoLoginUrlUseCase {
    suspend fun getUrl(): String
}