package com.koc.gateway.adapter.out.place

import com.koc.gateway.application.place.PlacePort
import com.koc.gateway.domain.place.PlaceDto
import org.springframework.data.domain.Page
import org.springframework.stereotype.Component

@Component
class PlaceAdapter(
    private val placeApiClient: PlaceApiClient
): PlacePort {
    override suspend fun findTrandPlaces(): Page<PlaceDto> {
        return Page.empty()
    }
}