package com.koc.gateway.domain.user

data class UserDto(
    var id: String?,
    val email: String?,
    var password: String?,
    val name: String?,
    val status: UserStatus?
)