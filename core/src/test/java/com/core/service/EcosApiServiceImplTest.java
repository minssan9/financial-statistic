package com.core.service;

import com.core.api.EcosApiService;
import com.core.api.EcosApiServiceImpl;
import com.core.domain.KrBankData;
import com.core.dto.KrBankRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static com.core.config.StaticConfig.dateFormatString;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class EcosApiServiceImplTest {

    @Autowired
    EcosApiService ecosApiService;
    @Autowired
    EcosApiServiceImpl ecosApiServiceImpl;

    @Test
    void getKOSPI() {
        String queryDate = "20210210";
        List<KrBankData> krBankDatas = ecosApiService.batchData(
                new KrBankRequest("064Y001", "0001000", "", "", queryDate, queryDate, "DD", 1L, 1000L)
        );

        assertNotNull(krBankDatas);
    }

    @Test
    void batchKOSDAQ() {
        String queryDate = "20210210";
        List<KrBankData> krBankDatas = ecosApiService.batchData(
                new KrBankRequest("064Y001", "0001000", "", "", queryDate, queryDate, "DD", 1L, 1000L)
        );
        assertNotNull(krBankDatas);
    }

    @Test
    void saveAllBySchema() {
        String todayString = LocalDateTime.now().minusDays(2L).format(dateFormatString);
        ecosApiService.saveDataEachSchema(todayString, todayString);
        assertNotNull(ecosApiService.saveDataEachSchema(todayString, todayString));
    }

    @Test
    void batchSchema() {
        ecosApiServiceImpl.batchSchema();
    }
}
