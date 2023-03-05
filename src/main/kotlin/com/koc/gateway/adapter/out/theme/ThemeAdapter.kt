package com.koc.gateway.adapter.out.theme

import com.koc.gateway.adapter.out.theme.api.ThemeApiClient
import com.koc.gateway.application.theme.ThemeDto
import com.koc.gateway.application.theme.port.out.RecommendationThemeSearchPort
import org.springframework.stereotype.Component

@Component
class ThemeAdapter(
    private val themeApiClient: ThemeApiClient
): RecommendationThemeSearchPort {
    override suspend fun search(): List<ThemeDto> {
        return themeApiClient.searchRecommendationTheme()
    }

}