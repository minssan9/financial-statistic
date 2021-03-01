package com.core.service;


import com.core.domain.EcosData;
import com.core.domain.EcosSchema;
import com.core.dto.KrBankRequest;
import com.core.mongorepo.EcosDataMongoRepo;
import com.core.mongorepo.EcosSchemaMongoRepo;
import com.core.repo.EcosDataRepo;
import com.core.repo.EcosSchemaRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
class EcosServiceImpl implements EcosService {
//    @Autowired
//    private AppProperties appProperties;

    @Autowired EcosDataRepo ecosDataRepo;
    @Autowired EcosDataMongoRepo ecosDataMongoRepo;
    @Autowired EcosSchemaRepo ecosSchemaRepo;
    @Autowired EcosSchemaMongoRepo ecosSchemaMongoRepo;

    @Override
    public List<EcosSchema> getSchema(KrBankRequest krBankRequest) {
//        return ecosSchemaMongoRepo.findAll();
        return ecosSchemaRepo.findAll();
    }

    @Override
    public List<EcosData> getData(KrBankRequest krBankRequest) {
//        return ecosDataMongoRepo.findAll();
        return ecosDataRepo.findAll();
    }
}
