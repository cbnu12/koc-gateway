package com.koc.gateway.adapter.`in`.place.web

data class TrendPlaceResponse(
    val places: Set<Place>
) {
    data class Place(
        val name: String,
        val address: String,
        val descriptions: Set<String>,
        val category: String
    )
}