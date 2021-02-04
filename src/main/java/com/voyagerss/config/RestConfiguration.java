package com.voyagerss.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Configuration
class RestConfiguration {

    @Bean
    RestTemplate restTemplate()  {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        List<HttpMessageConverter<?>> converters = new ArrayList();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType( MediaType.APPLICATION_JSON);
        // RestTemplate 에 MessageConverter 세팅;
        converters.add(new FormHttpMessageConverter());
        converters.add(new StringHttpMessageConverter());
        converters.add(new MappingJackson2HttpMessageConverter()) ;

        return new RestTemplateBuilder()
                .messageConverters(converters)
                .setConnectTimeout(Duration.ofSeconds(10))
                .additionalMessageConverters( mappingJackson2HttpMessageConverter)
                .build();
    }
}
