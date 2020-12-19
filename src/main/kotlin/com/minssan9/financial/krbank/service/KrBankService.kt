package com.minssan9.financial.krbank.service

import com.google.gson.Gson
import com.minssan9.financial.config.AppProperties
import com.minssan9.financial.krbank.domain.KrBankData
import com.minssan9.financial.krbank.domain.KrBankSchema
import com.minssan9.financial.krbank.dto.KrBankDto
import com.minssan9.financial.krbank.repository.KrBankDataRepository
import com.minssan9.financial.krbank.repository.krBankSchemaRepository
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity


@Slf4j
@Service
interface KrBankService {
    fun getSchema(krBankRequest: KrBankDto.KrBankRequest): List<KrBankSchema>?
    fun getData(krBankRequest: KrBankDto.KrBankRequest): List<KrBankData>?
}
