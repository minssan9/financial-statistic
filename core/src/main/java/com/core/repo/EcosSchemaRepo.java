package com.core.repo;

import com.core.dto.EcosEnumType.CycleType;
import com.core.dto.EcosEnumType.SearchFlag;
import com.core.domain.EcosSchema;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EcosSchemaRepo extends JpaRepository<EcosSchema, Long> {
    List<EcosSchema> findBySearchFlag(SearchFlag searchFlag);

    List<EcosSchema> findByPstatcodeAndSearchFlag(String pstatcode, SearchFlag searchFlag);

    List<EcosSchema> findByCycleAndSearchFlag(CycleType cycle, SearchFlag searchFlag);
}
