package com.service.service;

import com.core.domain.KrBankData;
import com.core.domain.KrBankSchema;
import com.core.dto.KrBankRequest;
import org.springframework.stereotype.Service;

import java.util.List;

//@Slf4j
@Service
public
interface EcosService {
    List<KrBankSchema> getSchema(KrBankRequest krBankRequest );
    List<KrBankData> getData(KrBankRequest krBankRequest );
}
