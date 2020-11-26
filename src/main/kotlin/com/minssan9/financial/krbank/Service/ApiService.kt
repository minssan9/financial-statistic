package com.minssan9.financial.krbank.Service

import com.minssan9.financial.config.AppProperties
import com.minssan9.financial.krbank.Dto.ApiRequest
import com.minssan9.financial.krbank.Dto.ApiResults
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Slf4j
@Service
@ConfigurationProperties("account")
class ApiService {
    var krbankkey : String = "sample"

    @Autowired
    private lateinit var appProperties: AppProperties

    @Autowired
    lateinit var restTemplate: RestTemplate

    fun getData(apiRequest: ApiRequest): ApiResults {
        return restTemplate.getForObject(
                apiRequest.getUrlString(),
                ApiResults::class.java
        )!!
    }
    fun getKOSPIUrl(queryStartDate: String, queryEndDate: String): String {
        return ApiRequest(
                appProperties.krbankkey,
                1,
                1000,
                "064Y001",
                "DD",
                queryStartDate,
                queryEndDate,
                "0001000",
                "",
                "").getUrlString()
    }
    fun getKOSPI(queryStartDate: String, queryEndDate: String): ApiResults {
        return getData(apiRequest =
        ApiRequest(
                appProperties.krbankkey,
                1,
                1000,
                "064Y001",
                "DD",
                queryStartDate,
                queryEndDate,
                "0001000",
                "",
                ""))
    }

}
