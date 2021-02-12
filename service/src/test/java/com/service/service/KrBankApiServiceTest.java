package com.service.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.service.domain.KrBankData;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class KrBankApiServiceTest {

    @Autowired
    KrBankAPIBatchService krBankAPIBatchService;

    @Test
    void saveData() {
    }

    @Test
    void saveSchema() {
    }

    @Test
    void getDataFromAPI() {
    }

    @Test
    void getSchemaFromAPI() {
    }

    @Test
    void getKOSPI() {
        List<KrBankData> krBankDatas =krBankAPIBatchService.batchKOSPI("20210108");
        assertNotNull(krBankDatas);
    }

    @Test
    void getUrlString() {
    }

    @Test
    void testSaveData() {
    }

    @Test
    void testSaveSchema() {
    }

    @Test
    void testGetDataFromAPI() {
    }

    @Test
    void testGetSchemaFromAPI() {
    }

    @Test
    void testGetKOSPI() {
    }

    @Test
    void testGetUrlString() {
    }
}
