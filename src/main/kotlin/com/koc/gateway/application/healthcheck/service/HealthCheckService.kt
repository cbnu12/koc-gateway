package com.koc.gateway.application.healthcheck.service

import com.koc.gateway.application.healthcheck.port.out.HealthCheckPort
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitExchangeOrNull

@Service
class HealthCheckService : HealthCheckPort {

    private val webClientBuilder = WebClient.builder()
    private val HEALTH_CHECK_URL = "/health"
    override suspend fun check(url: String): Boolean {
        return try {
            webClientBuilder.baseUrl(url)
                .build()
                .get().uri(HEALTH_CHECK_URL)
                .awaitExchangeOrNull { response -> {response.statusCode() == HttpStatus.OK} }
                .let { false }
        } catch (e: Exception) {
            false
        }
    }
}