package com.minssan9.financial.krbank

import com.google.gson.Gson
import com.minssan9.financial.config.AppProperties
import com.minssan9.financial.dateFormatString
import com.minssan9.financial.krbank.domain.KrBankData
import com.minssan9.financial.krbank.dto.ApiDto
import com.minssan9.financial.krbank.repository.KrBankRepository
import com.minssan9.financial.krbank.service.ApiService

import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.json.simple.parser.JSONParser

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.context.annotation.Profile
import org.springframework.context.annotation.PropertySource
import java.time.LocalDateTime
import javax.transaction.Transactional


//@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(MockitoJUnitRunner::class)
@PropertySource("account")
@Profile("test")
class ApiServiceTest(@Autowired val restTemplate: TestRestTemplate, @Autowired val appProperties: AppProperties){

    @Autowired
    private lateinit var apiService: ApiService

    @Autowired
    private lateinit var krBankRepository: KrBankRepository

    @Test
    @Transactional
    fun krBankApiTest() {
        val gson = Gson()
        val jsonParser = JSONParser()
        //given
        var startDate =
                LocalDateTime.of(2020, 1, 1, 0, 0)
                        .format(dateFormatString)
        var endDate = LocalDateTime.now().format(dateFormatString)

//        var response: ResponseEntity<String> = restTemplate.getForEntity<String>(
//                "http://ecos.bok.or.kr/api/StatisticSearch/" + appProperties.krbankkey
//                        + "/json/kr/1/10/010Y002/MM/201101/201106/AAAA11/")

        var krBankData: List<KrBankData>? =        apiService.getKOSPI(
                "20200101",
                "20201129")
        krBankData?.forEach {
            i ->
            run {
                println(i)
                krBankRepository.save(i)
            }
        }

        //then
        // (8)

    }
}
