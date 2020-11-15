package com.minssan9.financial.krbank.Service

import com.minssan9.financial.krbank.Domain.ApiRequest
import com.minssan9.financial.krbank.Domain.ApiResult
import com.minssan9.financial.krbank.Domain.ApiResults
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class ApiService() {

    lateinit var restTemplate: RestTemplate

    fun getKOSPI(): ApiResults {
        var apiResults: ApiResults = getData(apiRequest =
        ApiRequest(1,
                1000,
                "064Y001",
                "DD",
                "202001",
                "202011",
                "0001000",
                "",
                ""))
        return apiResults
    }

    fun getData(apiRequest: ApiRequest): ApiResults {

        var url = apiRequest.url + "/" +
                apiRequest.serviceName + "/" +
                apiRequest.authKey + "/" +
                apiRequest.requestType + "/" +
                apiRequest.language + "/" +
                apiRequest.reqStartCount + "/" + apiRequest.reqEndCount + "/" +
                apiRequest.statisticCode + "/" +
                apiRequest.period + "/" +
                apiRequest.queryStartDate + "/" + apiRequest.queryEndDate + "/" +
                apiRequest.option1 + "/"

        return restTemplate.getForObject(url , ApiResults::class.java)!!
    }
}
