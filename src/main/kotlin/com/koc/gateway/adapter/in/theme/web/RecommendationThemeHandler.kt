package com.koc.gateway.adapter.`in`.theme.web

import com.koc.gateway.application.theme.port.`in`.RecommendationThemeSearchUseCase
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.json

@Component
class RecommendationThemeHandler(
    private val recommendationThemeSearchUseCase: RecommendationThemeSearchUseCase
) {
    suspend fun searchRecommendationThemes(serverRequest: ServerRequest): ServerResponse {
        return ServerResponse.ok().json().bodyValueAndAwait(recommendationThemeSearchUseCase.search())
    }
}