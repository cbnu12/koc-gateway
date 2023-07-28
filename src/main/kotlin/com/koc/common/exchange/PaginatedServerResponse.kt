package com.koc.common.exchange

data class PaginatedServerResponse<T>(
    val page: Int,
    val size: Int,
    val total: Int,
    val items: List<T>
)