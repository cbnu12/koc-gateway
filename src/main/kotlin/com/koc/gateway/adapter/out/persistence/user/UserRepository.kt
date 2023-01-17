package com.koc.gateway.adapter.out.persistence.user

import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface UserRepository: ReactiveMongoRepository<UserDocument, String> {
    suspend fun findByEmail(email: String): UserDocument?
    suspend fun findByEmailAndPassword(email: String, password: String): UserDocument?
}