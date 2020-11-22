package com.minssan9.financial.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate
import java.time.Duration

@Configuration
class RestConfiguration {
    @Bean
    fun restTemplate(objectMapper: ObjectMapper): RestTemplate {
        return RestTemplateBuilder()
                .rootUri("http://ecos.bok.or.kr/api/StatisticSearch")
                .setConnectTimeout(Duration.ofSeconds(10))
                .additionalMessageConverters()
                .build()
    }
}
