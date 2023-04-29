package com.koc.gateway.application.course

import com.koc.gateway.domain.course.CourseDto
import com.koc.gateway.domain.place.PlaceDto
import com.koc.gateway.domain.user.UserDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.stereotype.Service

@Service
class CourseService : CourseUseCase {
    override suspend fun searchCourse(keyword: String?): Page<CourseDto> {
        return PageImpl(
                listOf(
                        CourseDto(
                                "Mock Course",
                                UserDto("Mock User Name"),
                                listOf(
                                        PlaceDto(
                                                1L,
                                                "Mock Place",
                                                "Mock Address",
                                                setOf("description1", "description2"),
                                                "37.4020051732617",
                                                "127.108662792918"

                                        ),
                                        PlaceDto(
                                                2L,
                                                "Mock Place",
                                                "Mock Address",
                                                setOf("description1", "description2"),
                                                "37.4020051732617",
                                                "127.108662792918"
                                        ),
                                        PlaceDto(
                                                3L,
                                                "Mock Place",
                                                "Mock Address",
                                                setOf("description1", "description2"),
                                                "37.4020051732617",
                                                "127.108662792918"
                                        )
                                ),
                                "U+1F4A9"
                        )
                )
        )
    }

    override suspend fun findCourse(id: Long): CourseDto {
        return CourseDto(
                "Mock Course",
                UserDto("Mock User Name"),
                listOf(
                        PlaceDto(
                                1L,
                                "Mock Place",
                                "Mock Address",
                                setOf("description1", "description2"),
                                "37.4020051732617",
                                "127.108662792918"
                        ),
                        PlaceDto(
                                2L,
                                "Mock Place",
                                "Mock Address",
                                setOf("description1", "description2"),
                                "37.4020051732617",
                                "127.108662792918"
                        ),
                        PlaceDto(
                                3L,
                                "Mock Place",
                                "Mock Address",
                                setOf("description1", "description2"),
                                "37.4020051732617",
                                "127.108662792918"
                        )
                ),
                "U+1F4A9"
        )
    }
}