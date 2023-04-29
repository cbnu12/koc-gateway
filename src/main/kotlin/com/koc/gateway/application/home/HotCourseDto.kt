package com.koc.gateway.application.home

import com.koc.gateway.domain.user.UserDto

data class HotCourseDto(
    val name: String,
    val createdBy: UserDto,
    val placeCount: Int,
    val emoji: String
)