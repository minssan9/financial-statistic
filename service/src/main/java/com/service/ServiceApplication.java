package com.service;

import com.service.dto.KrBankRequest;
import com.service.service.KrBankAPIBatchService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.service.service.KrBankApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication
@EnableScheduling
@Configuration
@EnableAspectJAutoProxy
//@PropertySource(value = {"classpath:account.yml"})
@CrossOrigin(origins = {"*", "http://localhost"})
@Slf4j
public class ServiceApplication {
    public static DateTimeFormatter dateFormatString = DateTimeFormatter.ofPattern("yyyyMMdd");
    public static DateTimeFormatter timeFormatString = DateTimeFormatter.ofPattern("HHmm");

    public static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm");

    @Autowired
    KrBankAPIBatchService krBankAPIBatchService;

    @Autowired
    KrBankApiService krBankApiService;


    @Value("${file.upload-dir}")
    public static String FILE_FOLDER_ROOT_PATH;

    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) throws Exception {
				LocalDateTime oldDateTime = LocalDateTime.now().minusDays(150);
                String todayString = LocalDateTime.now().minusDays(5L).format(dateFormatString);

                krBankAPIBatchService.batchKOSPI(todayString);

//                krBankApiService.batchSchema();
//                krBankAPIBatchService.saveAllBySchema(todayString, todayString);
            }
        };
    }

}
