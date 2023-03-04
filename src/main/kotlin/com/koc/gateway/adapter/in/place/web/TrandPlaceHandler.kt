package com.koc.gateway.adapter.`in`.place.web

import com.koc.gateway.application.place.port.`in`.TrendPlaceSearchUseCase
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
@Tag(name = "장소", description = "장소 관련 API")
class TrendPlaceHandler(
    private val trandPlaceSearchUseCase: TrendPlaceSearchUseCase
) {
    @Operation(summary = "요즘 뜨는 장소 조회 API", description = "요즘 뜨는 장소를 조회합니다.")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "OK"),
        ApiResponse(responseCode = "400", description = "Bad Request"),
        ApiResponse(responseCode = "500", description = "Internal Server Error")
    )
    suspend fun searchTrandPlaces(serverRequest: ServerRequest): ServerResponse {
        val data = trandPlaceSearchUseCase.search()
        return ServerResponse.ok().json().bodyValueAndAwait(data)
    }
}