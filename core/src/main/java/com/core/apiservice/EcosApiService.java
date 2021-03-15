package com.core.apiservice;

import com.core.domain.EcosData;
import com.core.domain.EcosSchema;
import com.core.dto.EcosDto;
import com.google.gson.JsonObject;
import java.util.List;
import javafx.print.PrinterJob.JobStatus;
import org.springframework.stereotype.Service;

@Service
public interface EcosApiService<T> {
//    URI getUrlString(EcosDto ecosDto);
    JsonObject getAPIData( EcosDto ecosDto);
    List<EcosData> saveData(EcosDto ecosDto) ;
    List<EcosSchema> retrieveSchema();
    JobStatus retrieveSchemaDetail();
    List<EcosData> retrieveData(EcosDto ecosDto);
}
