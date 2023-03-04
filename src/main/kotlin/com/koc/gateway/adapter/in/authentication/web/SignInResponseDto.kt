package com.koc.gateway.adapter.`in`.authentication.web

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class SignInResponseDto(
    val isSignIn: Boolean,
    val accessToken: String?,
    val refreshToken: String?,
    val errorField: String?
) {
    companion object {
        fun success(accessToken: String, refreshToken: String): SignInResponseDto {
            return SignInResponseDto(
                isSignIn = true,
                accessToken = accessToken,
                refreshToken = refreshToken,
                errorField = null
            )
        }

        fun fail(errorField: String?): SignInResponseDto {
            return SignInResponseDto(
                isSignIn = false,
                accessToken = null,
                refreshToken = null,
                errorField = errorField
            )
        }
    }
}
