package com.batch.job;


import com.core.apiservice.EcosApiService;
import com.core.dto.EcosDto;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class EcosJobConfig {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Autowired
    EcosApiService ecosApiService;

    @Bean
    public Job simpleJob() {
        String nowDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        return jobBuilderFactory.get("simpleJob")
                .start(ecosDataStep())
            .build();
//        return jobBuilderFactory.get("sampleJob")
//                .start(sampleStep1(null))
//                    .on("FAILED")
//                    .to(sampleStep3())
//                    .on("*")
//                    .end()
//                .from(sampleStep1(null))
//                    .on("*")
//                    .to(sampleStep2())
//                    .next(sampleStep3())
//                    .on("*")
//                    .end()
//                .end()
//                .build();
    }

//    @Value("#{jobParameters[startDate]}") String startDate, @Value("#{jobParameters[endDate]}") String endDate
    @Bean
    public Step ecosDataStep() {
        return stepBuilderFactory.get("ecosDataStep")
            .tasklet((contribution, chunkContext) -> {

                String startDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
                String endDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
                log.info("sampleStep1 start : {}", startDate, endDate);

                EcosDto ecosDto = new EcosDto();
                ecosDto.setQueryStartDate(startDate);
                ecosDto.setQueryEndDate(endDate);
                ecosApiService.retrieveDataFromAllSchema(ecosDto);
//                contribution.setExitStatus(ExitStatus.COMPLETED);

//                if (false) {
                    log.error("ERROR");
//                    contribution.setExitStatus(ExitStatus.FAILED);
//                }

                return RepeatStatus.FINISHED;
            }).build();
    }

//    private final EcosJobStep2Tasklet ecosJobStep2Tasklet;

//        @Bean
//        @JobScope
//    public Step sampleStep2() {
//        return stepBuilderFactory.get("sampleStep2")
//            .tasklet(ecosJobStep2Tasklet)
//            .build();
//    }
//
//    @Bean
//    @JobScope
//    public Step sampleStep3() {
//        return stepBuilderFactory.get("sampleStep3")
//            .tasklet((contribution, chunkContext) -> {
//                log.info("sampleStep3 start");
//
//                // step3 logic
//
//                return RepeatStatus.FINISHED;
//            }).build();
//    }
}
