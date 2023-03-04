package com.koc.gateway.application.authentication.port.`in`

import com.koc.gateway.adapter.`in`.authentication.web.SignUpResponseDto
import com.koc.gateway.application.user.port.`in`.UserDto

interface SignUpUseCase {
    suspend fun signUp(userDto: UserDto) : SignUpResponseDto
}