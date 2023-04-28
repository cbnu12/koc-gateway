package com.koc.gateway.adapter.`in`.web.map

import com.koc.gateway.application.map.MapUseCase
import com.koc.gateway.domain.place.PlaceDto
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.Page
import org.springframework.stereotype.Component

@Component
@Tag(name = "Map", description = "지도화면 관련 API")
class MapHandler(
    private val mapUseCase: MapUseCase
) {
    @Operation(summary = "위치 기반 장소 검색 API", description = "위도와 경도로 근처에 등록된 장소를 검색 합니다.")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "OK"),
        ApiResponse(responseCode = "400", description = "Bad Request"),
        ApiResponse(responseCode = "500", description = "Internal Server Error")
    )
    suspend fun searchPlace(latitude: String, longitude: String): Page<PlaceDto> {
        return mapUseCase.searchPlace(latitude, longitude)
    }
}