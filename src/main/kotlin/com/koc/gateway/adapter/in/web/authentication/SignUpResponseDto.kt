package com.koc.gateway.adapter.`in`.web.authentication

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class SignUpResponseDto(
    val id: String?,
    val error: String?,
    val field: String?
) {
    companion object {
        fun success(id: String): SignUpResponseDto {
            return SignUpResponseDto(
                id = id,
                error = null,
                field = null
            )
        }

        fun fail(error: String?, field: String?): SignUpResponseDto {
            return SignUpResponseDto(
                id = null,
                error = error,
                field = field
            )
        }
    }
}