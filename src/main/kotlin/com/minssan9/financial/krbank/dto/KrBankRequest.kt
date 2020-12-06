package com.minssan9.financial.krbank.dto

import lombok.Builder
import lombok.Data
import lombok.RequiredArgsConstructor

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
    ) {
        val url: String = "http://ecos.bok.or.kr/api"
        val serviceName: String = "StatisticSearch"
        val requestType: String = "json"
        val language: String = "kr"
        val reqStartCount: Long = 1
        val reqEndCount: Long = 1000
        val period: String = "DD"

        fun getUrlString(krBankRequest: KrBankRequest): String {
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
    }
