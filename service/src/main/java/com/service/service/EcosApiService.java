package com.service.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.domain.KrBankData;
import com.service.domain.KrBankSchema;
import com.service.dto.KrBankDataResponse;
import com.service.dto.KrBankRequest;
import com.service.dto.KrBankSchemaResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

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
