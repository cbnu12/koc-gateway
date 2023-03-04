package com.koc.gateway.adapter.out.place

import com.koc.gateway.adapter.out.place.api.MockPlaceApiClient
import com.koc.gateway.application.place.PlaceDto
import com.koc.gateway.application.place.port.out.TrendPlaceSearchPort
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Component

@Component
class PlaceAdapter(
    private val placeApiClient: MockPlaceApiClient
): TrendPlaceSearchPort {
    override suspend fun searchTrendPlaces(): List<PlaceDto> {
        return withContext(Dispatchers.IO) {
            placeApiClient.searchTrendPlaces()
        }
    }
}