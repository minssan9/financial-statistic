package com.core.api;

import static com.core.config.StaticConfig.DATE_STRING_FORMAT;
import static org.junit.Assert.assertNotNull;

import com.core.domain.EcosSchema;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

@Profile("core")
@SpringBootTest
@RunWith(SpringRunner.class)
class EcosApiServiceImplTest {

    @Autowired
    EcosApiService ecosApiService;

    @Test
    void retrieveData() {

    }

    @Test
    void retrieveSchema() {
    }

    @Test
    void retrieveDataEachSchema() {
        String nowDate = LocalDateTime.now().format(DATE_STRING_FORMAT);
        List<EcosSchema> ecosSchemas =  ecosApiService.retrieveDataEachSchema(nowDate, nowDate);
        assertNotNull(ecosSchemas);
    }

    @Test
    void getUrlString() {
    }
}
