package com.koc.gateway.application.map

import com.koc.gateway.domain.place.PlaceDto
import org.springframework.data.domain.Page

interface MapUseCase {
    suspend fun searchPlace(latitude: String, longitude: String): Page<PlaceDto>
}