package com.koc.gateway.domain.user

data class User(
    var id: String?,
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
                id = null,
                email = userDto.email ?: "",
                name = userDto.name ?: "",
                password = userDto.password ?: "",
                status = UserStatus.ALIVE
            )
        }
    }
}