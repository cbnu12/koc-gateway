package com.koc.gateway.application.user

import com.koc.gateway.domain.user.User

fun interface UserSavePort {
    suspend fun save(user: User)
}