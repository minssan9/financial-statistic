package com.core.api;

import com.core.domain.KrBankData;
import com.core.domain.KrBankSchema;
import com.core.dto.KrBankRequest;
import org.springframework.stereotype.*;

import java.net.URI;
import java.util.List;

@Service
public interface EcosApiService {
    List<KrBankData> batchData(KrBankRequest krBankRequest) ;
    List<KrBankSchema> batchSchema();
    //    http://ecos.bok.or.kr/api/StatisticTableList/sample/xml/kr/1/10/
    //    http://ecos.bok.or.kr/api/StatisticSearch/sample/xml/kr/1/10/010Y002/MM/201101/201101/AAAA11/
    URI getUrlString(KrBankRequest krBankRequest);

    List<KrBankSchema> saveDataEachSchema(String startDate, String endDate);
}
