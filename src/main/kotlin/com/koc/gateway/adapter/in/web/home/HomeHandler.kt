package com.koc.gateway.adapter.`in`.web.home

import com.koc.gateway.application.home.HomeUseCase
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
@Tag(name = "Home", description = "홈화면 관련 API")
class HomeHandler(
    private val homeUseCase: HomeUseCase
) {

    @Operation(summary = "요즘 뜨는 장소 조회 API", description = "요즘 뜨는 장소를 조회합니다.")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "OK"),
        ApiResponse(responseCode = "400", description = "Bad Request"),
        ApiResponse(responseCode = "500", description = "Internal Server Error")
    )
    suspend fun searchTrendPlaces(serverRequest: ServerRequest): ServerResponse {
        val data = homeUseCase.searchTrendPlaces()
        return ServerResponse.ok().json().bodyValueAndAwait(data)
    }

    @Operation(summary = "추천 테마 조회 API", description = "추천 테마를 조회합니다.")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "OK"),
        ApiResponse(responseCode = "400", description = "Bad Request"),
        ApiResponse(responseCode = "500", description = "Internal Server Error")
    )
    suspend fun searchRecommendationThemes(serverRequest: ServerRequest): ServerResponse {
        val data = homeUseCase.searchRecommendTheme()
        return ServerResponse.ok().json().bodyValueAndAwait(data)
    }

    @Operation(summary = "인기 많은 여행 코스 조회 API", description = "인기 많은 여행 코스를 조회합니다.")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "OK"),
        ApiResponse(responseCode = "400", description = "Bad Request"),
        ApiResponse(responseCode = "500", description = "Internal Server Error")
    )
    suspend fun searchHotCourses(serverRequest: ServerRequest): ServerResponse {
        val data = homeUseCase.searchHotCourses()
        return ServerResponse.ok().json().bodyValueAndAwait(data)
    }
}