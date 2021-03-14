package com.batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;

@Profile("batch")
@EnableBatchProcessing
@EnableScheduling
@SpringBootApplication
@ComponentScan(basePackages = {  "com.core"})

public class BatchApplication {

    public static void main(String[] args) {

        SpringApplication.run(BatchApplication.class, args);
    }

}
