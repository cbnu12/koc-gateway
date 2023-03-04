package com.koc.gateway.application.theme.service

import com.koc.gateway.application.theme.ThemeDto
import com.koc.gateway.application.theme.port.`in`.RecommendationThemeSearchUseCase
import com.koc.gateway.application.theme.port.out.RecommendationThemeSearchPort
import org.springframework.stereotype.Service

@Service
class RecommendationThemeSearchService(
    private val recommendationThemeSearchPort: RecommendationThemeSearchPort
): RecommendationThemeSearchUseCase{
    override suspend fun search(): List<ThemeDto> {
        return recommendationThemeSearchPort.search();
    }
}