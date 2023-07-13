package com.koc.gateway.application.user

data class UserResponse(
    val id: Long,
    val kocId: String,
    val kakaoId: Long,
    val email: String,
    val loginType: String,
    val userStatus: String
)
