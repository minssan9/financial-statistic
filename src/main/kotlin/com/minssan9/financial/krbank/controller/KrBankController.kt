package com.minssan9.financial.krbank.controller

import com.minssan9.financial.krbank.service.KrBankApiService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/krbankservice")
class KrBankController {
    @Autowired
    private lateinit var krBankApiService: KrBankApiService

    @GetMapping("kospi")
    private fun getTemplates(): ResponseEntity<Any> {
        var krBankData = krBankApiService.getKOSPI("20200101", "20201129")?.let {
            it1 -> krBankApiService.saveData(it1)
        }

        return ResponseEntity
                .ok()
                .body(krBankData)
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
