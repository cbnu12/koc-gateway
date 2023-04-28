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
            "1234.1234123",
            "1234.1234123"
        )
    }
}