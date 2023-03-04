package com.koc.gateway.adapter.out.user.mongo

import com.koc.gateway.adapter.out.user.mongo.UserDocument
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface UserRepository: ReactiveMongoRepository<UserDocument, String> {
    suspend fun findByEmail(email: String): UserDocument?
    suspend fun findByEmailAndPassword(email: String, password: String): UserDocument?
}