package com.financial.service.service;

import com.financial.service.config.KrBankProperties;
import com.financial.service.domain.KrBankData;
import com.financial.service.domain.KrBankSchema;
import com.financial.service.dto.KrBankRequest;
import com.financial.service.repository.KrBankDataRepository;
import com.financial.service.repository.KrBankSchemaRepository;
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
