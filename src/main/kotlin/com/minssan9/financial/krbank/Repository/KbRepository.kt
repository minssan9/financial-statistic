package com.minssan9.financial.krbank.Repository

import com.minssan9.financial.krbank.Domain.KbData
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface KbRepository : JpaRepository<KbData, Long>{

}
