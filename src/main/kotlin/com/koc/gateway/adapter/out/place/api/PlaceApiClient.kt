package com.koc.gateway.adapter.out.place.api

import com.koc.gateway.application.place.PlaceDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(name = "place", url="http://temptempPlace")
interface PlaceApiClient {

    @GetMapping("/place/trends")
    fun searchTrendPlaces(): List<PlaceDto>
}