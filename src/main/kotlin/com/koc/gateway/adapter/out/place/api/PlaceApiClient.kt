package com.koc.gateway.adapter.out.place.api

import com.koc.gateway.application.healthcheck.service.HealthCheckService
import com.koc.gateway.application.place.PlaceDto
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

@Component
class PlaceApiClient(
    private val healthCheckService: HealthCheckService
) {
    private val URL = "testestest.com"
    private val webClient = WebClient.builder()
        .baseUrl(URL)
        .build()

    suspend fun searchTrendPlaces(): List<PlaceDto> {
        if(healthCheckService.check(URL)) {
            return webClient.get()
                .uri("/place/trends")
                .retrieve()
                .awaitBody()
        } else {
            return listOf(
                PlaceDto("mock place 1", "mock address 1"),
                PlaceDto("mock place 2", "mock address 2"),
                PlaceDto("mock place 3", "mock address 3"),
                PlaceDto("mock place 4", "mock address 4"),
                PlaceDto("mock place 5", "mock address 5"),
                PlaceDto("mock place 6", "mock address 6")
            )
        }
    }
}