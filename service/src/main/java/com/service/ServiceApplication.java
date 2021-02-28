package com.service;

import com.service.properties.ServiceProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {  "com.core", "com.service"})
@CrossOrigin(origins = {"*", "http://localhost"})
@Slf4j
public class ServiceApplication implements ApplicationRunner {
    public static String ECOS_API_KEY ;

    @Autowired
    ServiceProperties serviceProperties;


    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ECOS_API_KEY = serviceProperties.getEcosApiKey();


    }
}
