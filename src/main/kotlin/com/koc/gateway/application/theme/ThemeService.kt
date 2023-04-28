package com.koc.gateway.application.theme

import com.koc.gateway.domain.place.PlaceDto
import com.koc.gateway.domain.theme.ThemeDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.stereotype.Service

@Service
class ThemeService : ThemeUseCase {
    override suspend fun searchTheme(keyword: String?): Page<ThemeDto> {
        return PageImpl(
            listOf(
                ThemeDto(
                    "Mock Theme",
                    setOf(
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
                    ),
                    "U+1F4A9"
                ),
                ThemeDto(
                    "Mock Theme",
                    setOf(
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
                    ),
                    "U+1F4A9"
                ),
                ThemeDto(
                    "Mock Theme",
                    setOf(
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
                    ),
                    "U+1F4A9"
                )
            )
        )
    }
}