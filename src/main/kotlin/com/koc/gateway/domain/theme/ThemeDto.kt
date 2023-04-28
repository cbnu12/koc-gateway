package com.koc.gateway.domain.theme

import com.koc.gateway.domain.place.PlaceDto

data class ThemeDto(
    val name: String,
    val places: Set<PlaceDto>,
    val emoji: String
)
