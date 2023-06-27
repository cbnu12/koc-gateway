package com.koc.gateway.adapter.out.auth

import com.koc.gateway.application.auth.KakaoLoginUrlLoadPort
import com.koc.gateway.application.auth.TokenLoadPort
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import org.springframework.web.reactive.function.client.awaitExchange

@Component
class AuthAdapter: KakaoLoginUrlLoadPort, TokenLoadPort{

    private val webClient = WebClient.create("http://temp.temp.temp/auth")

    override suspend fun loadKakaoLoginUrl(): String {
        return webClient.get()
            .uri("/kakao-login-url")
            .awaitExchange { clientResponse -> clientResponse.awaitBody(String::class) }
    }

    override suspend fun loadToken(code: String): String {
        return webClient.get()
            .awaitExchange { clientResponse -> clientResponse.awaitBody(String::class) }
    }
}