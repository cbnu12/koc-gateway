package com.koc.gateway.application.auth

import com.koc.gateway.domain.user.User

fun interface UserSavePort {
    suspend fun save(user: User)
}