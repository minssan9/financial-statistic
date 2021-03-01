package com.core.service;

import static com.core.config.StaticConfig.DATE_STRING_FORMAT;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.core.api.EcosApiService;
import com.core.api.EcosApiServiceImpl;
import com.core.domain.EcosData;
import com.core.dto.KrBankRequest;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EcosApiServiceImplTest {

    @Autowired
    EcosApiService ecosApiService;
    @Autowired
    EcosApiServiceImpl ecosApiServiceImpl;

    @Test
    void getKOSPI() {
        String queryDate = "20210210";
        List<EcosData> ecosData = ecosApiService.retrieveData(
                new KrBankRequest("064Y001", "0001000", "", "", queryDate, queryDate, "DD", 1L, 1000L)
        );

        assertNotNull(ecosData);
    }

    @Test
    void batchKOSDAQ() {
        String queryDate = "20210210";
        List<EcosData> ecosData = ecosApiService.retrieveData(
                new KrBankRequest("064Y001", "0001000", "", "", queryDate, queryDate, "DD", 1L, 1000L)
        );
        assertNotNull(ecosData);
    }

    @Test
    void saveAllBySchema() {
        String todayString = LocalDateTime.now().minusDays(2L).format(DATE_STRING_FORMAT);
        ecosApiService.retrieveDataEachSchema(todayString, todayString);
        assertNotNull(ecosApiService.retrieveDataEachSchema(todayString, todayString));
    }

    @Test
    void batchSchema() {
        ecosApiServiceImpl.retrieveSchema();
    }
}
