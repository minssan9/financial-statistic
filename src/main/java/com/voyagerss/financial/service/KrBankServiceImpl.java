package com.voyagerss.financial.service;

import com.voyagerss.financial.config.KrBankProperties;
import com.voyagerss.financial.domain.KrBankData;
import com.voyagerss.financial.domain.KrBankSchema;
import com.voyagerss.financial.dto.KrBankRequest;
import com.voyagerss.financial.repository.KrBankDataRepository;
import com.voyagerss.financial.repository.KrBankSchemaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
