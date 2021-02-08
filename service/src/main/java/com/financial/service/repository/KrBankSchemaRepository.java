package com.voyagerss.financial.repository;

import com.voyagerss.financial.domain.KrBankSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface KrBankSchemaRepository extends JpaRepository<KrBankSchema, Long> {

}
