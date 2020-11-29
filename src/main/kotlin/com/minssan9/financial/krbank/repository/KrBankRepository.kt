package com.minssan9.financial.krbank.repository

import com.minssan9.financial.krbank.domain.KrBankData
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface KrBankRepository : JpaRepository<KrBankData, Long>{

}
