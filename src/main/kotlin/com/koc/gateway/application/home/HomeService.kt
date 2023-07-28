package com.koc.gateway.application.home

import com.koc.gateway.application.user.UserLoadPort
import com.koc.gateway.domain.place.PlaceService
import com.koc.gateway.domain.user.UserDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.stereotype.Service

@Service
class HomeService(
        private val userLoadPort: UserLoadPort,
        private val placeService: PlaceService
) : RecommendSearchUseCase, HotCoursesSearchUseCase, TrendPlaceSearchUseCase {
    override suspend fun searchTrendPlaces(sortBy: String, page: Int, size:Int): Page<TrendPlaceDto> {
            val places = placeService.loadPlace(sortBy, page, size).items

        return PageImpl(
                places.map { TrendPlaceDto(id = it.id,
                        name = it.name,
                        address = it.street,
                        descriptions = setOf(it.description),
                        category = "Mock category"
                        ) }
                )
    }

    override suspend fun searchRecommendTheme(): Page<RecommendedThemeDto> {
        return PageImpl(
                listOf(
                        RecommendedThemeDto(
                                1L,
                                "Mock Recommended Theme",
                                3,
                                "U+1F44D"
                        ),
                        RecommendedThemeDto(
                                1L,
                                "Mock Recommended Theme",
                                2,
                                "U+1F525"
                        ),
                        RecommendedThemeDto(
                                1L,
                                "Mock Recommended Theme",
                                5,
                                "U+1F4A9"
                        ),
                        RecommendedThemeDto(
                                1L,
                                "Mock Recommended Theme",
                                1,
                                "U+1F4A9"
                        )
                )
        )
    }

    override suspend fun searchHotCourses(): Page<HotCourseResponse> {
        return PageImpl(
                listOf(
                        HotCourseResponse(
                                1L,
                                "Mock Hot Cource",
                                UserDto("Kang"),
                                3,
                                "U+1F44D"
                        ),
                        HotCourseResponse(
                                1L,
                                "Mock Hot Cource",
                                UserDto("Soung"),
                                3,
                                "U+1F44D"
                        ),
                        HotCourseResponse(
                                1L,
                                "Mock Hot Cource",
                                UserDto("Jo"),
                                3,
                                "U+1F44D"
                        ),
                        HotCourseResponse(
                                1L,
                                "Mock Hot Cource",
                                UserDto("Fuck"),
                                3,
                                "U+1F44D"
                        ),
                )
        )
    }
}