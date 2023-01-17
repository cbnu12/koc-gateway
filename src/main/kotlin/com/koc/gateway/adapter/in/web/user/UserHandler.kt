package com.koc.gateway.adapter.`in`.web.user

import com.koc.gateway.application.port.`in`.WithdrawalUserCase
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.buildAndAwait
import org.springframework.web.reactive.function.server.json

@Component
class UserHandler(
    private val withdrawalUserCase: WithdrawalUserCase
) {
    private val X_USER_ID = "X_USER_ID"

    suspend fun withdrawal(serverRequest: ServerRequest): ServerResponse {
        val userId = serverRequest.headers().header(X_USER_ID).first()

        withdrawalUserCase.withdraw(userId)

        return ServerResponse.ok().json().buildAndAwait()
    }
}