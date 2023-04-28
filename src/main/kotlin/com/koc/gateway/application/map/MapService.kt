package com.koc.gateway.application.map

import com.koc.gateway.domain.place.PlaceDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.stereotype.Service

@Service
class MapService: MapUseCase {
    override suspend fun searchPlace(latitude: String, longitude: String): Page<PlaceDto> {
        return PageImpl(
            listOf(
                PlaceDto(
                    1L,
                    "Mock Place",
                    "Mock Address",
                    setOf("description1", "description2"),
                    "1234.1234123",
                    "1234.1234123"
                ),
                PlaceDto(
                    2L,
                    "Mock Place",
                    "Mock Address",
                    setOf("description1", "description2"),
                    "1234.1234123",
                    "1234.1234123"
                ),
                PlaceDto(
                    3L,
                    "Mock Place",
                    "Mock Address",
                    setOf("description1", "description2"),
                    "1234.1234123",
                    "1234.1234123"
                )
            )
        )
    }
}