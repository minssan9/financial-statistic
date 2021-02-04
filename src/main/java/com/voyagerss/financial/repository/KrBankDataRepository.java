package com.voyagerss.financial.repository;

import com.voyagerss.financial.domain.KrBankData;
import com.voyagerss.financial.domain.KrBankData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface KrBankDataRepository extends JpaRepository<KrBankData, Long>{

}
