package com.core.api;

import static org.junit.Assert.assertNotNull;

import com.core.domain.EcosData;
import com.core.dto.KrBankRequest;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EcosApiServiceImplTest {

    @Autowired
    EcosApiService ecosApiService;

    @SpringBootApplication
    static class TestConfiguration {
    }
    @Test
    void retrieveData() {
        KrBankRequest krBankRequest=new KrBankRequest();

        List<EcosData> ecosDatas =  ecosApiService.retrieveData(krBankRequest);
        assertNotNull(ecosDatas);

    }

    @Test
    void retrieveSchema() {
    }

    @Test
    void retrieveDataEachSchema() {
    }

    @Test
    void getUrlString() {
    }
}
