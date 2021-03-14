package com.core.repo;

import com.core.domain.EcosSchema;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EcosSchemaRepo extends JpaRepository<EcosSchema, Long> {
    List<EcosSchema> findBySearchFlag(String searchFlag);

    List<EcosSchema> findByPstatcodeAndSearchFlag(String pstatcode, String searchFlag);

    List<EcosSchema> findByCycleAndSearchFlag(String cycle, String y);
}
