package com.koc.gateway.adapter.`in`.web.theme

import com.koc.gateway.application.theme.ThemeUseCase
import com.koc.gateway.domain.theme.ThemeDto
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.Page
import org.springframework.stereotype.Component

@Component
@Tag(name = "Theme", description = "테마화면 관련 API")
class ThemeHandler(
    private val themeUseCase: ThemeUseCase
) {
    @Operation(summary = "검색 API", description = "테마를 검색합니다.")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "OK"),
        ApiResponse(responseCode = "400", description = "Bad Request"),
        ApiResponse(responseCode = "500", description = "Internal Server Error")
    )
    suspend fun searchTheme(keyword: String?): Page<ThemeDto> {
        return themeUseCase.searchTheme(keyword)
    }
}