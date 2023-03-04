package com.koc.common.config

import com.mongodb.client.MongoClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.EnableMongoAuditing
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@Configuration
@EnableMongoAuditing
@EnableMongoRepositories
class MongoConfig {

    @Bean
    fun mongoTemplate(mongoClient: MongoClient): MongoTemplate {
        val factory = SimpleMongoClientDatabaseFactory(mongoClient, "koc")
        return MongoTemplate(factory)
    }

}