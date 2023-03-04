package com.koc.gateway.adapter.`in`.user.web

import com.koc.gateway.application.user.port.`in`.WithdrawalUserCase
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.buildAndAwait
import org.springframework.web.reactive.function.server.json

@Component
@Tag(name = "회원", description = "회원 관련 API")
class UserHandler(
    private val withdrawalUserCase: WithdrawalUserCase
) {
    private val X_USER_ID = "X_USER_ID"

    @Operation(summary = "회원 탈퇴 API", description = "회원 탈퇴를 합니다..")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "OK"),
        ApiResponse(responseCode = "400", description = "Bad Request"),
        ApiResponse(responseCode = "500", description = "Internal Server Error")
    )
    suspend fun withdrawal(serverRequest: ServerRequest): ServerResponse {
        val userId = serverRequest.headers().header(X_USER_ID).first()

        withdrawalUserCase.withdraw(userId)

        return ServerResponse.ok().json().buildAndAwait()
    }
}