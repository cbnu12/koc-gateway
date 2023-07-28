package com.koc.gateway.domain.place

import com.koc.common.exchange.PaginatedServerResponse

interface PlaceRepository {
    suspend fun findPlace(sortBy: String, page: Int, size: Int): PaginatedServerResponse<PlaceDto>
}