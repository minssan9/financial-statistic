package com.service.service;

import com.service.config.KrBankProperties;
import com.service.domain.KrBankData;
import com.service.domain.KrBankSchema;
import com.service.dto.KrBankDataResponse;
import com.service.dto.KrBankRequest;
import com.service.dto.KrBankSchemaResponse;
import com.service.repository.KrBankDataRepository;
import com.service.repository.KrBankSchemaRepository;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Slf4j
@Service
@ConfigurationProperties("account")
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

        ResponseEntity<String> response = restTemplate.getForEntity(getUrlString(krBankRequest), String.class);
        KrBankDataResponse krBankDataResponse = gson.fromJson(response.getBody(), KrBankDataResponse.class);

        List<KrBankData> krBankDatas = gson.fromJson(
                restTemplate.getForEntity(getUrlString(krBankRequest), String.class).getBody(),
                KrBankDataResponse.class
        ).getStatisticSearch().getRow();
        return krBankDatas;
    }

    public List<KrBankData> batchData(KrBankRequest krBankRequest) {
        return saveData(getDataFromAPI(krBankRequest));
    }


    public List<KrBankSchema> getSchemaFromAPI(KrBankRequest krBankRequest) {
        List<KrBankSchemaResponse> krBankSchemaResponses = new ArrayList<>();
        krBankRequest.setServiceName("StatisticTableList");

        ResponseEntity response = restTemplate.getForObject(getUrlString(krBankRequest), ResponseEntity.class);
        KrBankSchemaResponse krBankSchemaResponse = gson.fromJson(response.getBody().toString(), KrBankSchemaResponse.class);
        return krBankSchemaResponse.getKrBankSchemaResult().getKrBankSchema();
    }


    //    http://ecos.bok.or.kr/api/StatisticTableList/sample/xml/kr/1/10/
    public String getUrlString(KrBankRequest krBankRequest) {

        return krBankRequest.getUrl() + "/" +
                krBankRequest.getServiceName() + "/" +
                krBankProperties.getApikey() + "/" +
                krBankRequest.getRequestType() + "/" +
                krBankRequest.getLanguage() + "/" +
                krBankRequest.getReqStartCount() + "/" + krBankRequest.getReqEndCount() + "/" +
                krBankRequest.getStatisticCode() + "/" +
                krBankRequest.getPeriod() + "/" +
                krBankRequest.getQueryStartDate() + "/" + krBankRequest.getQueryEndDate() + "/" +
                krBankRequest.getOption1() + "/";
    }
}
