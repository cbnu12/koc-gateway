package com.koc.gateway.application.port.out

import com.koc.gateway.domain.user.UserDto

interface SaveUserPort {
    suspend fun save(userDto: UserDto): UserDto
}