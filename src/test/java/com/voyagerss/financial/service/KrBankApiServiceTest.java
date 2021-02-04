package com.voyagerss.financial.service;

import com.voyagerss.financial.domain.KrBankData;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
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
