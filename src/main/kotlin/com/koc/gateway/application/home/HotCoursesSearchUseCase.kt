package com.koc.gateway.application.home

import org.springframework.data.domain.Page

fun interface HotCoursesSearchUseCase {
    suspend fun searchHotCourses(): Page<HotCourseResponse>
}