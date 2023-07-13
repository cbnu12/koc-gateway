package com.koc.gateway.application.home

import org.springframework.data.domain.Page

fun interface RecommendSearchUseCase {
    suspend fun searchRecommendTheme(): Page<RecommendedThemeDto>
}