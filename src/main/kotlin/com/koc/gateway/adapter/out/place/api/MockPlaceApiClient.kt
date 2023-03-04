package com.koc.gateway.adapter.out.place.api

import com.koc.gateway.application.place.PlaceDto
import org.springframework.stereotype.Component

@Component
class MockPlaceApiClient: PlaceApiClient {

    private val places = listOf<PlaceDto>(
        PlaceDto("mock place 1", "mock address 1"),
        PlaceDto("mock place 2", "mock address 2"),
        PlaceDto("mock place 3", "mock address 3"),
        PlaceDto("mock place 4", "mock address 4"),
        PlaceDto("mock place 5", "mock address 5"),
        PlaceDto("mock place 6", "mock address 6")
    )
    override fun searchTrendPlaces(): List<PlaceDto> {
        return places
    }
}