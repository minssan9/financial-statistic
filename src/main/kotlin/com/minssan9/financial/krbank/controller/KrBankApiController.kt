package com.minssan9.financial.krbank.controller

import com.minssan9.financial.krbank.dto.KrBankDto
import com.minssan9.financial.krbank.service.KrBankApiService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("krbankapi")
class KrBankApiController {
    @Autowired
    private lateinit var krBankApiService: KrBankApiService

    @GetMapping("kospi")
    private fun getTemplates(): ResponseEntity<Any> {
        return ResponseEntity
            .ok()
            .body(krBankApiService.getKOSPI("20201101", "20201120", 1, 1000))
    }

    @GetMapping("schema/update")
    @LogExecutionTime
    fun updateSchema(): ResponseEntity<Any> {
        var krBankRequest = KrBankDto
            .KrBankRequest("", "", "", "",
                "", "", 1, 1000)
        var krBankSchemas = krBankApiService.getSchemaFromAPI(krBankRequest)
        if (krBankSchemas != null) {
            krBankApiService.saveSchema(krBankSchemas)
        }

        return ResponseEntity
            .ok()
            .body()
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
