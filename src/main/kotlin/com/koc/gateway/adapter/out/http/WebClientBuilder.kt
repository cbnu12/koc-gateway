package com.koc.gateway.adapter.out.http

import org.springframework.context.annotation.Bean
import org.springframework.web.reactive.function.client.ExchangeFilterFunction
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

class WebClientBuilder {

    @Bean
    fun webClientBuilder(): WebClient.Builder {
        val circuitBreaker: ExchangeFilterFunction = ExchangeFilterFunction.ofRequestProcessor { clientRequest ->

            Mono.just(clientRequest)
        }

        return WebClient.builder()
            .filter(circuitBreaker)
    }
}