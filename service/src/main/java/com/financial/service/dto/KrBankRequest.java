package com.voyagerss.financial.dto;

import com.voyagerss.financial.domain.KrBankSchema;
import lombok.Data;

@Data
public
class KrBankRequest {

     String serviceName="";
     String url = "http://ecos.bok.or.kr/api";


     String authKey;
     String requestType = "json";
     String language = "kr";
     String period = "DD";

     String statisticCode;


     String option1;
     String option2;
     String option3;
     String queryStartDate;
     String queryEndDate;
     Long reqStartCount;
     Long reqEndCount;


     public KrBankRequest(String statisticCode, String option1, String option2, String option3, String queryStartDate, String queryEndDate, Long reqStartCount, Long reqEndCount) {

          this.statisticCode = statisticCode;
          this.option1 = option1;
          this.option2 = option2;
          this.option3 = option3;
          this.queryStartDate = queryStartDate;
          this.queryEndDate = queryEndDate;
          this.reqStartCount = reqStartCount;
          this.reqEndCount = reqEndCount;
     }

     public KrBankRequest(KrBankSchema krBankSchema){
           this.statisticCode =       krBankSchema.getPstatcode();
           this.option1 =       krBankSchema.getStatcode();
          this.reqStartCount = 1L;
          this.reqEndCount = 1000L;
     }
}
