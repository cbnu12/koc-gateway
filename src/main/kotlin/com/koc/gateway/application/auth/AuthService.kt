package com.koc.gateway.application.auth

import com.koc.gateway.domain.user.KakaoLoginUrl
import com.koc.gateway.domain.user.Token
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val kakaoLoginUrlLoadPort: KakaoLoginUrlLoadPort,
    private val tokenLoadPort: TokenLoadPort
): KakaoLoginUrlUseCase, TokenUseCase {
    override suspend fun getUrl(): String {
        val kakaoLoginUrl = KakaoLoginUrl(kakaoLoginUrlLoadPort.loadKakaoLoginUrl())
        return kakaoLoginUrl.value
    }

    override suspend fun getToken(code: String): String {
        val token = Token(tokenLoadPort.loadToken(code))
        return token.value

    }
}