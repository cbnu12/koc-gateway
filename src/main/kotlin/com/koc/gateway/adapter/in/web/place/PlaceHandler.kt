package com.koc.gateway.adapter.`in`.web.place

import com.koc.gateway.application.place.PlaceUseCase
import com.koc.gateway.domain.place.PlaceDto
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.stereotype.Component

@Component
@Tag(name = "Place", description = "장소 관련 API")
class PlaceHandler(
    private val placeUseCase: PlaceUseCase
) {
    @Operation(summary = "조회 API", description = "id값으로 장소를 조회합니다.")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "OK"),
        ApiResponse(responseCode = "400", description = "Bad Request"),
        ApiResponse(responseCode = "500", description = "Internal Server Error")
    )
    suspend fun findPlace(id: Long): PlaceDto {
        return placeUseCase.findPlace(id)
    }
}