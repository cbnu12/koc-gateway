package com.koc.gateway.application.place

import com.koc.gateway.domain.place.PlaceDto
import org.springframework.data.domain.Page

interface PlacePort {
    suspend fun findTrandPlaces(): Page<PlaceDto>
}