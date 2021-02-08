package com.financial.service.service;

import com.financial.service.domain.KrBankData;
import com.financial.service.domain.KrBankSchema;
import com.financial.service.dto.KrBankRequest;
import java.util.List;
import org.springframework.stereotype.Service;


//@Slf4j
@Service
interface KrBankService {
    List<KrBankSchema> getSchema(KrBankRequest krBankRequest );
    List<KrBankData> getData(KrBankRequest krBankRequest );
}
