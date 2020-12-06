package com.minssan9.financial.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.converter.FormHttpMessageConverter
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.StringHttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.client.RestTemplate
import java.time.Duration
import java.util.ArrayList

@Configuration
class RestConfiguration {
    @Bean
    fun restTemplate(): RestTemplate {
        var mappingJackson2HttpMessageConverter = MappingJackson2HttpMessageConverter()
        val converters: MutableList<HttpMessageConverter<*>> = ArrayList()
        val headers = HttpHeaders()

        headers.contentType = MediaType.APPLICATION_JSON
        // RestTemplate 에 MessageConverter 세팅
        converters.add(FormHttpMessageConverter())
        converters.add(StringHttpMessageConverter())
        converters.add(MappingJackson2HttpMessageConverter()) 

        return RestTemplateBuilder()
                .messageConverters(converters)
                .setConnectTimeout(Duration.ofSeconds(10))
                .additionalMessageConverters( mappingJackson2HttpMessageConverter)
                .build()
    }
}
