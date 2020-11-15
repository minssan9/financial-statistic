package com.minssan9.financial.krbank.Domain

import lombok.Data
import org.springframework.beans.factory.annotation.Value
import javax.persistence.Entity

@Value("\${korean_bank_key}")
lateinit var krBankKey: String

@Data
class ApiRequest(reqStartCount: Long, reqEndCount: Long, statisticCode: String, period: String,
                 queryStartDate: String , queryEndDate: String, option1 : String, option2 : String, option3 : String ) {
    var url: String = "http://ecos.bok.or.kr/api";
    var serviceName: String = "StatisticSearch";
    var authKey: String = krBankKey;
    var requestType: String = "json";
    var language: String = "kr";
    var reqStartCount: Long = reqStartCount;
    var reqEndCount: Long = reqEndCount;
    var statisticCode: String = statisticCode;
    var period: String = period;
    var queryStartDate: String = queryStartDate;
    var queryEndDate: String = queryEndDate;
    var option1: String? = option1;
    var option2: String? = option2;
    var option3: String? = option3;
}