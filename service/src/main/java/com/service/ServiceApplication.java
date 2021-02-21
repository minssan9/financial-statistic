package com.service;

import com.service.properties.ServiceProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@SpringBootApplication
@Configuration
@EnableAspectJAutoProxy
@EnableMongoRepositories(basePackages = "com.core.mongorepo")
@EnableJpaRepositories(basePackages = {"com.core.repo"})
@EntityScan(basePackages = "com.core.domain")
@ComponentScan(basePackages = {  "com.core", "com.service"})
@CrossOrigin(origins = {"*", "http://localhost"})
@Slf4j
public class ServiceApplication implements ApplicationRunner {
    public static DateTimeFormatter dateFormatString = DateTimeFormatter.ofPattern("yyyyMMdd");
    public static DateTimeFormatter timeFormatString = DateTimeFormatter.ofPattern("HHmm");

    public static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");

    public static String ECOS_API_KEY ;

    @Autowired
    ServiceProperties serviceProperties;


    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ECOS_API_KEY = serviceProperties.getEcosApiKey();

        LocalDateTime oldDateTime = LocalDateTime.now().minusDays(150);
        String todayString = LocalDateTime.now().minusDays(2L).format(dateFormatString);


//                krBankAPIBatchService.batchKOSPI(todayString);
//        ecosApiService.batchSchema();
//        ecosApiService.saveDataEachSchema("20210210", "20210210");

    }
}
