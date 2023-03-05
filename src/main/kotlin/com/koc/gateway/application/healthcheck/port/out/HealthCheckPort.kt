package com.koc.gateway.application.healthcheck.port.out

interface HealthCheckPort {
    suspend fun check(url: String): Boolean
}