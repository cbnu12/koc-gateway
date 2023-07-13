package com.koc.gateway.application.home

import com.koc.gateway.domain.user.UserDto

data class HotCourseResponse(
        val id: Long,
        val name: String,
        val createdBy: UserDto,
        val placeCount: Int,
        val emoji: String
)