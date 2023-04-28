package com.koc.gateway.adapter.`in`.web.course

import com.koc.gateway.application.course.CourseUseCase
import com.koc.gateway.domain.course.CourseDto
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.Page
import org.springframework.stereotype.Component

@Component
@Tag(name = "Course", description = "코스화면 관련 API")
class CourseHandler(
    private val courseUseCase: CourseUseCase
) {
    @Operation(summary = "검색 API", description = "코스를 검색합니다.")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "OK"),
        ApiResponse(responseCode = "400", description = "Bad Request"),
        ApiResponse(responseCode = "500", description = "Internal Server Error")
    )
    suspend fun searchCourse(keyword: String?): Page<CourseDto> {
        return courseUseCase.searchCourse(keyword)
    }

    @Operation(summary = "조회 API", description = "id값으로 코스를 조회합니다.")
    @ApiResponses(
        ApiResponse(responseCode = "200", description = "OK"),
        ApiResponse(responseCode = "400", description = "Bad Request"),
        ApiResponse(responseCode = "500", description = "Internal Server Error")
    )
    suspend fun findCourse(id: Long): CourseDto {
        return courseUseCase.findCourse(id)
    }
}