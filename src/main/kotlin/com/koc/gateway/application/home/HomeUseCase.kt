package com.koc.gateway.application.home

import org.springframework.data.domain.Page

interface HomeUseCase {
    suspend fun searchTrendPlaces(): Page<TrendPlaceDto>

    suspend fun searchRecommendTheme(): Page<RecommendedThemeDto>

    suspend fun searchHotCourses(): Page<HotCourseDto>
}