package com.service.repository;

import com.service.domain.KrBankData;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EcosDataRepoTest {

    EcosDataRepo ecosDataRepo;

    @Test
    void findByStat_codeAndItem_code1AndTimeBetween() {

        Page<KrBankData> krBankDatas = ecosDataRepo.findByStatCodeAndItemCode1AndTimeBetween(
                "064Y001", "0001000", "20210128", "20210128",  PageRequest.of(1,10 )
        );

    }
}
