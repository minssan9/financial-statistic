package com.voyagerss.financial.scheduler;

import com.voyagerss.financial.service.KrBankAPIBatchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Component
@Profile("prod")
public class KrBankScheduler {

	@Autowired
	private KrBankAPIBatchService krBankAPIBatchService;

	@Scheduled(cron = "0 0 5 * * ?")
	public void saveBalance08JobSch() {
		String nowDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
		String nowTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmss"));

		krBankAPIBatchService.batchKOSPI(nowDate);
//		krBankAPIBatchService.batchKOSPI(nowDate);
	}


	@Scheduled(fixedDelay = 1000)
	public void getStockDataSch() {

	}
}
