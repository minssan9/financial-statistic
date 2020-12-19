package com.minssan9.financial.common

import com.minssan9.financial.krbank.dto.KrBankDto
import com.minssan9.financial.krbank.service.KrBankApiService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


@Component
class Scheduler{
    @Autowired
    lateinit var krBankApiService : KrBankApiService

    @Scheduled(cron = "0 0 8 * * ?")
    fun scheduler (){
        val now = LocalDateTime.now()
        val nowDate = now.format(DateTimeFormatter.ofPattern("yyyyMMdd"))
        val nowTime = now.format(DateTimeFormatter.ofPattern("HHmmss"))

        //Kospi index
        var krBankRequest = KrBankDto.KrBankRequest(
                "064Y001",
                "0001000",
                "",
                "",
                nowDate,
                nowDate,
    1, 1000)
        krBankApiService.getDataFromAPI(krBankRequest)?.let { krBankApiService.saveData(it) }

    }

}
