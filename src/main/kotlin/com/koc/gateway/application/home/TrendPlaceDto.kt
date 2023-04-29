package com.koc.gateway.application.home

data class TrendPlaceDto(
        val id: Long,
        val name: String,
        val address: String,
        val descriptions: Set<String>,
        val category: String
)