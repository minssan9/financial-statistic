package com.service.service;

import com.service.domain.KrBankData;
import com.service.domain.KrBankSchema;
import com.service.dto.KrBankRequest;
import com.service.repository.KrBankDataRepository;
import com.service.repository.KrBankSchemaRepository;
import com.service.service.KrBankApiService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KrBankAPIBatchService {
    @Autowired
    KrBankDataRepository krBankDataRepository;
    @Autowired
    KrBankSchemaRepository krBankSchemaRepository;
    @Autowired
    KrBankApiService krBankApiService;

    void dailySave() {
        List<KrBankSchema> krBankSchemas = krBankSchemaRepository.findAll();
        krBankSchemas.forEach(i -> {
            krBankApiService.batchData(new KrBankRequest(i));
        });
    }

    public List<KrBankData> batchKOSPI(String queryDate) {
        return krBankApiService.batchData(
                new KrBankRequest("064Y001", "0001000", "", "", queryDate, queryDate, 1L, 1000L)
        );
    }


    public List<KrBankData> batchKOSDAQ(String queryDate) {
        List<KrBankData> krBankDataList = krBankApiService.getDataFromAPI(
                new KrBankRequest("064Y001", "0001000", "", "", queryDate, queryDate, 1L, 1000L)
        );

        return krBankDataRepository.saveAll(krBankDataList);
    }
}
