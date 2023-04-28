package com.koc.gateway.domain.place

data class PlaceDto(
    val id: Long,
    val name: String,
    val address: String,
    val description: Set<String>,
    val latitude: String,
    val longitude: String
)