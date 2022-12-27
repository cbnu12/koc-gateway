package com.koc.gateway.domain.user

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: MongoRepository<User?, String?> {

    fun findByEmail(email: String): User?

    fun findByEmailAndPassword(email: String, password: String): User?
}