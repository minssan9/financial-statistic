package com.core.apiservice;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.core.config.properties.CoreProperties;
import com.core.domain.EcosSchema;
import java.util.List;
import javafx.print.PrinterJob.JobStatus;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class EcosApiServiceImplWebClientTest {

    @Autowired
    CoreProperties coreProperties;
    @Autowired
    EcosApiService ecosApiServiceImplWebClient;

    @Test
    void retrieveSchema() {
        List<EcosSchema> list = ecosApiServiceImplWebClient.retrieveSchema();
        assertNotNull(list);
    }

    @Test
    void retrieveSchemaDetail() {
        JobStatus jobStatus = ecosApiServiceImplWebClient.retrieveSchemaDetail();
        assertNotNull(jobStatus);
    }

    @Test
    void retrieveDataFromAllSchema() {
    }


}
