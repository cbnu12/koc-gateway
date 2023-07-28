package com.koc.gateway.domain.place

import com.koc.common.exchange.PaginatedServerResponse
import com.koc.gateway.application.place.PlaceLordPort
import org.springframework.stereotype.Service

@Service
class PlaceService(
    private val placeRepository: PlaceRepository
): PlaceLordPort {
    override suspend fun loadPlace(sortBy: String, page: Int, size: Int): PaginatedServerResponse<PlaceDto> {
        return placeRepository.findPlace(sortBy, page, size)
    }
}