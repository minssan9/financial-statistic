package com.voyagerss.financial.service;

import com.google.gson.Gson;
import com.voyagerss.financial.config.KrBankProperties;
import com.voyagerss.financial.domain.KrBankData;
import com.voyagerss.financial.domain.KrBankSchema;
import com.voyagerss.financial.dto.KrBankDataResponse;
import com.voyagerss.financial.dto.KrBankRequest;
import com.voyagerss.financial.dto.KrBankSchemaResponse;
import com.voyagerss.financial.dto.StatisticSearch;
import com.voyagerss.financial.repository.KrBankDataRepository;
import com.voyagerss.financial.repository.KrBankSchemaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


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

    List<KrBankData> getDataFromAPI(KrBankRequest krBankRequest) {
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
