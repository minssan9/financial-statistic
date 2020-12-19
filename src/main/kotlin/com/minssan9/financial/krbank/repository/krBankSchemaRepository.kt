package com.minssan9.financial.krbank.repository

import com.minssan9.financial.krbank.domain.KrBankData
import com.minssan9.financial.krbank.domain.KrBankSchema
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface krBankSchemaRepository : JpaRepository<KrBankSchema, Long>{

}
