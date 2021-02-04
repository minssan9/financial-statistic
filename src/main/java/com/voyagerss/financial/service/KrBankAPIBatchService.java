package com.voyagerss.financial.service;

import com.voyagerss.financial.domain.KrBankData;
import com.voyagerss.financial.domain.KrBankSchema;
import com.voyagerss.financial.dto.KrBankDataResponse;
import com.voyagerss.financial.dto.KrBankRequest;
import com.voyagerss.financial.repository.KrBankDataRepository;
import com.voyagerss.financial.repository.KrBankSchemaRepository;
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
