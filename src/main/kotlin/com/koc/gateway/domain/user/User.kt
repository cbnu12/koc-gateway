package com.koc.gateway.domain.user

import org.bson.types.ObjectId
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "koc")
data class User(
    var _id: ObjectId?,
    var email: String,
    var password: String,
    var name: String,
    var status: UserStatus
) {

    fun withdraw() {
        status = UserStatus.WITHDRAWAL
    }

    companion object {
        fun create(userDto: UserDto): User {
            return User(
                _id = null,
                email = userDto.email,
                name = userDto.name,
                password = userDto.password,
                status = UserStatus.ALIVE
            )
        }
    }
}