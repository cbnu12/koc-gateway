package com.koc.gateway.application.home

import org.springframework.data.domain.Page

fun interface TrendPlaceSearchUseCase {
    suspend fun searchTrendPlaces(sortBy: String, page: Int, size:Int): Page<TrendPlaceDto>
}