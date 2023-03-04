package com.koc.gateway.adapter.`in`.place.web

import com.koc.gateway.application.place.port.`in`.TrendPlaceSearchUseCase
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*

@Component
class TrendPlaceHandler(
    private val trandPlaceSearchUseCase: TrendPlaceSearchUseCase
) {
    suspend fun searchTrandPlaces(serverRequest: ServerRequest): ServerResponse {
        val data = trandPlaceSearchUseCase.search()
        return ServerResponse.ok().json().bodyValueAndAwait(data)
    }
}