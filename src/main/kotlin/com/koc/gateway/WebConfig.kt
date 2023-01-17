package com.koc.gateway

import com.koc.common.filter.AuthFilter
import com.koc.common.filter.LogFilter
import com.koc.gateway.adapter.`in`.web.authentication.AuthenticationHandler
import com.koc.gateway.adapter.`in`.web.user.UserHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.config.WebFluxConfigurer
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.coRouter

@Configuration
@EnableWebFlux
class WebConfig(
    private val authenticationHandler: AuthenticationHandler,
    private val userHandler: UserHandler
) : WebFluxConfigurer {

    @Bean
    fun authenticationRoute() =
        coRouter {
            "auth".nest {
                accept(APPLICATION_JSON).nest {
                    POST("/sign-up", authenticationHandler::createUser)
                    POST("/sign-in", authenticationHandler::createToken)
                }

                filter { serverRequest, handler ->
                    filterOnlyLog(serverRequest, handler)
                }
            }
        }

    @Bean
    fun userRoute() =
        coRouter {
            "user".nest {
                accept(APPLICATION_JSON).nest {
                    POST("/withdrawal", userHandler::withdrawal)
                }

                filter { serverRequest, handler ->
                    filterWithLogAndAuth(serverRequest, handler)
                }
            }
        }


    suspend fun filterWithLogAndAuth(serverRequest: ServerRequest, handler: suspend (ServerRequest) -> ServerResponse): ServerResponse {
        val loggedRequest = LogFilter.logRequest(serverRequest)
        val authCheckedRequest = AuthFilter.authCheck(loggedRequest)
        return handler(authCheckedRequest)
    }

    suspend fun filterOnlyLog(serverRequest: ServerRequest, handler: suspend (ServerRequest) -> ServerResponse): ServerResponse {
        val loggedRequest = LogFilter.logRequest(serverRequest)
        return handler(loggedRequest)
    }
}