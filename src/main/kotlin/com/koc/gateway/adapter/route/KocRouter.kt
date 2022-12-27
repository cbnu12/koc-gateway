package com.koc.gateway.adapter.route

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.function.server.RequestPredicates.accept
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions.route

@Configuration
@EnableWebFlux
class KocRouter(
    private val kocHandler: KocHandler
) {

    @Bean
    fun personRouter(): RouterFunction<*>? {
        return route()
            .GET("/hello", accept(APPLICATION_JSON), kocHandler::login)
            .POST("/sign-in", accept(APPLICATION_JSON), kocHandler::login)
            .POST("/sign-up", accept(APPLICATION_JSON), kocHandler::login)
            .build()
    }
}