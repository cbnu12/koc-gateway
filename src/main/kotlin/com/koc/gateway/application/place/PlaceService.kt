package com.koc.gateway.application.place

import com.koc.gateway.domain.place.PlaceDto
import org.springframework.stereotype.Service

@Service
class PlaceService: PlaceUseCase {
    override suspend fun findPlace(id: Long): PlaceDto {
        return PlaceDto(
            1L,
            "Mock Place",
            "Mock Address",
            setOf("description1", "description2"),
                "37.4020051732617",
                "127.108662792918"
        )
    }
}