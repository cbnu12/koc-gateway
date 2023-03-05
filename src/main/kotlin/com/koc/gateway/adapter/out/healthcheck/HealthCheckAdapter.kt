package com.koc.gateway.adapter.out.healthcheck

import com.koc.gateway.application.healthcheck.port.out.HealthCheckPort
import org.springframework.stereotype.Component

@Component
class HealthCheckAdapter: HealthCheckPort {
    override suspend fun check(url: String): Boolean {
        return true
    }
}