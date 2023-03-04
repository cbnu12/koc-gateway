package com.koc.gateway.application.theme.port.out

import com.koc.gateway.application.theme.ThemeDto

interface RecommendationThemeSearchPort {
    suspend fun search(): List<ThemeDto>
}