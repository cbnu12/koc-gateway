package com.koc.gateway.domain.jwt

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import org.springframework.web.util.pattern.PathPattern
import org.springframework.web.util.pattern.PathPatternParser
import reactor.core.publisher.Mono


@Component
class JwtFilter: WebFilter {
    private val AUTHORIZATION_HEADER: String  = "Authorization"
    private val BEARER_PREFIX: String = "Bearer "
    private val passPathPattern: PathPattern = PathPatternParser().parse("/sign-in")
    private val log: Logger = LoggerFactory.getLogger(JwtFilter::class.java)

    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> {
        log.info("filter works")

        if(!passPathPattern.matches(exchange.request.path)) {
           return jwtFilter(exchange, chain)
        }

        return chain.filter(exchange)
    }

    fun jwtFilter(exchange: ServerWebExchange, chain: WebFilterChain):Mono<Void> {
        // acquire jwt
        val token: String? = exchange.request.headers.getOrEmpty(AUTHORIZATION_HEADER)
            .firstOrNull()

        // if token does not exist return unauthorized
        if(token == null) {
            val response = exchange.response
            response.statusCode = HttpStatus.UNAUTHORIZED
            return response.setComplete()
        }

        // validate token
        val validateResult: Boolean = JwtProvider.validate(token)


        return chain.filter(exchange)
    }
}