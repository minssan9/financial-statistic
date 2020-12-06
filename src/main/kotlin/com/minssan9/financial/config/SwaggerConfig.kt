package com.minssan9.financial.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.service.VendorExtension
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.*
import kotlin.collections.ArrayList

@Configuration
@EnableSwagger2
class SwaggerConfig {
    private var version: String? = null
    private var title: String? = null

    @Bean
    fun apiV1(): Docket {
        version = "V1"
        title = "financial Index API $version"
        return Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .groupName(version)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.minssan9.financial.krbank"))
                .paths(PathSelectors.ant("/krbank/api/*"))
                .build()
    }

}
