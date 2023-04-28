package com.koc.gateway.application.place

import com.koc.gateway.domain.place.PlaceDto

interface PlaceUseCase {
    suspend fun findPlace(id: Long): PlaceDto
}