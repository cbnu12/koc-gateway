package com.koc.gateway.application.place.service

import com.koc.gateway.application.place.PlaceDto
import com.koc.gateway.application.place.port.`in`.TrendPlaceSearchUseCase
import com.koc.gateway.application.place.port.out.TrendPlaceSearchPort
import org.springframework.stereotype.Service

@Service
class TrendPlaceSearchService(
    private val trendPlaceSearchPort: TrendPlaceSearchPort
): TrendPlaceSearchUseCase {
    override suspend fun search(): List<PlaceDto> {
        return trendPlaceSearchPort.searchTrendPlaces()
    }
}
