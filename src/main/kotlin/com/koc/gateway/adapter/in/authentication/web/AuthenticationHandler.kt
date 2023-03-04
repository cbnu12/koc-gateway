package com.koc.gateway.adapter.`in`.authentication.web

import com.koc.gateway.application.authentication.port.`in`.SignInUseCase
import com.koc.gateway.application.authentication.port.`in`.SignUpUseCase
import com.koc.gateway.application.user.port.`in`.UserDto
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.parameters.RequestBody
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*

@Component
@Tag(name = "인증", description = "로그인, 회원가입등 인증 관련 API")
class AuthenticationHandler(
    private val signInUseCase: SignInUseCase,
    private val signUpUseCase: SignUpUseCase
) {
    @Operation(summary = "로그인 API", description = "로그인을 처리하고 token을 내려준다.")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "OK"),
        ApiResponse(responseCode = "400", description = "Bad Request"),
        ApiResponse(responseCode = "500", description = "Internal Server Error")
    )
    @RequestBody(content = [Content(mediaType = "application/json", schema = Schema(implementation = UserDto::class))])
    suspend fun createToken(serverRequest: ServerRequest): ServerResponse {
        val userDto = serverRequest.awaitBody<UserDto>()

        val response = signInUseCase.signIn(userDto)

        return ServerResponse.ok().json().bodyValueAndAwait(response)
    }

    @Operation(summary = "회원가입 API", description = "회원가입 기능을 한다.")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "OK"),
        ApiResponse(responseCode = "400", description = "Bad Request"),
        ApiResponse(responseCode = "500", description = "Internal Server Error")
    )
    @RequestBody(content = [Content(mediaType = "application/json", schema = Schema(implementation = UserDto::class))])
    suspend fun createUser(serverRequest: ServerRequest): ServerResponse {
        val userDto = serverRequest.awaitBody<UserDto>()

        val response = signUpUseCase.signUp(userDto)

        return ServerResponse.ok().json().bodyValueAndAwait(response)

    }
}
