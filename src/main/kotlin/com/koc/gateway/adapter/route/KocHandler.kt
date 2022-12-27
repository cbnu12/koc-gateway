package com.koc.gateway.adapter.route

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class KocHandler {
    fun login(serverRequest: ServerRequest): Mono<ServerResponse> {
        return ServerResponse.ok().bodyValue("hello")
    }
}