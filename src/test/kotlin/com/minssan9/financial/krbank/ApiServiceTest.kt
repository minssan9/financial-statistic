package com.minssan9.financial.krbank

import com.minssan9.financial.dateFormatString
import com.minssan9.financial.krbank.Dto.ApiResults
import com.minssan9.financial.krbank.Service.ApiService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.context.annotation.PropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.LocalDateTime

@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@PropertySource("classpath:account.properties")
class ApiServiceTest(@Autowired val restTemplate: TestRestTemplate){

    @Value("\${account.krbankkey}")
    val krBankKey : String = ""

    @InjectMocks
    private lateinit var apiService: ApiService

    @Test
    fun krBankApiTest() {

        //given
        val path = "/apiResult.json"

        var startDate =
                LocalDateTime.of(2020, 1, 1, 0, 0)
                        .format(dateFormatString)
        var endDate = LocalDateTime.now().format(dateFormatString)


//        var testResult = restTemplate.getForEntity<String>("http://ecos.bok.or.kr/api/StatisticSearch/sample/json/kr/1/10/010Y002/MM/201101/201106/AAAA11/")
        var testResult = restTemplate.getForEntity<ApiResults>(apiService.getKOSPIUrl(startDate, endDate)).body

//        val apiResults : ApiResults? = restTemplate.getForEntity<ApiResults>(apiService.getKOSPIUrl(startDate, endDate)).body
//        apiResults?.row?.forEach { i -> println(i)}
//        assertThat(apiResults?.row).isNotEmpty

        //then
        // (8)

    }
}
