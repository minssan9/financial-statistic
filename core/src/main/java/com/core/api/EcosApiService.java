package com.core.api;

import com.core.domain.EcosData;
import com.core.domain.EcosSchema;
import com.core.dto.KrBankRequest;
import org.springframework.stereotype.*;

import java.net.URI;
import java.util.List;

@Service
public interface EcosApiService {
    URI getUrlString(KrBankRequest krBankRequest);

    List<EcosData> retrieveData(KrBankRequest krBankRequest) ;
    List<EcosSchema> retrieveSchema();
    //    http://ecos.bok.or.kr/api/StatisticTableList/sample/xml/kr/1/10/
    //    http://ecos.bok.or.kr/api/StatisticSearch/sample/xml/kr/1/10/010Y002/MM/201101/201101/AAAA11/
    List<EcosSchema> retrieveDataEachSchema(String startDate, String endDate);
}
