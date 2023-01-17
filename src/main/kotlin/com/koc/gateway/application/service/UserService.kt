package com.koc.gateway.application.service

import com.koc.gateway.adapter.out.persistence.user.UserMapper
import com.koc.gateway.application.port.`in`.WithdrawalUserCase
import com.koc.gateway.application.port.out.LoadUserPort
import com.koc.gateway.application.port.out.SaveUserPort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val loadUserPort: LoadUserPort,
    private val saveUserPort: SaveUserPort,
    private val userMapper: UserMapper
): WithdrawalUserCase {

    @Transactional
    override suspend fun withdraw(userId: String) {
        val user = loadUserPort.findById(userId)

        user?.withdraw()

        user?.let {
            saveUserPort.save(userMapper.toDto(it))
        }
    }
}