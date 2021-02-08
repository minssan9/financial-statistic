package com.financial.service.repository;

import com.financial.service.domain.KrBankData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface KrBankDataRepository extends JpaRepository<KrBankData, Long>{

}
