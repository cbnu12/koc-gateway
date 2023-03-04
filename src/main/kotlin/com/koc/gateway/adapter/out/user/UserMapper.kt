package com.koc.gateway.adapter.out.user

import com.koc.gateway.adapter.out.user.mongo.UserDocument
import com.koc.gateway.domain.user.User
import com.koc.gateway.application.user.port.`in`.UserDto
import org.springframework.stereotype.Component

@Component
class UserMapper {

    fun toDomain(userDocument: UserDocument): User {
        return User(
            id = userDocument.id,
            email = userDocument.email,
            password = userDocument.password,
            name = userDocument.name,
            status = userDocument.status
        )
    }

    suspend fun toEntity(user: User): UserDocument {
        return UserDocument(
            id = user.id,
            email = user.email,
            password = user.password,
            name = user.name,
            status = user.status
        )
    }

    suspend fun toDto(userDocument: UserDocument): UserDto {
        return UserDto(
            id = userDocument.id,
            email = userDocument.email,
            password = userDocument.password,
            name = userDocument.name,
            status = userDocument.status
        )
    }

    suspend fun toDto(user: User): UserDto {
        return UserDto(
            id = user.id,
            email = user.email,
            password = user.password,
            name = user.name,
            status = user.status
        )
    }
}