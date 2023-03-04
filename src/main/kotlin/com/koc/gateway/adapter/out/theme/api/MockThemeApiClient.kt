package com.koc.gateway.adapter.out.theme.api

import com.koc.gateway.application.theme.ThemeDto
import org.springframework.stereotype.Component

@Component
class MockThemeApiClient: ThemeApiClient {

    private val themes = listOf<ThemeDto>(
        ThemeDto(),
        ThemeDto(),
        ThemeDto(),
        ThemeDto(),
        ThemeDto(),
        ThemeDto(),
        ThemeDto(),
        ThemeDto(),
        ThemeDto()
    )
    override fun searchRecommendationTheme(): List<ThemeDto> {
        return themes
    }
}