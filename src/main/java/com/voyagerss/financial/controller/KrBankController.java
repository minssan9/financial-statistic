package com.voyagerss.financial.controller;

;
import com.voyagerss.financial.domain.KrBankSchema;
import com.voyagerss.financial.dto.KrBankRequest;
import com.voyagerss.financial.service.KrBankApiService;
import org.hibernate.annotations.Any;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("krbank")
class KrBankController {
    @Autowired
    private KrBankApiService krBankApiService ;


    @GetMapping("schema/list/{statname}/{startPos}/{endPos}")
    private ResponseEntity getSchema(@PathVariable String statname, @PathVariable Long startPos, @PathVariable Long endPos ) {
        KrBankRequest krBankRequest = new KrBankRequest("","","","","","",startPos, endPos);
        return ResponseEntity
                .ok()
            .body(krBankApiService.getSchemaFromAPI(krBankRequest));
    }

    @GetMapping("data/{code}/{option1}/{startDate}/{endDate}")
    private ResponseEntity getData(@PathVariable String code, @PathVariable String option1,@PathVariable Long startPos, @PathVariable Long endPos ) {
        KrBankRequest krBankRequest = new KrBankRequest("","","","","","",startPos, endPos);
        return ResponseEntity
            .ok()
            .body(krBankApiService.getSchemaFromAPI(krBankRequest));
    }
//    @GetMapping("/{date}")
//    private  getTemplateById(@PathVariable date: String): ResponseEntity<Any> {
//        return ResponseEntity
//                .ok()
//                .body(apiService.getData(date))
//    }
//
//    @GetMapping("")
//    private  getTemplateByName(@RequestParam(value = "name") name: String): ResponseEntity<Any?> {
//        return ResponseEntity
//                .ok()
//                .body(apiService.getTemplateByName(name))
//    }
//
//    @PostMapping("")
//    private  postTemplate(@RequestBody templateModel: TemplateModel): ResponseEntity<Any> {
//        apiService.saveTemplate(templateModel)
//        return ResponseEntity
//                .ok()
//                .body(true)
//    }
}
