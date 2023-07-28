package com.koc.gateway.application.place

import com.koc.gateway.domain.place.PlaceDto
import org.springframework.data.domain.Page

fun interface PlacePort {
    suspend fun findTrandPlaces(): Page<PlaceDto>
}