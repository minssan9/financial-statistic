package com.minssan9.financial.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.client.RestTemplate
import java.time.Duration

@Configuration
class RestConfiguration {
    @Bean
    fun restTemplate(): RestTemplate {
        var mappingJackson2HttpMessageConverter = MappingJackson2HttpMessageConverter()

        return RestTemplateBuilder()
                .setConnectTimeout(Duration.ofSeconds(10))
                .additionalMessageConverters( mappingJackson2HttpMessageConverter)
                .build()
    }
}
