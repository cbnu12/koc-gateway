package com.koc.gateway.application.port.`in`

import com.koc.gateway.adapter.`in`.web.authentication.SignInResponseDto
import com.koc.gateway.domain.user.UserDto

interface SignInUseCase {
    suspend fun signIn(userDto: UserDto): SignInResponseDto
}