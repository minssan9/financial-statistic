package com.minssan9.financial.krbank.dto

import com.google.gson.annotations.SerializedName
import com.minssan9.financial.config.AppProperties
import com.minssan9.financial.krbank.domain.KrBankData
import lombok.Builder
import lombok.Data
import lombok.RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Required

class ApiDto {

    @Builder
    @Data
    @RequiredArgsConstructor
    data class ApiRequest (
            val statisticCode: String,
            val queryStartDate: String,
            val queryEndDate: String,
            val option1: String,
            val option2: String,
            val option3: String,
    ){
        @Autowired
        private lateinit var appProperties: AppProperties

        val authKey: String = appProperties.krbankkey
        val url: String = "http://ecos.bok.or.kr/api"
        val serviceName: String = "StatisticSearch"
        val requestType: String = "json"
        val language: String = "kr"
        val reqStartCount: Long = 1
        val reqEndCount: Long = 1000
        val period: String = "DD"
    }

    fun getUrlString(apiRequest: ApiRequest) : String {
        return apiRequest.url + "/" +
                apiRequest.serviceName + "/" +
                apiRequest.authKey + "/" +
                apiRequest.requestType + "/" +
                apiRequest.language + "/" +
                apiRequest.reqStartCount + "/" + apiRequest.reqEndCount + "/" +
                apiRequest.statisticCode + "/" +
                apiRequest.period + "/" +
                apiRequest.queryStartDate + "/" + apiRequest.queryEndDate + "/" +
                apiRequest.option1 + "/"
    }

        data class ApiResult(
            @SerializedName("StatisticSearch")
            val statisticSearch: StatisticSearch
    )

    data class StatisticSearch(
            @SerializedName("list_total_count") val list_total_count: Int,
            @SerializedName("row") val row: List<KrBankData>
    )

}
