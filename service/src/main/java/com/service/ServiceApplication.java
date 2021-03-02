package com.service;

import com.core.api.EcosApiService;
import com.service.properties.ServiceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication
@ComponentScan(basePackages = {  "com.core", "com.service"})
@CrossOrigin(origins = {"*", "http://localhost"})
public class ServiceApplication implements ApplicationRunner {

    @Autowired
    ServiceProperties serviceProperties;

    @Autowired
    EcosApiService ecosApiService;

    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
//        System.out.println(ECOS_API_KEY);
    }


}
