package com.minssan9.financial.krbank.service

import com.google.gson.Gson
import com.minssan9.financial.config.AppProperties
import com.minssan9.financial.krbank.domain.KrBankData
import com.minssan9.financial.krbank.domain.KrBankSchema
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
import com.sun.corba.se.impl.encoding.CodeSetConversion.impl
import jdk.nashorn.internal.objects.NativeFunction.bind


@Slf4j
@Service
@ConfigurationProperties("account")
class KrBankApiService {

    @Autowired
    private lateinit var appProperties: AppProperties

    @Autowired
    lateinit var krBankRepository: KrBankRepository


    fun saveData(krBankDatas: List<KrBankData>) {
        krBankDatas.forEach { i -> krBankRepository.save(i) }
    }

    fun getDataFromAPI(krBankRequest: ApiDto.KrBankRequest): List<KrBankData>? {
        val gson = Gson()
        val apiDto = ApiDto()
        val restTemplate = RestTemplate()

        var response: ResponseEntity<String> = restTemplate.getForEntity<String>(apiDto.getUrlString(krBankRequest))!!
        var krBankDataResponse: ApiDto.KrBankDataResponse = gson?.fromJson(response.body, ApiDto.KrBankDataResponse::class.java)

        return krBankDataResponse.krBankResult.row
    }

    fun getSchemaFromAPI(krBankRequest: ApiDto.KrBankRequest): List<KrBankSchema>? {
        val gson = Gson()
        val apiDto = ApiDto()
        val restTemplate = RestTemplate()

        var response: ResponseEntity<String> = restTemplate.getForEntity<String>(apiDto.getUrlString(krBankRequest))!!
        var krBankSchemaResponse: ApiDto.KrBankSchemaResponse = gson?.fromJson(response.body, ApiDto.KrBankSchemaResponse::class.java)

        return krBankSchemaResponse.krBankResult.row
    }

    fun getKOSPI(queryStartDate: String, queryEndDate: String): List<KrBankData>? {
        return getDataFromAPI(krBankRequest =
        ApiDto.KrBankRequest(appProperties.krbankkey,
                "064Y001",
                queryStartDate,
                queryEndDate,
                "0001000",
                "",
                ""))
    }

}
