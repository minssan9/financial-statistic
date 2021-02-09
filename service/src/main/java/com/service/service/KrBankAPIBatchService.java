package com.service.service;

import com.service.domain.KrBankData;
import com.service.domain.KrBankSchema;
import com.service.dto.KrBankRequest;
import com.service.repository.KrBankDataRepository;
import com.service.repository.KrBankSchemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KrBankAPIBatchService {
    @Autowired
    KrBankDataRepository krBankDataRepository;
    @Autowired
    KrBankSchemaRepository krBankSchemaRepository;
    @Autowired
    KrBankApiService krBankApiService;

    public void saveAllBySchema(String startDate, String endDate) {
        List<KrBankSchema> krBankSchemas = krBankSchemaRepository.findAll();
        krBankSchemas.forEach(i -> {
            KrBankRequest krBankRequest =new KrBankRequest(i);
            krBankRequest.setQueryStartDate( startDate);
            krBankRequest.setQueryEndDate( endDate);
            krBankApiService.batchData(krBankRequest);
        });
    }

    public List<KrBankData> batchKOSPI(String queryDate) {
        return krBankApiService.batchData(
                new KrBankRequest("064Y001", "0001000", "", "", queryDate, queryDate,"DD", 1L, 1000L)
        );
    }


    public List<KrBankData> batchKOSDAQ(String queryDate) {
        List<KrBankData> krBankDataList = krBankApiService.getDataFromAPI(
                new KrBankRequest("064Y001", "0001000", "", "", queryDate, queryDate, "DD", 1L, 1000L)
        );

        return krBankDataRepository.saveAll(krBankDataList);
    }
}
