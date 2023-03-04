package com.koc.gateway.adapter.out.theme

import com.koc.gateway.adapter.out.theme.api.MockThemeApiClient
import com.koc.gateway.application.theme.ThemeDto
import com.koc.gateway.application.theme.port.out.RecommendationThemeSearchPort
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Component

@Component
class ThemeAdapter(
    private val themeApiClient: MockThemeApiClient
): RecommendationThemeSearchPort {
    override suspend fun search(): List<ThemeDto> {
        return withContext(Dispatchers.IO) {
            themeApiClient.searchRecommendationTheme()
        }
    }

}