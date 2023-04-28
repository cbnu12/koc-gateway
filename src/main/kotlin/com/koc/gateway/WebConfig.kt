package com.koc.gateway

import com.koc.common.filter.LogFilter
import com.koc.gateway.adapter.`in`.web.course.CourseHandler
import com.koc.gateway.adapter.`in`.web.home.HomeHandler
import com.koc.gateway.adapter.`in`.web.map.MapHandler
import com.koc.gateway.adapter.`in`.web.place.PlaceHandler
import com.koc.gateway.adapter.`in`.web.theme.ThemeHandler
import org.springdoc.core.annotations.RouterOperation
import org.springdoc.core.annotations.RouterOperations
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.config.EnableWebFlux
import org.springframework.web.reactive.config.WebFluxConfigurer
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.coRouter
import kotlin.jvm.optionals.getOrNull

@OptIn(ExperimentalStdlibApi::class)
@Configuration
@EnableWebFlux
class WebConfig(
    private val homeHandler: HomeHandler,
    private val mapHandler: MapHandler,
    private val themeHandler: ThemeHandler,
    private val courseHandler: CourseHandler,
    private val placeHandler: PlaceHandler
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

    @Bean
    @RouterOperations(
        RouterOperation(path = "/map", beanClass = MapHandler::class, beanMethod = "searchPlace")
    )
    fun mapRouter() =
        coRouter {
            "map".nest {
                accept(APPLICATION_JSON).nest {
                    GET("") { request ->
                        val latitude = request.queryParam("latitude").get()
                        val longitude = request.queryParam("longitude").get()

                        val result = mapHandler.searchPlace(latitude, longitude)

                        ok().bodyValueAndAwait(result)
                    }
                }
            }
        }

    @Bean
    @RouterOperations(
        RouterOperation(path = "/theme", beanClass = ThemeHandler::class, beanMethod = "searchTheme")
    )
    fun themeRouter() =
        coRouter {
            "theme".nest {
                accept(APPLICATION_JSON).nest {
                    GET("") { request ->
                        val keyword = request.queryParam("keyword").getOrNull()

                        val result = themeHandler.searchTheme(keyword)

                        ok().bodyValueAndAwait(result)
                    }
                }
            }
        }

    @Bean
    @RouterOperations(
        RouterOperation(path = "/course/search", beanClass = CourseHandler::class, beanMethod = "searchCourse"),
        RouterOperation(path = "/course/{id}", beanClass = CourseHandler::class, beanMethod = "findCourse")
    )
    fun courseRouter() =
        coRouter {
            "course".nest {
                accept(APPLICATION_JSON).nest {
                    GET("search") { request ->
                        val keyword = request.queryParam("keyword").getOrNull()

                        val result = courseHandler.searchCourse(keyword)

                        ok().bodyValueAndAwait(result)
                    }

                    GET("{id}") { request ->
                        val id = request.pathVariable("id").toLong()

                        val result = courseHandler.findCourse(id)

                        ok().bodyValueAndAwait(result)
                    }
                }
            }
        }

    @Bean
    @RouterOperations(
        RouterOperation(path = "/place/{id}", beanClass = PlaceHandler::class, beanMethod = "findPlace")
    )
    fun placeRouter() =
        coRouter {
            "place".nest {
                accept(APPLICATION_JSON).nest {
                    GET("{id}") { request ->
                        val id = request.pathVariable("id").toLong()

                        val result = placeHandler.findPlace(id)

                        ok().bodyValueAndAwait(result)
                    }
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