package com.minssan9.financial.common

import com.minssan9.financial.krbank.dto.ApiDto
import com.minssan9.financial.krbank.service.ApiService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


@Component
class Scheduler{
    @Autowired
    lateinit var apiService : ApiService

    @Scheduled(cron = "0 0 8 * * ?")
    fun scheduler (){
        val now = LocalDateTime.now()
        val nowDate = now.format(DateTimeFormatter.ofPattern("yyyyMMdd"))
        val nowTime = now.format(DateTimeFormatter.ofPattern("HHmmss"))

        //Kospi index
        var apiRequest = ApiDto.ApiRequest(
                "064Y001",
                nowDate,
                nowDate,
                "0001000",
                "",
                "")
        apiService.saveData(apiRequest)

    }

}
