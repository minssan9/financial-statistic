package com.core.service;

import com.core.domain.EcosData;
import com.core.domain.EcosSchema;
import com.core.dto.KrBankRequest;
import org.springframework.stereotype.Service;

import java.util.List;

//@Slf4j
@Service
public
interface EcosService {
    List<EcosSchema> getSchema(KrBankRequest krBankRequest );
    List<EcosData> getData(KrBankRequest krBankRequest );
}
