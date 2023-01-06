package com.koc.gateway.adapter.out.persistence.user

import com.koc.gateway.application.port.out.LoadUserPort
import com.koc.gateway.application.port.out.SaveUserPort
import com.koc.gateway.domain.user.User
import com.koc.gateway.domain.user.UserDto
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.stereotype.Repository

@Repository
class UserPersistenceAdapter(
    private val userMapper: UserMapper,
    private val userRepository: UserRepository
): LoadUserPort, SaveUserPort {
    override suspend fun findByEmailAndPassword(email: String, password: String): User? {
        val userDocument = userRepository.findByEmailAndPassword(email, password)

        return userDocument?.toDomain(userMapper)
    }

    override suspend fun findByEmail(email: String): User? {
        val userDocument = userRepository.findByEmail(email)

        return userDocument?.toDomain(userMapper)
    }

    override suspend fun save(userDto: UserDto): UserDto {
        var userDocument = userMapper.toEntity(User.create(userDto))
        userDocument = userRepository.save(userDocument).awaitSingle()

        return userMapper.toDto(userDocument)
    }

}

fun UserDocument.toDomain(userMapper: UserMapper): User {
    return userMapper.toDomain(this)
}