package com.koc.gateway.adapter.out.place

import com.koc.common.exchange.PaginatedServerResponse
import com.koc.gateway.domain.place.PlaceDto
import com.koc.gateway.domain.place.PlaceRepository
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

@Component
class PlaceAdapter : PlaceRepository {

    private val webClient = WebClient.create("http://http://211.208.125.180:8100/places")

    override suspend fun findPlace(sortBy: String, page: Int, size: Int): PaginatedServerResponse<PlaceDto> =
        webClient.get()
            .retrieve()
            .awaitBody<PaginatedServerResponse<PlaceDto>>()
}