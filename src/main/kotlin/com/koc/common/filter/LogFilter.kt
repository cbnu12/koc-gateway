package com.koc.common.filter

import com.koc.gateway.WebConfig
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.awaitBodyOrNull

object LogFilter {
    private val log: Logger = LoggerFactory.getLogger(WebConfig::class.java)

    suspend fun logRequest(serverRequest: ServerRequest): ServerRequest {
        val requestBody = serverRequest.awaitBodyOrNull<String>()

        log.info("request url : ${serverRequest.path()}, body : $requestBody")

        return ServerRequest.from(serverRequest).body(requestBody ?: "").build()
    }

}