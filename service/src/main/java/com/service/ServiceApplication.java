package com.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.service.config.KrBankProperties;
import com.service.service.EcosApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication
@EnableScheduling
@Configuration
@EnableAspectJAutoProxy
@EnableMongoRepositories(basePackages = "com.service.mongorepo")
@EnableJpaRepositories(basePackages = {"com.service.repository"})
@ComponentScan(basePackages = {  "com.core", "com.service"})
@CrossOrigin(origins = {"*", "http://localhost"})
@Slf4j
public class ServiceApplication {
    public static DateTimeFormatter dateFormatString = DateTimeFormatter.ofPattern("yyyyMMdd");
    public static DateTimeFormatter timeFormatString = DateTimeFormatter.ofPattern("HHmm");

    public static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");

    @Autowired
    EcosApiService ecosApiService;


    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            KrBankProperties krBankProperties = new KrBankProperties();
            log.info(krBankProperties.getApikey());
            LocalDateTime oldDateTime = LocalDateTime.now().minusDays(150);
            String todayString = LocalDateTime.now().minusDays(2L).format(dateFormatString);


//                krBankAPIBatchService.batchKOSPI(todayString);
            ecosApiService.batchSchema();
            ecosApiService.saveDataEachSchema("20210210", "20210210");
        };
    }

}
