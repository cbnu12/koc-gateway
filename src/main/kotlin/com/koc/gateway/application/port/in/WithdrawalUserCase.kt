package com.koc.gateway.application.port.`in`

interface WithdrawalUserCase {
    suspend fun withdraw(userId: String)
}