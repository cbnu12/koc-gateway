package com.koc.common.filter

import com.koc.common.jwt.JwtProvider
import org.springframework.web.reactive.function.server.ServerRequest

object AuthFilter {
    private val ACCESS_TOKEN: String = "access-token"
    private val REFRESH_TOKEN: String = "refresh-token"
    private val X_USER_ID: String = "X_USER_ID"

    fun authCheck(
        serverRequest: ServerRequest
    ): ServerRequest {
        val accessToken = serverRequest.headers().header(ACCESS_TOKEN).firstOrNull()

        if (JwtProvider.validate(accessToken)) {
            // TODO: userId 조회하도록 수정
            serverRequest.exchange().mutate().request(
                serverRequest.exchange().request.mutate()
                    .header(X_USER_ID, "test")
                    .build()
            )
        } else {
            // TODO: 그럴싸하게 수정필요
            throw AuthenticationException()
        }

        return serverRequest
    }
}