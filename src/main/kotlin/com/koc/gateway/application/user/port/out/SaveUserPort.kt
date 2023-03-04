package com.koc.gateway.application.user.port.out

import com.koc.gateway.application.user.port.`in`.UserDto

interface SaveUserPort {
    suspend fun save(userDto: UserDto): UserDto
}