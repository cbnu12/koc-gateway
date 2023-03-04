package com.koc.gateway.adapter.`in`.authentication.web

import com.koc.gateway.application.authentication.port.`in`.SignInUseCase
import com.koc.gateway.application.authentication.port.`in`.SignUpUseCase
import com.koc.gateway.application.user.port.`in`.UserDto
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*

@Component
class AuthenticationHandler(
    private val signInUseCase: SignInUseCase,
    private val signUpUseCase: SignUpUseCase
) {
    suspend fun createToken(serverRequest: ServerRequest): ServerResponse {
        val userDto = serverRequest.awaitBody<UserDto>()

        val response = signInUseCase.signIn(userDto)

        return ServerResponse.ok().json().bodyValueAndAwait(response)
    }

    suspend fun createUser(serverRequest: ServerRequest): ServerResponse {
        val userDto = serverRequest.awaitBody<UserDto>()

        val response = signUpUseCase.signUp(userDto)

        return ServerResponse.ok().json().bodyValueAndAwait(response)

    }
}
