package com.koc.gateway.application.course

import com.koc.gateway.domain.course.CourseDto
import org.springframework.data.domain.Page

interface CourseUseCase {
    suspend fun searchCourse(keyword: String?): Page<CourseDto>

    suspend fun findCourse(id: Long): CourseDto
}