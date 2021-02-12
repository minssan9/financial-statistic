package com.service.service;

import com.service.config.KrBankProperties;
import com.service.domain.KrBankData;
import com.service.domain.KrBankSchema;
import com.service.dto.KrBankRequest;
import com.service.repository.KrBankDataRepository;
import com.service.repository.KrBankSchemaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

class KrBankServiceImpl implements KrBankService {
    @Autowired
    private KrBankProperties krBankProperties;

    @Autowired
    KrBankDataRepository krBankDataRepository;

    @Autowired
    KrBankSchemaRepository krBankSchemaRepository;

    @Override
    public List<KrBankSchema> getSchema(KrBankRequest krBankRequest) {
        return krBankSchemaRepository.findAll();
    }

    @Override
    public List<KrBankData> getData(KrBankRequest krBankRequest) {
        return krBankDataRepository.findAll();
    }
}
