package com.koc.common.server

import com.koc.gateway.config.PropertiesScan
import org.springframework.boot.SpringApplication
import org.springframework.boot.env.EnvironmentPostProcessor
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.core.env.ConfigurableEnvironment
import org.springframework.core.io.support.PathMatchingResourcePatternResolver

@Order(Ordered.HIGHEST_PRECEDENCE)
class CustomEnvironmentPostProcessor(
    private val resolver: PathMatchingResourcePatternResolver = PathMatchingResourcePatternResolver()
) : EnvironmentPostProcessor {
    companion object {
        private const val CONFIG_LOCATION_PROPERTY: String = "spring.config.location"
    }

    override fun postProcessEnvironment(environment: ConfigurableEnvironment?, application: SpringApplication?) {
        setPropertyPath(application)
    }

    private fun setPropertyPath(application: SpringApplication?) {
        application?.let { app ->
            val propertiesScan = getPropertiesScan(app)
            System.setProperty(CONFIG_LOCATION_PROPERTY, makePropertiesString(propertiesScan.propertiesPath))
        }
    }

    private fun getPropertiesScan(application: SpringApplication): PropertiesScan {
        return application.allSources.flatMap { listOf(*(it as Class<*>).annotations) }
            .filterIsInstance<PropertiesScan>()
            .first()
    }

    private fun makePropertiesString(propertyPath: String): String {
        return resolver.getResources(propertyPath)
            .joinToString(separator = ", ") { it.uri.toString() }
    }
}