package com.core.api;

import com.core.domain.EcosData;
import com.core.domain.EcosSchema;
import com.core.domain.EcosSchemaDetail;
import com.core.dto.KrBankRequest;
import java.net.URI;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface EcosApiService {
    URI getUrlString(KrBankRequest krBankRequest);

    List<EcosData> retrieveData(KrBankRequest krBankRequest) ;
    List<EcosSchema> retrieveSchema();
    List<EcosSchemaDetail> retrieveSchemaDetail(EcosSchema ecosSchema);
    //    http://ecos.bok.or.kr/api/StatisticTableList/sample/xml/kr/1/10/
    //    http://ecos.bok.or.kr/api/StatisticSearch/sample/xml/kr/1/10/010Y002/MM/201101/201101/AAAA11/
    List<EcosSchemaDetail> retrieveDataFromAllSchema(String startDate, String endDate);
}
