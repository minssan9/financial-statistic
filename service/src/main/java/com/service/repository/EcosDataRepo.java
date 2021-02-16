package com.service.repository;

import com.service.domain.KrBankData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public
interface EcosDataRepo extends JpaRepository<KrBankData, Long> {
    @Query(value = "select * from krbankdata where statcode=:statCode and itemcode=:itemCode and time betwenn :startDate and :endDate ",
            countQuery = "select count(*) from krbankdata where statcode=:statCode and itemcode=:itemCode and createdDate betwenn :startDate and :endDate ", nativeQuery = true)
    Page<KrBankData> findByStatCodeAndItemCode1AndTimeBetween(String statCode, String itemCode, String startDate, String endDate, Pageable pageable);
}
