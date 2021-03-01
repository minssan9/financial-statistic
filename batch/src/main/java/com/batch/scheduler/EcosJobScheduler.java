package com.batch.scheduler;

import com.batch.job.EcosJobConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EcosJobScheduler {
    private final JobLauncher jobLauncher;
    private final EcosJobConfig ecosJobConfig;


    @Scheduled(cron = "0 0 20 * * ?")
    public void saveBalance08JobSch() {

    }


    @Scheduled(cron = "0 0 13 * * *", zone = "Asia/Seoul")
    public void runJob() {
        log.info("sampleJob start");

        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addString("str", "TEST")
                    .toJobParameters();
            jobLauncher.run(ecosJobConfig.sampleJob(), jobParameters);

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

}
