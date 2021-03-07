package com.core.api;

import com.core.document.EcosMongoData;
import com.core.document.EcosMongoSchema;
import com.core.domain.EcosData;
import com.core.domain.EcosSchema;
import com.core.domain.EcosSchemaDetail;
import com.core.dto.EcosResponse;
import com.core.dto.KrBankDataResponse;
import com.core.dto.KrBankRequest;
import com.core.mongorepo.EcosDataMongoRepo;
import com.core.mongorepo.EcosSchemaMongoRepo;
import com.core.properties.CoreProperties;
import com.core.repo.EcosDataRepo;
import com.core.repo.EcosSchemaDetailRepo;
import com.core.repo.EcosSchemaRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    EcosSchemaDetailRepo ecosSchemaDetailRepo;

    @Autowired
    CoreProperties coreProperties;

    public List<EcosData> retrieveData(KrBankRequest krBankRequest) {
        krBankRequest.setServiceName("StatisticSearch");
//        krBankRequest.setPeriod("DD");

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
        EcosResponse ecosResponse = gson.fromJson(response.getBody(), EcosResponse.class);
        List<EcosSchema> ecosSchemas = (List<EcosSchema>) gson.fromJson(ecosResponse.getStatisticTableList().getRow().toString(), EcosSchema.class);
        List<EcosMongoSchema> ecosMongoSchemas = ecosSchemas.stream().map(krBankSchema ->
            new EcosMongoSchema(krBankSchema)
        ).collect(Collectors.toList());

        ecosSchemaMongoRepo.saveAll(ecosMongoSchemas);
        return ecosSchemaRepo.saveAll(ecosSchemas);
    }

    @Override
    public List<EcosSchemaDetail> retrieveSchemaDetail(EcosSchema ecosSchema) {
        List<EcosSchema> ecosSchemas = ecosSchemaRepo.findBySearchFlag("Y");
        KrBankRequest krBankRequest = new KrBankRequest();
        krBankRequest.setServiceName("StatisticItemList");

        ResponseEntity<String> response = restTemplate.getForEntity(getUrlString(krBankRequest), String.class);
        EcosResponse ecosResponse = restTemplate.getForObject(getUrlString(krBankRequest), EcosResponse.class);
        List<EcosSchemaDetail> ecosSchemasDetails  = (List<EcosSchemaDetail>)gson.fromJson(ecosResponse.getStatisticTableList().getRow().toString(), EcosSchemaDetail.class);
//        List<EcosSchemaDetail> ecosSchemasDetails = gson.fromJson(response.getBody(), EcosResponse.class).getStatisticTableList().getRow();

//        List<EcosMongoSchema> ecosMongoSchemas = ecosSchemas.stream().map(krBankSchema ->
//            new EcosMongoSchema(krBankSchema)
//        ).collect(Collectors.toList());

//        ecosSchemaMongoRepo.saveAll(ecosMongoSchemas);
        return ecosSchemaDetailRepo.saveAll(ecosSchemasDetails);
    }



    @Transactional
    public List<EcosSchemaDetail> retrieveDataFromAllSchema(String startDate, String endDate) {
        List<EcosSchemaDetail> ecosSchemaDetails = ecosSchemaDetailRepo.findAll();

        ecosSchemaDetails.forEach(i-> {
            KrBankRequest krBankRequest = new KrBankRequest(i);
            krBankRequest.setQueryStartDate(startDate);
            krBankRequest.setQueryEndDate(endDate);
            retrieveData(krBankRequest);
        });
        return ecosSchemaDetails;
    }


    //    http://ecos.bok.or.kr/api/StatisticTableList/sample/xml/kr/1/10/
    //    http://ecos.bok.or.kr/api/StatisticSearch/sample/xml/kr/1/10/010Y002/MM/201101/201101/AAAA11/
    public URI getUrlString(KrBankRequest krBankRequest) {
        krBankRequest.setAuthKey(coreProperties.getEcosApiKey());
        String uriString = krBankRequest.getUrl() + "/{serviceName}/{authKey}/{requestType}/{language}/{reqStartCount}/{reqEndCount}" +
                "/{statisticCode}/{period}/{queryStartDate}/{queryEndDate}/{option1}";


        return UriComponentsBuilder.fromUriString(uriString)
                .buildAndExpand(new ObjectMapper().convertValue(krBankRequest, Map.class))
                .toUri();
    }


}
