package com.core.dto;

import com.core.domain.EcosSchemaDetail;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class KrBankRequest {
    private String serviceName = "";
    private String url = "http://ecos.bok.or.kr/api";
    private String authKey = "ECOS_API_KEY";
    private String requestType = "json";
    private String language = "kr";
    private String queryStartDate = "";
    private String queryEndDate = "";
    private Long reqStartCount = 1L;
    private Long reqEndCount = 1000L;
    private String period = "";
    private String statisticCode = "";
    private String option1 = "";
    private String option2 = "";
    private String option3 = "";

    private EcosSchemaDetail ecosSchemaDetail;

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

    public KrBankRequest(EcosSchemaDetail ecosSchemaDetail) {
        this.statisticCode = ecosSchemaDetail.getStatcode();
        this.option1 = ecosSchemaDetail.getStatcode();
        this.reqStartCount = 1L;
        this.reqEndCount = 1000L;
    }


}
