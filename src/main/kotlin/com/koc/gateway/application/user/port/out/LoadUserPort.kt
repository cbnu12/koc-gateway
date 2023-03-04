package com.koc.gateway.application.user.port.out

import com.koc.gateway.domain.user.User

interface LoadUserPort {
    suspend fun findById(id: String): User?
    suspend fun findByEmail(email: String): User?
    suspend fun findByEmailAndPassword(email: String, password: String): User?
}