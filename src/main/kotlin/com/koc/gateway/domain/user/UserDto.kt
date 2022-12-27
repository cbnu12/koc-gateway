package com.koc.gateway.domain.user

import org.bson.types.ObjectId

data class UserDto(
    var id: ObjectId?,
    val email: String,
    var password: String,
    val name: String,
    val status: UserStatus
) {

    fun toEntity(): User {
        return User(_id = id, email = email, password = password, name = name, status = status)
    }

    companion object {
        fun of(user: User?): UserDto? {
            return if (user != null) {
                UserDto(
                    id = user._id,
                    email = user.email,
                    password = user.password,
                    name = user.name,
                    status = user.status
                )
            } else {
                null
            }
        }
    }
}