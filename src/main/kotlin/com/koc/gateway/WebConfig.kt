package com.koc.gateway

import com.koc.gateway.adapter.`in`.web.authentication.AuthenticationHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.config.WebFluxConfigurer
import org.springframework.web.reactive.function.server.coRouter

@Configuration
@EnableWebFlux
class WebConfig(
    private val authenticationHandler: AuthenticationHandler
) : WebFluxConfigurer {

    @Bean
    fun authenticationRoute() =
        coRouter {
            "auth".nest {
                accept(APPLICATION_JSON).nest {
                    POST("/sign-up", authenticationHandler::createUser)
                    POST("/sign-in", authenticationHandler::createToken)
                }
            }
        }
}