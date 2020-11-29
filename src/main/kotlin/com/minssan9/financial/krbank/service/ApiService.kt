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
    lateinit var restTemplate: RestTemplate

    @Autowired
    lateinit var krBankRepository: KrBankRepository


    fun saveData(apiRequest: ApiDto.ApiRequest){
        getDataFromAPI(apiRequest)?.
                forEach{ i-> krBankRepository.save(i)}
    }


    fun getDataFromAPI(apiRequest: ApiDto.ApiRequest): List<KrBankData>? {
        val gson = Gson()
        val apiDto = ApiDto()

        var response: ResponseEntity<String> = restTemplate.getForObject(apiDto.getUrlString(apiRequest))!!
        return gson?.fromJson(response.body, ApiDto.ApiResult::class.java).statisticSearch.row
    }


    fun getKOSPI(queryStartDate: String, queryEndDate: String): List<KrBankData>? {
        return getDataFromAPI(apiRequest =
        ApiDto.ApiRequest(
                "064Y001",
                queryStartDate,
                queryEndDate,
                "0001000",
                "",
                ""))
    }

}
