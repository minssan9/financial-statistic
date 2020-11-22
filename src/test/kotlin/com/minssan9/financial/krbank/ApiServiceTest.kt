package com.minssan9.financial.krbank

import com.minssan9.financial.dateFormatString
import com.minssan9.financial.krbank.Dto.ApiRequest
import com.minssan9.financial.krbank.Dto.ApiResults
import com.minssan9.financial.krbank.Service.ApiService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureMockRestServiceServer
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.core.io.ClassPathResource
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.client.MockRestServiceServer
import org.springframework.test.web.client.match.MockRestRequestMatchers.method
import org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo
import org.springframework.test.web.client.response.MockRestResponseCreators.withStatus
import java.time.LocalDateTime

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApiServiceTest(@Autowired val restTemplate: TestRestTemplate){

    @InjectMocks
    private lateinit var apiService: ApiService

    @Test
    fun krBankApiTest() {

        //give
        val path = "/apiResult.json"

        var startDate =
                LocalDateTime.of(2020, 1, 1, 0, 0)
                        .format(dateFormatString)
        var endDate = LocalDateTime.now().format(dateFormatString)

        var apiRequest: ApiRequest = ApiRequest(1, 10,"064Y001", "DD",
                startDate, endDate, "0001000", "","")

        var testResult = restTemplate.getForEntity<String>("http://ecos.bok.or.kr/api/StatisticSearch/sample/json/kr/1/10/010Y002/MM/201101/201106/AAAA11/")


        val apiResults: ApiResults = apiService.getKOSPI(startDate, endDate)
        apiResults.row.forEach {i -> println(i)}
        assertThat(apiResults.row).isNotEmpty

        //then
        // (8)

    }
}
