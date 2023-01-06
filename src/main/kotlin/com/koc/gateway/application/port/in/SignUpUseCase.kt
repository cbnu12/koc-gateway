package com.koc.gateway.application.port.`in`

import com.koc.gateway.adapter.`in`.web.authentication.SignUpResponseDto
import com.koc.gateway.domain.user.UserDto

interface SignUpUseCase {
    suspend fun signUp(userDto: UserDto) : SignUpResponseDto
}