package com.koc.gateway.application.place.port.out

import com.koc.gateway.application.place.PlaceDto

interface TrendPlaceSearchPort {
    suspend fun searchTrendPlaces(): List<PlaceDto>
}