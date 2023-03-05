package com.koc.gateway.adapter.out.theme.api

import com.koc.gateway.application.healthcheck.service.HealthCheckService
import com.koc.gateway.application.theme.ThemeDto
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody

@Component
class ThemeApiClient(
    private val healthCheckService: HealthCheckService
) {
    private val URL = "testestest.com"
    private val webClient = WebClient.builder()
        .baseUrl(URL)
        .build()

    suspend fun searchRecommendationTheme(): List<ThemeDto> {
        if(healthCheckService.check(URL)) {
            return webClient.get()
                .uri("/theme/recommendation")
                .retrieve()
                .awaitBody()
        } else {
            return listOf(
                ThemeDto(),
                ThemeDto(),
                ThemeDto(),
                ThemeDto()
            )
        }
    }
}