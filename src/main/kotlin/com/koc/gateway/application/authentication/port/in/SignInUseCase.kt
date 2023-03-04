package com.koc.gateway.application.authentication.port.`in`

import com.koc.gateway.adapter.`in`.authentication.web.SignInResponseDto
import com.koc.gateway.application.user.port.`in`.UserDto

interface SignInUseCase {
    suspend fun signIn(userDto: UserDto): SignInResponseDto
}