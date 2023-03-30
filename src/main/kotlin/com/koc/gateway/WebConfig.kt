package com.koc.gateway

import com.koc.common.filter.LogFilter
import com.koc.gateway.adapter.`in`.web.home.HomeHandler
import org.springdoc.core.annotations.RouterOperation
import org.springdoc.core.annotations.RouterOperations
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
    private val homeHandler: HomeHandler
) : WebFluxConfigurer {
    @Bean
    @RouterOperations(
        RouterOperation(path = "/home/trend-places", beanClass = HomeHandler::class, beanMethod = "searchTrendPlaces"),
        RouterOperation(path = "/home/recommend-themes", beanClass = HomeHandler::class, beanMethod = "searchRecommendationThemes"),
        RouterOperation(path = "/home/hot-courses", beanClass = HomeHandler::class, beanMethod = "searchHotCourses")
    )
    fun homeRoute() =
        coRouter {
            "home".nest {
                accept(APPLICATION_JSON).nest {
                    GET("/trend-places", homeHandler::searchTrendPlaces)
                    GET("/recommend-themes", homeHandler::searchRecommendationThemes)
                    GET("/hot-courses", homeHandler::searchHotCourses)
                }

                filter { serverRequest, handler ->
                    filterOnlyLog(serverRequest, handler)
                }
            }
        }

    suspend fun filterOnlyLog(
        serverRequest: ServerRequest,
        handler: suspend (ServerRequest) -> ServerResponse
    ): ServerResponse {
        val loggedRequest = LogFilter.logRequest(serverRequest)
        return handler(loggedRequest)
    }
}