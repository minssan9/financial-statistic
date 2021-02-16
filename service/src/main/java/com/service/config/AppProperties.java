package com.service.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


//@Configuration
//@ConfigurationProperties(prefix = "app")
@Component
public class AppProperties {
    @Value("${ecos-api-key}")
    private  String ecosApiKey;

    public String getEcosApiKey(){
        return this.ecosApiKey;
    }
    public void setEcosApiKey(@Value("${ecos-api-key}") String ecosApiKey) {
        this.ecosApiKey = ecosApiKey;
    }
}
