package com.service;

import static com.core.config.properties.CoreProperties.DATE_STRING_FORMAT;

import com.core.apiservice.EcosApiService;
import com.core.dto.EcosEnumType.CycleType;
import com.core.dto.EcosDto;
import com.core.repo.EcosSchemaRepo;
import java.time.LocalDateTime;
import javafx.print.PrinterJob.JobStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {  "com.core", "com.service"})
//@CrossOrigin(origins = {"*", "http://localhost"})
public class ServiceApplication implements ApplicationRunner {


    @Autowired
    EcosSchemaRepo ecosSchemaRepo;
    @Autowired
    EcosApiService ecosApiService;

    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        String nowDate = LocalDateTime.now().format(DATE_STRING_FORMAT);
//        ecosApiService.retrieveDataEachSchema(nowDate, nowDate);
//        List<EcosSchema> ecosSchemaList = ecosApiService.retrieveSchema();
        JobStatus jobStatus = ecosApiService.retrieveSchemaDetail();
        ecosApiService.retrieveData(new EcosDto(nowDate, nowDate, CycleType.MM));
//        ecosSchemaRepo.saveAll(ecosSchemaList);
    }


}
