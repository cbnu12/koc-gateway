package com.koc.gateway.adapter.`in`.web.home

import com.koc.gateway.application.home.TrendPlaceDto
import com.koc.gateway.application.home.TrendPlaceSearchUseCase
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("home")
@Tag(name = "Home", description = "홈화면 관련 API")
class HomeController(
    private val trendPlaceSearchUseCase: TrendPlaceSearchUseCase
) {
    @Operation(summary = "요즘 뜨는 장소 조회 API", description = "요즘 뜨는 장소를 조회합니다.")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "OK"),
        ApiResponse(responseCode = "400", description = "Bad Request"),
        ApiResponse(responseCode = "500", description = "Internal Server Error")
    )
    @GetMapping("trend-places")
    suspend fun searchTrendPlaces(pageable: Pageable): Page<TrendPlaceDto> {
        return trendPlaceSearchUseCase.searchTrendPlaces("TREND", pageable.pageNumber, pageable.pageSize)
    }
}