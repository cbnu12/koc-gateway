package com.koc.gateway.application.auth

import org.springframework.stereotype.Service

@Service
class AuthService(
    private val kakaoLoginUrlLoadPort: KakaoLoginUrlLoadPort,
    private val tokenLoadPort: TokenLoadPort
): KakaoLoginUrlUseCase, TokenUseCase {
    override suspend fun getUrl(): String {
        return kakaoLoginUrlLoadPort.loadKakaoLoginUrl()
    }

    override suspend fun getToken(code: String): String {
        return tokenLoadPort.loadToken(code)
    }
}