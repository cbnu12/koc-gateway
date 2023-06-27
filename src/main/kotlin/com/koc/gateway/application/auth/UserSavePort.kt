package com.koc.gateway.application.auth

import com.koc.gateway.domain.user.User

interface UserSavePort {
    suspend fun save(user: User)
}