package com.koc.gateway.config

import org.springframework.context.annotation.Configuration

@Configuration
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPE)
annotation class PropertiesScan(
    val propertiesPath: String
)