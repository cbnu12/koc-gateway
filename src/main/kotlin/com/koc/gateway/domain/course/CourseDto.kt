package com.koc.gateway.domain.course

import com.koc.gateway.domain.place.PlaceDto
import com.koc.gateway.domain.user.UserDto

data class CourseDto(
    val name: String,
    val owner: UserDto,
    val places: List<PlaceDto>,
    val emoji: String
)
