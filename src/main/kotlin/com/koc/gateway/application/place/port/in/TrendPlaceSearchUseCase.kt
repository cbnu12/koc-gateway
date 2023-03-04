package com.koc.gateway.application.place.port.`in`

import com.koc.gateway.application.place.PlaceDto

interface TrendPlaceSearchUseCase {
    suspend fun search(): List<PlaceDto>
}