package com.koc.gateway.adapter.out.place

import com.koc.gateway.domain.place.Place
import com.koc.gateway.application.place.PlacePort
import org.springframework.data.domain.Page
import org.springframework.stereotype.Component

@Component
class PlaceAdapter(
    private val placeApiClient: PlaceApiClient
): PlacePort {
    override suspend fun findTrandPlaces(): Page<Place> {
        return Page.empty()
    }
}