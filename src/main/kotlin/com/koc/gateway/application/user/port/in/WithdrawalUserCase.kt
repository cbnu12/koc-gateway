package com.koc.gateway.application.user.port.`in`

interface WithdrawalUserCase {
    suspend fun withdraw(userId: String)
}