package com.koc.gateway.domain.user

import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun findByEmail(email: String): UserDto? {
        val user: User? = userRepository.findByEmail(email)
        return UserDto.of(user)
    }

    fun login(userDto: UserDto): Boolean {
        val user: User? = userRepository.findByEmailAndPassword(userDto.email, userDto.password)

        return user != null
    }

    fun isAlreadyJoined(email: String): Boolean {
        return findByEmail(email) != null
    }

    fun createUser(userDto: UserDto): String {
        val user: User = userDto.toEntity()
        return userRepository.save(user)._id.toString()
    }

    fun withdrawalByEmail(email: String) {
        val user: User? = userRepository.findByEmail(email)

        if (user != null) {
            userRepository.delete(user)
        }
    }
}