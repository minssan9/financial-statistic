package com.service.service;

import com.service.config.KrBankProperties;
import com.service.domain.KrBankData;
import com.service.domain.KrBankSchema;
import com.service.dto.KrBankRequest;
import com.service.repository.EcosDataRepo;
import com.service.repository.EcosSchemaRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

class KrBankServiceImpl implements KrBankService {
    @Autowired
    private KrBankProperties krBankProperties;

    @Autowired
    EcosDataRepo ecosDataRepo;

    @Autowired
    EcosSchemaRepo ecosSchemaRepo;

    @Override
    public List<KrBankSchema> getSchema(KrBankRequest krBankRequest) {
        return ecosSchemaRepo.findAll();
    }

    @Override
    public List<KrBankData> getData(KrBankRequest krBankRequest) {
        return ecosDataRepo.findAll();
    }
}
