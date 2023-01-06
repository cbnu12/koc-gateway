package com.koc.common.validation.exception

enum class ValidationErrorCode(val field: String) {
    EMAIL("email"),
    PASSWORD("password"),
    NAME("name"),
    STATUS("status")


}