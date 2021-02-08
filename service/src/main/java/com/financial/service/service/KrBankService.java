package com.voyagerss.financial.service;

import com.voyagerss.financial.domain.KrBankData;
import com.voyagerss.financial.domain.KrBankSchema;
import com.voyagerss.financial.dto.KrBankRequest;
import org.springframework.stereotype.Service;

import java.util.List;


//@Slf4j
@Service
interface KrBankService {
    List<KrBankSchema> getSchema(KrBankRequest krBankRequest );
    List<KrBankData> getData(KrBankRequest krBankRequest );
}
