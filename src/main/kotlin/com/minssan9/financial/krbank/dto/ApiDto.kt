package com.minssan9.financial.krbank.dto

import com.google.gson.annotations.SerializedName
import com.minssan9.financial.krbank.domain.KrBankData
import com.minssan9.financial.krbank.domain.KrBankSchema
import lombok.Builder
import lombok.Data
import lombok.RequiredArgsConstructor
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

class ApiDto {

    @Builder
    @Data
    @RequiredArgsConstructor
    data class KrBankRequest(
            val authKey: String,
            val statisticCode: String,
            val queryStartDate: String,
            val queryEndDate: String,
            val option1: String,
            val option2: String,
            val option3: String,
    ){

        val url: String = "http://ecos.bok.or.kr/api"
        val serviceName: String = "StatisticSearch"
        val requestType: String = "json"
        val language: String = "kr"
        val reqStartCount: Long = 1
        val reqEndCount: Long = 1000
        val period: String = "DD"
    }

//    http://ecos.bok.or.kr/api/StatisticTableList/sample/xml/kr/1/10/
    fun getUrlString(krBankRequest: KrBankRequest) : String {
        return krBankRequest.url + "/" +
                krBankRequest.serviceName + "/" +
                krBankRequest.authKey + "/" +
                krBankRequest.requestType + "/" +
                krBankRequest.language + "/" +
                krBankRequest.reqStartCount + "/" + krBankRequest.reqEndCount + "/" +
                krBankRequest.statisticCode + "/" +
                krBankRequest.period + "/" +
                krBankRequest.queryStartDate + "/" + krBankRequest.queryEndDate + "/" +
                krBankRequest.option1 + "/"
    }

    data class KrBankSchemaResponse(
        @SerializedName("StatisticSearch")
        val krBankResult: KrBankSchemaResult
    )
    data class KrBankSchemaResult(
        @SerializedName("list_total_count") val list_total_count: Int,
        @SerializedName("row") val row: List<KrBankSchema>
    )




    data class KrBankDataResponse(
        @SerializedName("StatisticSearch")
        val krBankResult: KrBankDataResult
    )

    data class KrBankDataResult(
            @SerializedName("list_total_count") val list_total_count: Int,
            @SerializedName("row") val row: List<KrBankData>
    )
}
