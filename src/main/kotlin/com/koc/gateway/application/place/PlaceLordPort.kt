package com.koc.gateway.application.place

import com.koc.common.exchange.PaginatedServerResponse
import com.koc.gateway.domain.place.PlaceDto

fun interface PlaceLordPort {
    suspend fun loadPlace(sortBy: String, page: Int, size: Int): PaginatedServerResponse<PlaceDto>
}