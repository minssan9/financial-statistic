package com.core.apiservice;

import com.core.domain.EcosData;
import com.core.domain.EcosSchema;
import com.core.domain.EcosSchemaDetail;
import com.core.dto.EcosDto;
import com.google.gson.JsonObject;
import java.net.URI;
import java.util.List;
import javafx.print.PrinterJob.JobStatus;
import org.springframework.stereotype.Service;

@Service
public interface EcosApiService<T> {
    URI getUrlString(EcosDto ecosDto);
    JsonObject getAPIData( EcosDto ecosDto);
    List<EcosData> saveData(EcosDto ecosDto) ;
    List<EcosSchema> retrieveSchema();
    JobStatus retrieveSchemaDetail();
    //    http://ecos.bok.or.kr/api/StatisticTableList/sample/xml/kr/1/10/
    //    http://ecos.bok.or.kr/api/StatisticSearch/sample/xml/kr/1/10/010Y002/MM/201101/201101/AAAA11/
    List<EcosSchemaDetail> retrieveDataFromAllSchema(EcosDto ecosDto);
}
