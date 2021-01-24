package com.minssan9.financial.krbank.dto

import com.google.gson.annotations.SerializedName
import com.minssan9.financial.config.AppProperties
import com.minssan9.financial.krbank.domain.KrBankData
import com.minssan9.financial.krbank.domain.KrBankSchema
import lombok.*
import org.springframework.beans.factory.annotation.Autowired
import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

class KrBankDto {


    @Data
    @NoArgsConstructor
    data class KrBankRequest(
            var statisticCode: String,
            var option1: String,
            var option2: String,
            var option3: String,
            var queryStartDate: String,
            var queryEndDate: String,
            var reqStartCount: Long,
            var reqEndCount: Long,
    ){
        @Autowired
        lateinit var appProperties: AppProperties

        var serviceName: String=""
        var url: String = "http://ecos.bok.or.kr/api"
        var authKey: String = appProperties.krbankkey
        var requestType: String = "json"
        var language: String = "kr"
        var period: String = "DD"
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
