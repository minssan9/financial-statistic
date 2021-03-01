package com.core.repo;

import com.core.domain.EcosSchema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface EcosSchemaRepo extends JpaRepository<EcosSchema, Long> {

}
