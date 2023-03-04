package com.koc.gateway.domain.place

data class Place(
    // TODO: 설명 최대 3개?
    // TODO: 뜨는 이유?
    val id: Long,
    val name: String,
    val address: String
) {
}