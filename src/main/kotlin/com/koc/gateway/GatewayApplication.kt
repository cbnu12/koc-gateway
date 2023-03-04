package com.koc.gateway

import com.koc.gateway.config.PropertiesScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@EnableFeignClients
@SpringBootApplication
@PropertiesScan("classpath*:properties/*.yaml")
class GatewayApplication

fun main(args: Array<String>) {
    runApplication<GatewayApplication>(*args)
}
