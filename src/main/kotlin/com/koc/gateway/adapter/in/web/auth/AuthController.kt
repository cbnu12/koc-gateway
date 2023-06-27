package com.koc.gateway.adapter.`in`.web.auth

import com.koc.gateway.application.auth.KakaoLoginUrlUseCase
import com.koc.gateway.application.auth.TokenUseCase
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("auth")
@Tag(name = "Auth", description = "인증/인가 관련 API")
class AuthController(
   private val tokenUseCase: TokenUseCase,
   private val kakaoLoginUrlUseCase: KakaoLoginUrlUseCase
) {
   @GetMapping("kakao-login-url")
   @Operation(summary = "kakao login url API", description = "카카오 로그인 url을 조회합니다.")
   @ApiResponses(
      ApiResponse(responseCode = "200", description = "OK"),
      ApiResponse(responseCode = "400", description = "Bad Request"),
      ApiResponse(responseCode = "500", description = "Internal Server Error")
   )
   suspend fun getKakaoLoginUrl(): String {
      return kakaoLoginUrlUseCase.getUrl()
   }

   @GetMapping("token")
   @Operation(summary = "token API", description = "토큰을 조회합니다.")
   @ApiResponses(
      ApiResponse(responseCode = "200", description = "OK"),
      ApiResponse(responseCode = "400", description = "Bad Request"),
      ApiResponse(responseCode = "500", description = "Internal Server Error")
   )
   suspend fun getToken(code: String): String {
      return tokenUseCase.getToken(code)
   }

}