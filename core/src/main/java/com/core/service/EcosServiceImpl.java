package com.core.service;


import com.core.domain.EcosData;
import com.core.domain.EcosSchema;
import com.core.dto.EcosDto;
import com.core.repo.EcosDataRepo;
import com.core.repo.EcosDataRepositorySupport;
import com.core.repo.EcosSchemaDetailRepo;
import com.core.repo.EcosSchemaRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
class EcosServiceImpl implements EcosService {
    @Autowired EcosDataRepo ecosDataRepo;
    @Autowired EcosSchemaRepo ecosSchemaRepo;
    @Autowired EcosDataRepositorySupport ecosDataRepositorySupport;
    @Autowired EcosSchemaDetailRepo ecosSchemaDetailRepo;

//    @Autowired EcosDataMongoRepo ecosDataMongoRepo;
//    @Autowired EcosSchemaMongoRepo ecosSchemaMongoRepo;

    @Override
    public List<EcosSchema> getSchema(EcosDto ecosDto) {
//        return ecosSchemaMongoRepo.findAll();
//        ecosDataRepositorySupport.findDynamicQuery()
        return ecosSchemaRepo.findAll();
    }

    @Override
    public List<EcosData> getData(EcosDto ecosDto) {
//        return ecosDataMongoRepo.findAll();
        return ecosDataRepo.findAll();
    }
}
