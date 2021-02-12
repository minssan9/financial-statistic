package com.service.repository;

import com.service.domain.KrBankData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface EcosDataRepo extends JpaRepository<KrBankData, Long>{

}
