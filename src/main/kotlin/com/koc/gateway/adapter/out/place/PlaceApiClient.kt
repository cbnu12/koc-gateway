package com.koc.gateway.adapter.out.place

import com.koc.gateway.domain.place.PlaceDto
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.*

@Component
class PlaceApiClient(
    private val webClientBuilder: WebClient.Builder
) {
    private val client = webClientBuilder
        .baseUrl("https://example.com/api/places")
        .build()

    suspend fun findTrendPlaces(): List<PlaceDto> {
        return client.get()
            .uri("/trending")
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .awaitBody()
    }
}