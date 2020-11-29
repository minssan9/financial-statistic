package com.minssan9.financial.krbank.service

import com.google.gson.Gson
import com.minssan9.financial.config.AppProperties
import com.minssan9.financial.krbank.domain.KrBankData
import com.minssan9.financial.krbank.dto.ApiDto
import com.minssan9.financial.krbank.repository.KrBankRepository
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject

@Slf4j
@Service
@ConfigurationProperties("account")
class ApiService {

    @Autowired
    private lateinit var appProperties: AppProperties

    @Autowired
    lateinit var restTemplate: RestTemplate

    @Autowired
    lateinit var krBankRepository: KrBankRepository

    fun saveData(apiRequest: ApiDto.ApiRequest){
        getKOSPI("20200101", "20201120")?.
                forEach{ i-> krBankRepository.save(i)}
    }
    fun getData(apiRequest: ApiDto.ApiRequest): List<KrBankData>? {
        val gson = Gson()
        val apiDto = ApiDto()

        var response: ResponseEntity<String> = restTemplate.getForObject(apiDto.getUrlString(apiRequest))!!
        return gson?.fromJson(response.body, ApiDto.ApiResult::class.java).statisticSearch.row
    }

    fun getKOSPIUrl(queryStartDate: String, queryEndDate: String): String {
        return ApiDto.ApiRequest(
                "",
                "",
                appProperties.krbankkey,
                "",
                "",
                1,
                1000,
                "064Y001",
                "DD",
                queryStartDate,
                queryEndDate,
                "0001000",
                "",
                "").toString()
    }

    fun getKOSPI(queryStartDate: String, queryEndDate: String): List<KrBankData>? {
        return getData(apiRequest =
        ApiDto.ApiRequest(
                "",
                "",
                appProperties.krbankkey,
                "",
                "",
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
