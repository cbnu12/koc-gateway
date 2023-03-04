package com.koc.gateway.adapter.`in`.theme.web

import com.koc.gateway.application.theme.port.`in`.RecommendationThemeSearchUseCase
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.json

@Component
@Tag(name = "테마", description = "테마 관련 API")
class RecommendationThemeHandler(
    private val recommendationThemeSearchUseCase: RecommendationThemeSearchUseCase
) {
    @Operation(summary = "추천 테마 조회 API", description = "추천 테마를 조회합니다.")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "OK"),
        ApiResponse(responseCode = "400", description = "Bad Request"),
        ApiResponse(responseCode = "500", description = "Internal Server Error")
    )
    suspend fun searchRecommendationThemes(serverRequest: ServerRequest): ServerResponse {
        return ServerResponse.ok().json().bodyValueAndAwait(recommendationThemeSearchUseCase.search())
    }
}