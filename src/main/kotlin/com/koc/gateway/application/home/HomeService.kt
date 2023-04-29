package com.koc.gateway.application.home

import com.koc.gateway.application.place.PlacePort
import com.koc.gateway.domain.user.UserDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.stereotype.Service

@Service
class HomeService(
        private val placePort: PlacePort
) : HomeUseCase {
    override suspend fun searchTrendPlaces(): Page<TrendPlaceDto> {
        return PageImpl(
                listOf(
                        TrendPlaceDto(
                                "Mock Trend Place",
                                "Mock Address",
                                setOf("description1", "description2"),
                                "Mock category"
                        ),
                        TrendPlaceDto(
                                "Mock Trend Place",
                                "Mock Address",
                                setOf("description1", "description2"),
                                "Mock category"
                        ),
                        TrendPlaceDto(
                                "Mock Trend Place",
                                "Mock Address",
                                setOf("description1", "description2"),
                                "Mock category"
                        )
                )
        )
    }

    override suspend fun searchRecommendTheme(): Page<RecommendedThemeDto> {
        return PageImpl(
                listOf(
                        RecommendedThemeDto("Mock Recommended Theme",
                                3,
                                "U+1F44D"
                        ),
                        RecommendedThemeDto("Mock Recommended Theme",
                                2,
                                "U+1F525"
                        ),
                        RecommendedThemeDto("Mock Recommended Theme",
                                5,
                                "U+1F4A9"
                        ),
                        RecommendedThemeDto("Mock Recommended Theme",
                                1,
                                "U+1F4A9"
                        )
                )
        )
    }

    override suspend fun searchHotCourses(): Page<HotCourseDto> {
        return PageImpl(
                listOf(
                        HotCourseDto("Mock Hot Cource",
                                UserDto("Kang"),
                                3,
                                "U+1F44D"
                        ),
                        HotCourseDto("Mock Hot Cource",
                                UserDto("Soung"),
                                3,
                                "U+1F44D"
                        ),
                        HotCourseDto("Mock Hot Cource",
                                UserDto("Jo"),
                                3,
                                "U+1F44D"
                        ),
                        HotCourseDto("Mock Hot Cource",
                                UserDto("Fuck"),
                                3,
                                "U+1F44D"
                        ),
                )
        )
    }
}