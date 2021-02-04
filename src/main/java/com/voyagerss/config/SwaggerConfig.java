package com.voyagerss.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.*;

@Configuration
@EnableSwagger2
class SwaggerConfig {
    private String version;
    private String title;

    @Bean
    Docket apiV1() {
        version = "V1";
        title = "financial Index API $version";
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .groupName(version)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.voyagerss.financial.krbank"))
                .paths(PathSelectors.ant("/krbank/api/*"))
                .build();
    }

}
