package com.koc.gateway.adapter.`in`.web.home

import com.koc.gateway.application.home.HomeUseCase
import com.koc.gateway.application.home.HotCourseDto
import com.koc.gateway.application.home.RecommendedThemeDto
import com.koc.gateway.application.home.TrendPlaceDto
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.Page
import org.springframework.stereotype.Component

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
    suspend fun searchTrendPlaces(): Page<TrendPlaceDto> {
        return homeUseCase.searchTrendPlaces()
    }

    @Operation(summary = "추천 테마 조회 API", description = "추천 테마를 조회합니다.")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "OK"),
        ApiResponse(responseCode = "400", description = "Bad Request"),
        ApiResponse(responseCode = "500", description = "Internal Server Error")
    )
    suspend fun searchRecommendationThemes(): Page<RecommendedThemeDto> {
        return homeUseCase.searchRecommendTheme()
    }

    @Operation(summary = "인기 많은 여행 코스 조회 API", description = "인기 많은 여행 코스를 조회합니다.")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "OK"),
        ApiResponse(responseCode = "400", description = "Bad Request"),
        ApiResponse(responseCode = "500", description = "Internal Server Error")
    )
    suspend fun searchHotCourses(): Page<HotCourseDto> {
        return homeUseCase.searchHotCourses()
    }
}