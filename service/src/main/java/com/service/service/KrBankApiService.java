package com.service.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.service.config.KrBankProperties;
import com.service.domain.KrBankData;
import com.service.domain.KrBankSchema;
import com.service.dto.KrBankDataResponse;
import com.service.dto.KrBankRequest;
import com.service.dto.KrBankSchemaResponse;
import com.service.repository.KrBankDataRepository;
import com.service.repository.KrBankSchemaRepository;
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
public class KrBankApiService {
    @Autowired
    Gson gson;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    KrBankProperties krBankProperties;

    @Autowired
    KrBankDataRepository krBankDataRepository;

    @Autowired
    KrBankSchemaRepository krBankSchemaRepository;

    List<KrBankData> saveData(List<KrBankData> krBankDatas) {
        krBankDatas.forEach(i -> krBankDataRepository.save(i));
        return krBankDatas;
    }

    List<KrBankSchema> saveSchema(List<KrBankSchema> krBankSchemas) {
        krBankSchemas.forEach(i -> krBankSchemaRepository.save(i));
        return krBankSchemas;
    }

    public List<KrBankData> getDataFromAPI(KrBankRequest krBankRequest) {
        krBankRequest.setServiceName("StatisticSearch");
        krBankRequest.setAuthKey(krBankProperties.getApikey());
        krBankRequest.setPeriod("DD");
//        ResponseEntity<String> response = restTemplate.getForEntity(krBankRequest.getUrlString(), String.class);
//        KrBankDataResponse krBankDataResponse = gson.fromJson(response.getBody(), KrBankDataResponse.class);

        List<KrBankData> krBankDatas = gson.fromJson(
                restTemplate.getForEntity(getUrlString(krBankRequest), String.class).getBody(),
                KrBankDataResponse.class
        ).getStatisticSearch().getRow();
        return krBankDatas;
    }

    public List<KrBankSchema> getSchemaFromAPI() {
        KrBankRequest krBankRequest = new KrBankRequest();
        krBankRequest.setServiceName("StatisticTableList");
        krBankRequest.setAuthKey(krBankProperties.getApikey());

        ResponseEntity<String> response = restTemplate.getForEntity(getUrlString(krBankRequest), String.class);
        KrBankSchemaResponse krBankSchemaResponse = gson.fromJson(response.getBody(), KrBankSchemaResponse.class);
        return krBankSchemaResponse.getStatisticTableList().getKrBankSchema();
    }

    public List<KrBankData> batchData(KrBankRequest krBankRequest) {
        return saveData(getDataFromAPI(krBankRequest));
    }

    public List<KrBankSchema> batchSchema() {
        return saveSchema(getSchemaFromAPI());
    }


    //    http://ecos.bok.or.kr/api/StatisticTableList/sample/xml/kr/1/10/
    //    http://ecos.bok.or.kr/api/StatisticSearch/sample/xml/kr/1/10/010Y002/MM/201101/201101/AAAA11/
    public URI getUrlString(KrBankRequest krBankRequest) {
        String retString = krBankRequest.getUrl() + "/{serviceName}/{authKey}/{requestType}/{language}/{reqStartCount}/{reqEndCount}" +
                "/{statisticCode}/{period}/{queryStartDate}/{queryEndDate}";

//        Map<String, Object> params = new HashMap<String, Object>();

        ObjectMapper objectMapper = new ObjectMapper();
        Map result = objectMapper.convertValue(krBankRequest, Map.class);


        return UriComponentsBuilder.fromUriString(retString)
                .buildAndExpand(result)
                .toUri();

//        params.put("authKey", this.authKey);
//        params.put("requestType", this.requestType);
//        params.put("language", this.language);
//        params.put("statisticCode", this.statisticCode);
//        params.put("option1", this.option1);
//        params.put("option2", this.option2);
//        params.put("option3", this.option3);
//        params.put("queryStartDate", this.queryStartDate);
//        params.put("queryEndDate", this.queryEndDate);
//        params.put("reqStartCount", this.reqStartCount);
//        params.put("reqEndCount", this.reqEndCount);
//        params.put("period", this.period);

//        return retString;
    }

}
