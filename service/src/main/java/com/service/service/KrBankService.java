package com.service.service;

import com.service.domain.KrBankData;
import com.service.domain.KrBankSchema;
import com.service.dto.KrBankRequest;
import java.util.List;
import org.springframework.stereotype.Service;


//@Slf4j
@Service
public
interface KrBankService {
    List<KrBankSchema> getSchema(KrBankRequest krBankRequest );
    List<KrBankData> getData(KrBankRequest krBankRequest );
}
