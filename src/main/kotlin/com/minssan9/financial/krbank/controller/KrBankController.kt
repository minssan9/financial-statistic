package com.minssan9.financial.krbank.controller

import com.minssan9.financial.krbank.dto.KrBankDto
import com.minssan9.financial.krbank.service.KrBankApiService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("krbank")
class KrBankController {
    @Autowired
    private lateinit var krBankApiService: KrBankApiService

    @GetMapping("kospi")
    private fun getTemplates(): ResponseEntity<Any> {
        var krBankData = krBankApiService.getKOSPI("20200101", "20201129", 1, 1000)?.let {
            it1 -> krBankApiService.saveData(it1)
        }

        return ResponseEntity
                .ok()
                .body(krBankData)
    }

    @GetMapping("schema/list/{statname}/{startPos}/{endPos}")
    private fun getSchema(@PathVariable statname:String,@PathVariable startPos:Long, @PathVariable endPos:Long ): ResponseEntity<Any> {
        var krBankRequest = KrBankDto.KrBankRequest("","","","","","",startPos, endPos)
        return ResponseEntity
            .ok()
            .body(krBankApiService.getSchemaFromAPI(krBankRequest))
    }

    @GetMapping("data/{code}/{option1}/{startDate}/{endDate}")
    private fun getData(@PathVariable code:String, @PathVariable option1:String,@PathVariable startPos:Long, @PathVariable endPos:Long ): ResponseEntity<Any> {
        var krBankRequest = KrBankDto.KrBankRequest("","","","","","",startPos, endPos)
        return ResponseEntity
            .ok()
            .body(krBankApiService.getSchemaFromAPI(krBankRequest))
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
