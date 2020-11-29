package com.minssan9.financial.krbank.dto

import com.google.gson.annotations.SerializedName
import com.minssan9.financial.krbank.domain.KrBankData

class ApiDto {
    data class ApiRequest (
        var url: String = "http://ecos.bok.or.kr/api",
        var serviceName: String = "StatisticSearch",
        var authKey: String = "krbankkey",
        var requestType: String = "json",
        var language: String = "kr",
        var reqStartCount: Long,
        var reqEndCount: Long,
        var statisticCode: String,
        var period: String,
        var queryStartDate: String,
        var queryEndDate: String,
        var option1: String,
        var option2: String,
        var option3: String
    )

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
