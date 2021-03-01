package com.core.dto;

import com.core.domain.EcosSchema;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class KrBankRequest {
    String serviceName = "";
    String url = "http://ecos.bok.or.kr/api";


    String authKey = "ECOS_API_KEY";
    String requestType = "json";
    String language = "kr";
    String period = "";

    String statisticCode = "";
    String option1 = "";
    String option2 = "";
    String option3 = "";
    String queryStartDate = "";
    String queryEndDate = "";
    Long reqStartCount = 1L;
    Long reqEndCount = 1000L;


    public KrBankRequest(String statisticCode, String option1, String option2, String option3, String queryStartDate, String queryEndDate, String period, Long reqStartCount, Long reqEndCount) {
        this.statisticCode = statisticCode;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.queryStartDate = queryStartDate;
        this.queryEndDate = queryEndDate;
        this.reqStartCount = reqStartCount;
        this.reqEndCount = reqEndCount;
    }

    public KrBankRequest(EcosSchema ecosSchema) {
        this.statisticCode = ecosSchema.getPstatcode();
        this.option1 = ecosSchema.getStatcode();
        this.reqStartCount = 1L;
        this.reqEndCount = 1000L;
    }


}
