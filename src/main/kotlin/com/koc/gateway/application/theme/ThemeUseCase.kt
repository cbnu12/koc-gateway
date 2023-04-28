package com.koc.gateway.application.theme

import com.koc.gateway.domain.theme.ThemeDto
import org.springframework.data.domain.Page

interface ThemeUseCase {
    suspend fun searchTheme(keyword: String?): Page<ThemeDto>
}