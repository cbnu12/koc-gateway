package com.koc.gateway.application.port.out

import com.koc.gateway.domain.user.User

interface LoadUserPort {
    suspend fun findByEmailAndPassword(email: String, password: String): User?
    suspend fun findByEmail(email: String): User?
}