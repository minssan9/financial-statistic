package com.core.api;

import com.core.document.EcosMongoData;
import com.core.document.EcosMongoSchema;
import com.core.domain.EcosData;
import com.core.domain.EcosSchema;
import com.core.dto.KrBankDataResponse;
import com.core.dto.KrBankRequest;
import com.core.dto.KrBankSchemaResponse;
import com.core.mongorepo.EcosDataMongoRepo;
import com.core.mongorepo.EcosSchemaMongoRepo;
import com.core.properties.CoreProperties;
import com.core.repo.EcosDataRepo;
import com.core.repo.EcosSchemaRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Service
public class EcosApiServiceImpl implements EcosApiService {
    @Autowired    Gson gson;
    @Autowired    RestTemplate restTemplate;

    @Autowired    EcosDataMongoRepo ecosDataMongoRepo;
    @Autowired    EcosSchemaMongoRepo ecosSchemaMongoRepo;

    @Autowired
    EcosDataRepo ecosDataRepo;
    @Autowired
    EcosSchemaRepo ecosSchemaRepo;
    @Autowired
    CoreProperties coreProperties;

    @SpringBootApplication
    static class TestConfiguration {
    }
    public List<EcosData> retrieveData(KrBankRequest krBankRequest) {
        krBankRequest.setServiceName("StatisticSearch");
        krBankRequest.setPeriod("DD");

        ResponseEntity<String> response = restTemplate.getForEntity(getUrlString(krBankRequest), String.class);
        List<EcosData> ecosData = gson.fromJson(response.getBody(), KrBankDataResponse.class).getStatisticSearch().getRow();
        List<EcosMongoData> ecosMongoData = ecosData.stream().map(krBankData -> (EcosMongoData)krBankData).collect(Collectors.toList());

        ecosDataMongoRepo.saveAll(ecosMongoData);
        return ecosDataRepo.saveAll(ecosData);
    }

    public List<EcosSchema> retrieveSchema() {
        KrBankRequest krBankRequest = new KrBankRequest();
        krBankRequest.setServiceName("StatisticTableList");


        ResponseEntity<String> response = restTemplate.getForEntity(getUrlString(krBankRequest), String.class);
        List<EcosSchema> ecosSchemas = gson.fromJson(response.getBody(), KrBankSchemaResponse.class).getStatisticTableList().getKrBankSchema();

        List<EcosMongoSchema> ecosMongoSchemas = ecosSchemas.stream().map(krBankSchema ->
            new EcosMongoSchema(krBankSchema)
        ).collect(Collectors.toList());

        ecosSchemaMongoRepo.saveAll(ecosMongoSchemas);
        return ecosSchemaRepo.saveAll(ecosSchemas);
    }

    public List<EcosSchema> retrieveDataEachSchema(String startDate, String endDate) {
        List<EcosSchema> ecosSchemas = ecosSchemaRepo.findAll();
        ecosSchemas.stream().map(i -> {
            KrBankRequest krBankRequest = new KrBankRequest(i);
            krBankRequest.setQueryStartDate(startDate);
            krBankRequest.setQueryEndDate(endDate);
            return retrieveData(krBankRequest);
        });
        return ecosSchemas;
    }


    //    http://ecos.bok.or.kr/api/StatisticTableList/sample/xml/kr/1/10/
    //    http://ecos.bok.or.kr/api/StatisticSearch/sample/xml/kr/1/10/010Y002/MM/201101/201101/AAAA11/
    public URI getUrlString(KrBankRequest krBankRequest) {
        krBankRequest.setAuthKey(coreProperties.getEcosApiKey());
        String uriString = krBankRequest.getUrl() + "/{serviceName}/{authKey}/{requestType}/{language}/{reqStartCount}/{reqEndCount}" +
                "/{statisticCode}/{period}/{queryStartDate}/{queryEndDate}/{option1}";

//        WebClient.create().get()
//            .uri(uriBuilder ->
//                uriBuilder.path(uriString)
//                .build());

        return UriComponentsBuilder.fromUriString(uriString)
                .buildAndExpand(new ObjectMapper().convertValue(krBankRequest, Map.class))
                .toUri();
    }

}
