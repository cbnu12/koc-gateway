package com.koc.gateway.application.user

fun interface UserLoadPort {
    suspend fun loadUser(id: Long): UserResponse
}