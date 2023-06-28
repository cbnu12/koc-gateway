package com.koc.gateway.application.auth

import com.koc.gateway.domain.user.User

fun interface UserLoadPort {
    suspend fun loadUser(): User
}