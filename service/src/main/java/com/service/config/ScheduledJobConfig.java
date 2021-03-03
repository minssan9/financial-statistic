package com.service.config;

import static com.core.config.StaticConfig.DATE_STRING_FORMAT;

import com.core.api.EcosApiService;
import com.core.repo.EcosSchemaRepo;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
public class ScheduledJobConfig {

    @Autowired
    EcosApiService ecosApiService;
    @Autowired
    EcosSchemaRepo ecosSchemaRepo;

    @Scheduled(cron = "H 22 * * *")
    void retrieveEcosData() throws Exception{
//        ECOS_API_KEY = serviceProperties.getEcosApiKey();
        String nowDate = LocalDateTime.now().format(DATE_STRING_FORMAT);

        ecosApiService.retrieveDataEachSchema(nowDate, nowDate);
    }

}
