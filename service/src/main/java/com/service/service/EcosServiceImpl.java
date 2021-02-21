package com.service.service;


import com.core.domain.KrBankData;
import com.core.domain.KrBankSchema;
import com.core.dto.KrBankRequest;
import com.core.repo.EcosDataRepo;
import com.core.repo.EcosSchemaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
class EcosServiceImpl implements EcosService {
//    @Autowired
//    private AppProperties appProperties;

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
