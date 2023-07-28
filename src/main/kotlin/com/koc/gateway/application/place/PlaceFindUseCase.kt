package com.koc.gateway.application.place

import com.koc.gateway.domain.place.PlaceDto

fun interface PlaceFindUseCase {
    suspend fun findPlace(id: Long): PlaceDto
}