package com.minssan9.financial.krbank.service

import com.google.gson.Gson
import com.minssan9.financial.config.AppProperties
import com.minssan9.financial.krbank.domain.KrBankData
import com.minssan9.financial.krbank.domain.KrBankSchema
import com.minssan9.financial.krbank.dto.KrBankDto
import com.minssan9.financial.krbank.repository.KrBankDataRepository
import com.minssan9.financial.krbank.repository.krBankSchemaRepository
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity


@Slf4j
@Service
@ConfigurationProperties("account")
class KrBankApiService {
    @Autowired
    lateinit var gson : Gson


    @Autowired
    lateinit var restTemplate : RestTemplate

    @Autowired
    lateinit var appProperties: AppProperties

    @Autowired
    lateinit var krBankDataRepository: KrBankDataRepository

    @Autowired
    lateinit var krBankSchemaRepository: krBankSchemaRepository


    fun saveData(krBankDatas: List<KrBankData>) {
        krBankDatas.forEach { i -> krBankDataRepository.save(i) }
    }

    fun saveSchema(krBankSchemas: List<KrBankSchema>) {
        krBankSchemas.forEach { i -> krBankSchemaRepository.save(i) }
    }

    fun getDataFromAPI(krBankRequest: KrBankDto.KrBankRequest): List<KrBankData>? {
        val apiDto =KrBankDto()

        krBankRequest.serviceName = "StatisticSearch"

        var response: ResponseEntity<String> = restTemplate.getForEntity<String>(apiDto.getUrlString(krBankRequest))!!
        var krBankDataResponse: KrBankDto.KrBankDataResponse =
            gson?.fromJson(response.body, KrBankDto.KrBankDataResponse::class.java)

        return krBankDataResponse.krBankResult.row
    }

    fun getSchemaFromAPI(krBankRequest: KrBankDto.KrBankRequest ): List<KrBankSchema>? {
        val apiDto =KrBankDto()


        var krBankRequest = KrBankDto.KrBankRequest("","","","","","",krBankRequest.reqStartCount,krBankRequest.reqEndCount)
        krBankRequest.serviceName = "StatisticTableList"

        var response: ResponseEntity<String> = restTemplate.getForEntity<String>(apiDto.getUrlString(krBankRequest))!!
        var krBankSchemaResponse: KrBankDto.KrBankSchemaResponse =
            gson?.fromJson(response.body, KrBankDto.KrBankSchemaResponse::class.java)

        return krBankSchemaResponse.krBankResult.row
    }

    fun getKOSPI(queryStartDate: String, queryEndDate: String, startPos: Long, endPos: Long): List<KrBankData>? {
        return getDataFromAPI(
            krBankRequest =
            KrBankDto.KrBankRequest(
                "064Y001",
                "0001000",
                "",
                "",
                queryStartDate,
                queryEndDate,
                startPos, endPos
            )
        )
    }

}
