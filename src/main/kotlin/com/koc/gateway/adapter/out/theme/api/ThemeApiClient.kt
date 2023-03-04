package com.koc.gateway.adapter.out.theme.api

import com.koc.gateway.application.theme.ThemeDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(name = "theme", url="http://temptempTheme")
interface ThemeApiClient {

    @GetMapping("/theme/recommendation")
    fun searchRecommendationTheme(): List<ThemeDto>
}