package com.koc.gateway.adapter.out.user

import com.koc.gateway.application.user.UserLoadPort
import com.koc.gateway.application.user.UserResponse
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import org.springframework.web.reactive.function.client.awaitExchange

@Component
class UserAdapter: UserLoadPort {

    private val webClient = WebClient.create("http://211.208.125.180:8085/user")

    override suspend fun loadUser(id: Long): UserResponse {
        return webClient.get()
            .uri("$id")
            .awaitExchange { clientResponse -> clientResponse.awaitBody(UserResponse::class) }
    }

}