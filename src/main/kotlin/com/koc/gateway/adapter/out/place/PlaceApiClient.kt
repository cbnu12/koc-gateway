package com.koc.gateway.adapter.out.place

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient

@Component
class PlaceApiClient(
    private val webClientBuilder: WebClient.Builder
) {
    val webClient = webClientBuilder
        .baseUrl("http://121.121.121.121:1234/place")
        .build()
    suspend fun findTrendPlaces() {

    }
}