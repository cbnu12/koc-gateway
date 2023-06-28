package com.koc.gateway.application.auth

fun interface KakaoLoginUrlLoadPort {
    suspend fun loadKakaoLoginUrl(): String
}