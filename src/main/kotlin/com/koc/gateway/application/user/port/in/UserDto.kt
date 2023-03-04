package com.koc.gateway.application.user.port.`in`

import com.koc.gateway.domain.user.UserStatus

data class UserDto(
    var id: String?,
    val email: String?,
    var password: String?,
    val name: String?,
    val status: UserStatus?
)