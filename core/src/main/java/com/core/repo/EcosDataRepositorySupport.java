package com.core.repo;

import com.core.domain.EcosData;
import com.core.domain.QEcosData;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class EcosDataRepositorySupport extends QuerydslRepositorySupport {

    public EcosDataRepositorySupport() {
        super(EcosData.class);
    }

    public List<EcosData> findByStatCode(String statCode){
        QEcosData ecosData = QEcosData.ecosData;

        return   from(ecosData)
            .where(ecosData.createdDate.eq("20210228")
            .and(ecosData.statCode.eq(statCode)))
            .fetch();
//        return factory
//                .selectFrom(krBankData)
//                .where(krBankData.statCode.eq(statCode))
//                .fetch();
    }
}
