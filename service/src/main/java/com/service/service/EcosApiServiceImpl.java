package com.service.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.config.KrBankProperties;
import com.service.domain.KrBankData;
import com.service.domain.KrBankSchema;
import com.service.dto.KrBankDataResponse;
import com.service.dto.KrBankRequest;
import com.service.dto.KrBankSchemaResponse;
import com.service.repository.EcosDataRepo;
import com.service.repository.EcosSchemaRepo;
import com.google.gson.Gson;

import java.net.URI;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Slf4j
@Service
public class EcosApiServiceImpl implements EcosApiService {
    @Autowired
    Gson gson;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    KrBankProperties krBankProperties;

    @Autowired
    EcosDataRepo ecosDataRepo;
    @Autowired
    EcosSchemaRepo ecosSchemaRepo;

    public List<KrBankData> batchData(KrBankRequest krBankRequest) {
        return ecosDataRepo.saveAll(getDataFromAPI(krBankRequest));
    }

    public List<KrBankSchema> batchSchema() {
        return ecosSchemaRepo.saveAll(getSchemaFromAPI());
    }

    public List<KrBankSchema> saveDataEachSchema(String startDate, String endDate) {
        List<KrBankSchema> krBankSchemas = ecosSchemaRepo.findAll();
        krBankSchemas.forEach(i -> {
            KrBankRequest krBankRequest = new KrBankRequest(i);
            krBankRequest.setQueryStartDate(startDate);
            krBankRequest.setQueryEndDate(endDate);
            batchData(krBankRequest);
        });
        return krBankSchemas;
    }


    //    http://ecos.bok.or.kr/api/StatisticTableList/sample/xml/kr/1/10/
    //    http://ecos.bok.or.kr/api/StatisticSearch/sample/xml/kr/1/10/010Y002/MM/201101/201101/AAAA11/
    public URI getUrlString(KrBankRequest krBankRequest) {
        String uriString = krBankRequest.getUrl() + "/{serviceName}/{authKey}/{requestType}/{language}/{reqStartCount}/{reqEndCount}" +
                "/{statisticCode}/{period}/{queryStartDate}/{queryEndDate}";
//        Map<String, Object> params = new HashMap<String, Object>();

//        ObjectMapper objectMapper = new ObjectMapper();
//        Map result = new ObjectMapper().convertValue(krBankRequest, Map.class);
        return UriComponentsBuilder.fromUriString(uriString)
                .buildAndExpand(new ObjectMapper().convertValue(krBankRequest, Map.class))
                .toUri();
    }

    public List<KrBankData> getDataFromAPI(KrBankRequest krBankRequest) {
        krBankRequest.setServiceName("StatisticSearch");
        krBankRequest.setAuthKey(krBankProperties.getApikey());
        krBankRequest.setPeriod("DD");

        ResponseEntity<String> response = restTemplate.getForEntity(getUrlString(krBankRequest), String.class);
//        KrBankDataResponse krBankDataResponse = gson.fromJson(response.getBody(), KrBankDataResponse.class);

        return gson.fromJson(response.getBody(), KrBankDataResponse.class).getStatisticSearch().getRow();
    }

    public List<KrBankSchema> getSchemaFromAPI() {
        KrBankRequest krBankRequest = KrBankRequest.builder()
                .serviceName("StatisticTableList")
                .authKey(krBankProperties.getApikey())
                .build();

        ResponseEntity<String> response = restTemplate.getForEntity(getUrlString(krBankRequest), String.class);
        KrBankSchemaResponse krBankSchemaResponse = gson.fromJson(response.getBody(), KrBankSchemaResponse.class);
        return krBankSchemaResponse.getStatisticTableList().getKrBankSchema();
    }
}
