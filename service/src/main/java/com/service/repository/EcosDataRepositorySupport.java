//package com.service.repository;
//
//import com.service.domain.KrBankData;
//import org.springframework.data.jpa.repository.query.JpaQueryMethodFactory;
//import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class EcosDataRepositorySupport extends QuerydslRepositorySupport {
//    private final JpaQueryMethodFactory factory;
//
//    public EcosDataRepositorySupport(JpaQueryMethodFactory factory) {
//        super(KrBankData.class);
//        this.factory = factory;
//    }
//
////    public List<KrBankData> findByStatCode(String statCode){
////        return factory
////                .selectFrom(krBankData)
////                .where(krBankData.statCode.eq(statCode))
////                .fetch();
////    }
//}
