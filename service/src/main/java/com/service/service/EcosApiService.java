package com.service.service;

import com.service.domain.KrBankData;
import com.service.domain.KrBankSchema;
import com.service.dto.KrBankRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EcosAPIBatch {
    List<KrBankSchema> saveAllBySchema(String startDate, String endDate);

    List<KrBankData> batchKOSPI(String queryDate);

    List<KrBankData> batchKOSDAQ(String queryDate);
}
