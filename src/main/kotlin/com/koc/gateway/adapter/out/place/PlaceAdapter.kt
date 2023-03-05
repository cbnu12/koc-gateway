package com.koc.gateway.adapter.out.place

import com.koc.gateway.adapter.out.place.api.PlaceApiClient
import com.koc.gateway.application.place.PlaceDto
import com.koc.gateway.application.place.port.out.TrendPlaceSearchPort
import org.springframework.stereotype.Component

@Component
class PlaceAdapter(
    private val placeApiClient: PlaceApiClient
): TrendPlaceSearchPort {
    override suspend fun searchTrendPlaces(): List<PlaceDto> {
        return placeApiClient.searchTrendPlaces()
    }
}