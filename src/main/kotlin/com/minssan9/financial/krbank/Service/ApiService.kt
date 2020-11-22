package com.minssan9.financial.krbank.Service

import com.minssan9.financial.krbank.Dto.ApiRequest
import com.minssan9.financial.krbank.Dto.ApiResults
import lombok.extern.slf4j.Slf4j
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Slf4j
@Service
class ApiService {

    final lateinit var restTemplate: RestTemplate

    fun ApiService(builder: RestTemplateBuilder){
        this.restTemplate = builder.build();
    }

    fun getData(apiRequest: ApiRequest): ApiResults {
        return restTemplate.getForObject(apiRequest.getUrlString() , ApiResults::class.java)!!
    }

    fun getKOSPI(queryStartDate : String, queryEndDate : String ): ApiResults {
        var apiResults: ApiResults = getData(apiRequest =
        ApiRequest(1,
                1000,
                "064Y001",
                "DD",
                queryStartDate,
                queryEndDate,
                "0001000",
                "",
                ""))
        return apiResults
    }

}
