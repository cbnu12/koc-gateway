package com.koc.gateway.application.theme.port.`in`

import com.koc.gateway.application.theme.ThemeDto

interface RecommendationThemeSearchUseCase {
    suspend fun search(): List<ThemeDto>
}