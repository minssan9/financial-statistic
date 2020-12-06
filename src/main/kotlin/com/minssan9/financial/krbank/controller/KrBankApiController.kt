package com.minssan9.financial.krbank.controller

import com.minssan9.financial.krbank.service.KrBankApiService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/krbank/api")
class KrBankApiController {


    @Autowired
    private lateinit var krBankApiService: KrBankApiService

    @GetMapping("kospi")
    private fun getTemplates(): ResponseEntity<Any> {
        return ResponseEntity
                .ok()
                .body(krBankApiService.getKOSPI("20201101", "20201120"))
    }

//    @GetMapping("/{date}")
//    private fun getTemplateById(@PathVariable date: String): ResponseEntity<Any> {
//        return ResponseEntity
//                .ok()
//                .body(apiService.getData(date))
//    }
//
//    @GetMapping("")
//    private fun getTemplateByName(@RequestParam(value = "name") name: String): ResponseEntity<Any?> {
//        return ResponseEntity
//                .ok()
//                .body(apiService.getTemplateByName(name))
//    }
//
//    @PostMapping("")
//    private fun postTemplate(@RequestBody templateModel: TemplateModel): ResponseEntity<Any> {
//        apiService.saveTemplate(templateModel)
//        return ResponseEntity
//                .ok()
//                .body(true)
//    }
}
