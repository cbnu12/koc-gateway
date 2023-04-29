package com.koc.gateway.application.home

data class RecommendedThemeDto(
        val id: Long,
        val name: String,
        val placesCount: Int,
        val emoji: String
)