package com.minssan9.financial.krbank.service

import com.google.gson.Gson
import com.minssan9.financial.config.AppProperties
import com.minssan9.financial.krbank.domain.KrBankData
import com.minssan9.financial.krbank.dto.ApiDto
import com.minssan9.financial.krbank.repository.KrBankRepository
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.FormHttpMessageConverter
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.StringHttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import java.util.*


@Slf4j
@Service
@ConfigurationProperties("account")
class ApiService {

    @Autowired
    private lateinit var appProperties: AppProperties

//    @Autowired
//    lateinit var restTemplate: RestTemplate

    @Autowired
    lateinit var krBankRepository: KrBankRepository


    fun saveData(krBankDatas: List<KrBankData>) {
        krBankDatas.forEach { i -> krBankRepository.save(i) }
    }


    fun getDataFromAPI(apiRequest: ApiDto.ApiRequest): List<KrBankData>? {
        val gson = Gson()
        val apiDto = ApiDto()

        val converters: MutableList<HttpMessageConverter<*>> = ArrayList()
        val restTemplate = RestTemplate()
        val headers = HttpHeaders()
        // RestTemplate 에 MessageConverter 세팅
        converters.add(FormHttpMessageConverter())
        converters.add(StringHttpMessageConverter())
        converters.add(MappingJackson2HttpMessageConverter())

        restTemplate.messageConverters = converters

        headers.contentType = MediaType.APPLICATION_JSON

        var response: ResponseEntity<String> = restTemplate.getForEntity<String>(apiDto.getUrlString(apiRequest))!!
        var apiResults: ApiDto.ApiResult = gson?.fromJson(response.body, ApiDto.ApiResult::class.java)

        return apiResults.statisticSearch.row
    }


    fun getKOSPI(queryStartDate: String, queryEndDate: String): List<KrBankData>? {
        return getDataFromAPI(apiRequest =
        ApiDto.ApiRequest(appProperties.krbankkey,
                "064Y001",
                queryStartDate,
                queryEndDate,
                "0001000",
                "",
                ""))
    }

}
