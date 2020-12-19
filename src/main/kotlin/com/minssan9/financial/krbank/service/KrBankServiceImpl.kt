package com.minssan9.financial.krbank.service

import com.minssan9.financial.config.AppProperties
import com.minssan9.financial.krbank.domain.KrBankData
import com.minssan9.financial.krbank.domain.KrBankSchema
import com.minssan9.financial.krbank.dto.KrBankDto
import com.minssan9.financial.krbank.repository.KrBankDataRepository
import com.minssan9.financial.krbank.repository.krBankSchemaRepository
import org.springframework.beans.factory.annotation.Autowired

class KrBankServiceImpl : KrBankService {
    @Autowired
    private lateinit var appProperties: AppProperties

    @Autowired
    lateinit var krBankDataRepository: KrBankDataRepository

    @Autowired
    lateinit var krBankSchemaRepository: krBankSchemaRepository

    override fun getSchema(krBankRequest: KrBankDto.KrBankRequest): List<KrBankSchema>? {
        return krBankSchemaRepository.findAll()
    }

    override fun getData(krBankRequest: KrBankDto.KrBankRequest): List<KrBankData>? {
        return krBankDataRepository.findAll()
    }

}
