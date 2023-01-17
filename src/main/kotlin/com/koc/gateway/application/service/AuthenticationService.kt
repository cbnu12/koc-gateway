package com.koc.gateway.application.service

import com.koc.common.jwt.JwtProvider
import com.koc.gateway.adapter.`in`.web.authentication.SignInResponseDto
import com.koc.gateway.adapter.`in`.web.authentication.SignUpResponseDto
import com.koc.gateway.adapter.out.persistence.user.UserMapper
import com.koc.gateway.application.port.`in`.SignInUseCase
import com.koc.gateway.application.port.`in`.SignUpUseCase
import com.koc.gateway.application.port.out.LoadUserPort
import com.koc.gateway.application.port.out.SaveUserPort
import com.koc.gateway.domain.user.User
import com.koc.gateway.domain.user.UserDto
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AuthenticationService(
    private val loadUserPort: LoadUserPort,
    private val saveUserPort: SaveUserPort,
    private val userMapper: UserMapper
) : SignInUseCase, SignUpUseCase {
    @Transactional(readOnly = true)
    override suspend fun signIn(userDto: UserDto): SignInResponseDto {
        val email = userDto.email!!
        val password = userDto.password!!

        val user = loadUserPort.findByEmailAndPassword(email, password)

        return if (user != null) {
            val accessToken = JwtProvider.createAccessToken()
            val refreshToken = JwtProvider.createRefreshToken()
            SignInResponseDto.success(accessToken = accessToken, refreshToken = refreshToken)
        } else {
            SignInResponseDto.fail(null)
        }
    }

    @Transactional
    override suspend fun signUp(userDto: UserDto): SignUpResponseDto {
        userDto.email?.let {
            loadUserPort.findByEmail(it)?.let {
                return SignUpResponseDto.fail("already exist", "email")
            }
        }

        val user = User.create(userDto)

        val createdUserDto = saveUserPort.save(userMapper.toDto(user))

        return SignUpResponseDto.success(createdUserDto.id!!)
    }
}