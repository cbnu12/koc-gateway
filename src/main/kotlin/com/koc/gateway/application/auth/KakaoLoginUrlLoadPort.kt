package com.koc.gateway.application.auth

interface KakaoLoginUrlLoadPort {
    suspend fun loadKakaoLoginUrl(): String
}