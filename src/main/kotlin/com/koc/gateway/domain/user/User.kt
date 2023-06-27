package com.koc.gateway.domain.user

data class User(
    val id: UserId,
    val nickName: NickName,
    val password: Password,
    val type: UserType,
    val status: UserStatus,
    val token: Token) {
}