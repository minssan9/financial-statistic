package com.core.apiservice;

import static com.core.config.properties.CoreProperties.DATE_STRING_FORMAT;
import static org.junit.Assert.assertNotNull;

import com.core.domain.EcosSchemaDetail;
import com.core.dto.EcosDto;
import java.time.LocalDateTime;
import java.util.List;
import javafx.print.PrinterJob.JobStatus;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

@Profile("core")
@SpringBootTest
@RunWith(SpringRunner.class)
class EcosApiServiceImplRESTTest {

    @Autowired
    EcosApiService ecosApiService;

    @Test
    void retrieveData() {

    }

    @Test
    void retrieveSchema() {
    }


    @Test
    void getUrlString() {
    }

    @Test
    void testRetrieveSchema() {
    }

    @Test
    void retrieveSchemaDetail() {
        JobStatus jobStatus =  ecosApiService.retrieveSchemaDetail();
        assertNotNull(jobStatus);
    }

    @Test
    void retrieveSchemaDetailByEachSchema() {
        String nowDate = LocalDateTime.now().format(DATE_STRING_FORMAT);
        EcosDto ecosDto = new EcosDto();
        ecosDto.setQueryStartDate(nowDate);
        ecosDto.setQueryEndDate(nowDate);

        List<EcosSchemaDetail> ecosSchemasDetails =  ecosApiService.retrieveDataFromAllSchema( ecosDto);
        assertNotNull(ecosSchemasDetails);
    }

    @Test
    void testRetrieveDataEachSchema() {
    }
}
