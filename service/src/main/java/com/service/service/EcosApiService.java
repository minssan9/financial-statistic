package com.service.service;

import com.service.domain.KrBankData;
import com.service.domain.KrBankSchema;
import com.service.dto.KrBankRequest;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;

@Service
public interface EcosApiService {
//    List<KrBankData> getDataFromAPI(KrBankRequest krBankRequest)  ;
//    List<KrBankSchema> getSchemaFromAPI() ;

    List<KrBankData> batchData(KrBankRequest krBankRequest) ;
    List<KrBankSchema> batchSchema();
    //    http://ecos.bok.or.kr/api/StatisticTableList/sample/xml/kr/1/10/
    //    http://ecos.bok.or.kr/api/StatisticSearch/sample/xml/kr/1/10/010Y002/MM/201101/201101/AAAA11/
    URI getUrlString(KrBankRequest krBankRequest);

    List<KrBankSchema> saveDataEachSchema(String startDate, String endDate);

}
