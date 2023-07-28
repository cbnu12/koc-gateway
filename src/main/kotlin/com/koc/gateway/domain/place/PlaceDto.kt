package com.koc.gateway.domain.place

data class PlaceDto(
    val id: Long,
    val name: String,
    val content: String,
    val url: String,
    val description: String,
    val postNo: String,
    val street: String,
    val parcel: String,
    val detail: String,
    val longitude: Float,
    val latitude: Float
)