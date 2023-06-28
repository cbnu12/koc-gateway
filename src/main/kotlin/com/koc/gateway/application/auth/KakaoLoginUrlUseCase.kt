package com.koc.gateway.application.auth

fun interface KakaoLoginUrlUseCase {
    suspend fun getUrl(): String
}