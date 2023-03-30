package com.koc.gateway.application.home

data class HotCourseDto(
    val name: String,
    val createdBy: User,
    val placeCount: Int,
    val emoji: String
) {
    data class User(
        val id: Long,
        val nickName: String
    )
}